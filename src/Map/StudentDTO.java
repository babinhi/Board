package Map;

public class StudentDTO {
	//선생님 풀이법
	private Long id; //관리번호
	//  long으로 작성할 경우 값을 지정하지(?) 않았을때 0을 기본으로 부여 ->
	          //0이라는 값은 뭔가 데이터가 담겨있을수있다고 판단할수도 있음
	//int 형태보다는 Long형태를 많이 쓰는게 좋음 
	// int는 -23억까지의 숫자만 나타낼수있고 Long은 더 이상 나타낼수있다
	private String studentNumber; //학번
	private String studentName;   // 이름
	private String studentMajor;  // 전공
	private String studentMobile;  // 전화번호
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentMajor() {
		return studentMajor;
	}
	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}
	public String getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}
	
	@Override //상속받은 것을 재정의 한다는 의미
	public String toString() {
		return "StudentDTO [id=" + id + ", studentNumber=" + studentNumber + ", studentName=" + studentName
				+ ", studentMajor=" + studentMajor + ", studentMobile=" + studentMobile + "]";
	}
	
	
	

}
