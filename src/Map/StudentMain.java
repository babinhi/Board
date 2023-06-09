package Map;
import java.util.*;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//선생님 풀이법
		//학생정보를 관리할 Map
		
		Map<Long, StudentDTO> studentMap = new HashMap<>();
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentNumber("1111");
		studentDTO.setStudentName("김자바");
		studentDTO.setStudentMajor("컴퓨터공학");
		studentDTO.setStudentMobile("010-1111-1111");

		studentMap.put(studentDTO.getId(), studentDTO);
		
		StudentDTO studentDTO1 = new StudentDTO();
		studentDTO1.setId(2L);
		studentDTO1.setStudentNumber("2222");
		studentDTO1.setStudentName("이자바");
		studentDTO1.setStudentMajor("경영학");
		studentDTO1.setStudentMobile("010-2222-2222");

		studentMap.put(studentDTO1.getId(), studentDTO1);
		
		
		StudentDTO studentDTO2 = new StudentDTO();
		studentDTO2.setId(3L);
		studentDTO2.setStudentNumber("3333");
		studentDTO2.setStudentName("박자바");
		studentDTO2.setStudentMajor("전자공학");
		studentDTO2.setStudentMobile("010-3333-3333");

		studentMap.put(studentDTO2.getId(), studentDTO2);
		
		StudentDTO studentDTO3 = new StudentDTO();
		studentDTO3.setId(3L);
		studentDTO3.setStudentNumber("3333");
		studentDTO3.setStudentName("박자바");
		studentDTO3.setStudentMajor("전자공학");
		studentDTO3.setStudentMobile("010-3333-3333");

		System.out.println(studentDTO2.equals(studentDTO3));
		System.out.println(studentDTO2.getId().equals(studentDTO3.getId()));
		
		studentMap.put(studentDTO2.getId(), studentDTO2);
		 
		
		//eqlus 값이 같은지 비교할때 사용
		for(Long id : studentMap.keySet()) {
			System.out.println(id);
			System.out.println(studentMap.get(id)); //student 객체
			//학생의 이름만 출력하고 싶다?
			System.out.println(studentMap.get(id).getStudentName());
		}
		

	}

}
