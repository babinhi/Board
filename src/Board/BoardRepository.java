package Board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardRepository {
	Map<String, BoardDTO> B = new HashMap<>();
// private List<BoardDTO> list = new ArrayList<>();

	/*
	 * 리턴 타입이 무것이고 ? 메서드 이름은 무엇이고 배개변수는 어떤건지 분석을 해보는 것이 좋다
	 */

//	public boolean save(BoardDTO boardDTO) {
//		if (B.put(boardDTO.getBno(), boardDTO) != null) {
//			return true;
//		}
//		return false;
//	}
	public boolean save(String bno, BoardDTO boardDTO) {
//		System.out.println("BoardDTORepository.save()" + boardDTO);
//		초기에는 stsout을 써서 확인하		
		B.put(bno, boardDTO); // bno 이나 boardDTO.gerBno이나 괜찮음
		return true;
		// 리스트 안의 add메소드를 통해 boardDTO 값이 넣어지면 true, 안 넣어지면 false을 boolean으로 리턴해줌
	}

	public Map<String, BoardDTO> findAll() {
		return B;
	}

	public BoardDTO findById(String bno) {

		/*
		 * map은 반복문을 돌리고 
		 * bno와 일치하는 객채를 찾고 
		 * 찾으면 리턴함
		 */
		for (String Bno : B.keySet()) {
			if (B.get(Bno).getBno().equals(bno)) {
				return B.get(bno);
			}
		}
		return null;
	}

	public boolean update(BoardDTO boardDTO, String bno) {
		for (String Bno : B.keySet()) {
			if (B.get(Bno).getBno().equals(bno)) {
				B.get(Bno).setTitle(boardDTO.getTitle());
				B.get(Bno).setWriter(boardDTO.getWriter());
				return true;
			}
		}
		return false;
	}

	public boolean delete(String bno) {
		for (String Bno : B.keySet()) {
			if (B.get(Bno).getBno().equals(bno)) {
				B.remove(bno);
				return true;
			}
		}
		return false;
	}

	public List<BoardDTO> search(String writer) {
		//검색 결과를 담을 리스트 
		List<BoardDTO> list = new ArrayList<>();
		for (String Bno : B.keySet()) {
			if(writer.equals(B.get(Bno).getWriter())) {
				list.add(B.get(Bno));
			}
//			if(B.get(Bno).getWriter().equals(writer)) {
//				list.add(B.get(Bno));
//			}
		}return list;
	}

}
