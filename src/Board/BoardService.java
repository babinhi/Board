package Board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BoardService {
	BoardRepository br = new BoardRepository();
	Scanner sc = new Scanner(System.in);
//	Map<Integer, BoardDTO> B = new HashMap<>();
//	List<String> keyList = new ArrayList<>();

	public void save() {
		BoardDTO boardDTO = new BoardDTO();
//		System.out.println("BoardDTO 객체 생성 후 " + boardDTO);
		System.out.print("제목> ");
		boardDTO.setTitle(sc.nextLine());
		System.out.print("작성자> ");
		boardDTO.setWriter(sc.next());
		sc.nextLine();
		boolean success = br.save(boardDTO.getBno(), boardDTO);
		if (success) {
			System.out.println("게시글 등록완료!");
		} else {
			System.out.println("게시글 등록실패ㅜ");
		}
	}

	public void findAll() {
		Map<String, BoardDTO> B = br.findAll(); // value를 기준으로 정렬을 하려면 힘듦

//		Map<Integer , String> num = new HashMap<Integer, String>();
		System.out.println("글번호\t제목\t작성자\t조회수\t게시일");
		System.out.println("--------------------------------------");
		List<String> keySet = new ArrayList<>(B.keySet());
		// 키 값으로 오름차순 정렬
		Collections.sort(keySet); 
		for (String key : keySet) {
//        	System.out.println(key); //bno번호만 뜸 
			System.out.println(B.get(key));
			// 순서 상관 없는 정렬 ↓
//		for(String b : B.keySet()) { //
////			System.out.println(b);
//			System.out.println(B.get(b));

			// 키 값으로 내림차순 정렬
//            Collections.reverse(keySet);

		}
	}

	public void findById() {

		System.out.print("읽을 글번호> ");
		String bno = sc.next();
		BoardDTO boardDTO = br.findById(bno);
		if (boardDTO == null) {
			System.out.println("찾을 수 없는 글입니다");
		} else {
			boardDTO.increaseCnt();
			System.out.println("글번호\t제목\t작성자\t조회수\t게시일");
			System.out.println("──────────────────────────────────────────────────────");
			System.out.println(boardDTO.toString());

		}
	}

	public void update() {
		System.out.print("수정할 글번호> ");
		String bno = sc.next();
		sc.nextLine();
		BoardDTO b = br.findById(bno);
		if (b == null) {
			System.out.println("조회할 수 없는 글번호 입니다");
		} else {
			BoardDTO boardDTO = new BoardDTO();
			System.out.print("수정할 제목> ");
			boardDTO.setTitle(sc.nextLine());
			System.out.print("수정할 작성자> ");
			boardDTO.setWriter(sc.next());
			sc.nextLine();
			if (br.update(boardDTO, bno)) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}
		}
	}

//refactoring 외부 동작을 바꾸지 않으면서 내부 구조를 개선하는 방법
	public void delete() {
		System.out.print("삭제할 글번호> ");
		String bno = sc.next();
		sc.nextLine();
		if (br.delete(bno)) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제실패");
		}
	}

	public void testData() {
		boolean success = false;
		for (int i = 0; i < 5; i++) {

			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setTitle("Title" + i);
			boardDTO.setWriter("Writer" + i);

			success = br.save(boardDTO.getBno(), boardDTO);
		}
//		if (success) {
//			System.out.println("test는 싫음");
//		} else {
//			System.out.println("개싫음");
//		}
	}
	public void search() {

		System.out.print("찾고 싶은 작가의 이름 >");
		String writer = sc.next(); 
		sc.nextLine();
		List<BoardDTO> list = br.search(writer);
	
		if(list == null) {
			System.out.println("찾을 수 없는 이름입니다");
		}else {
			for(BoardDTO bList : list) {
				
				System.out.println(bList);
			}
		}
//		if(br.search(writer) != null) {
//			System.out.println("글번호\t제목\t작성자\t조회수\t게시일");
//			System.out.println("──────────────────────────────────────────────────────");
//			System.out.println(boardDTO.toString());
//		}else {
//			System.out.println("검색하신 작가가 없습니다");
//		}
		
	}


}
