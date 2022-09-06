package Model;

public class User_DTO {

	public static User_DTO user;

	private String id;
	private String pw;

	// 생성자
	public User_DTO() {
	}

	public User_DTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
