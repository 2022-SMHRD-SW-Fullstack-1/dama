package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Dama_DTO;
import Model.User_DTO;

public class J_CON {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	int cnt = 0; // executeUpdate의 결과값을 담아주는 변수

	// 데이터베이스 접속
	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_k_0830_5";
			String db_pw = "smhrd5";

			conn = DriverManager.getConnection(url, db_id, db_pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 사용된 객체를 닫아주는 메소드
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// [1] 회원가입
	// - DB 접속 -> 메소드로 로직을 정리하여 따로 뽑아내기
	public int join(String id, String pw) {
		getCon();
		try {
			String sql = "insert into USER_INFO values(?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			cnt = psmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("회원가입 성공!");
			} else {
				System.out.println("회원가입 실패");
			}

		} catch (SQLException e) {
			System.out.println("이미 존재하는 아이디입니다");
		} finally {
			close();
		}
		return cnt;
	}

	// [2] 유저로그인
	public String userlogin(User_DTO user) {
		String loginresult = null; // 결과값 리턴을 위한 변수

		getCon();
		try {
			String sql = "select user_id from user_info where user_id = ? and user_pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPw());

			rs = psmt.executeQuery();

			if (rs.next()) {
				loginresult = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return loginresult;
	}

	// 생존해있는 캐릭터 유무 체크 - 삭제 예정 메소드
	public String logincheck(String id, String pw) {
		getCon();
		String result = null; // 결과값 리턴을 위한 변수
		try {
			String sql = "select nick from dama where (clean > 0 and feed > 0 and likeness > 0) and id = (select user_id from user_info where user_id = ? and user_pw = ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {
				result = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	// 생존해있는 캐릭터 불러오기
	public Dama_DTO damalogin(String user_id) {
		getCon();
		Dama_DTO dama = null;
		try {
			String sql = "select nick, type, exp, lev, id, dama_date, feed, clean, hp, joy from dama where feed>0 and clean>0 and hp>0 and joy>0 and id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String nick = rs.getString(1);
				String type = rs.getString(2);
				int exp = rs.getInt(3);
				int lev = rs.getInt(4);
				String id = rs.getString(5);
				String date = rs.getString(6);
				int feed = rs.getInt(7);
				int clean = rs.getInt(8);
				int hp = rs.getInt(9);
				int joy = rs.getInt(10);
				dama = new Dama_DTO(nick, type, exp, lev, id, date, feed, clean, hp, joy);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dama;
	}

	// 캐릭터 등록
	public void damajoin(String user_id, String nick) {
		getCon();
		try {
			String sql = "insert into dama values(?, ?, ?, ?, ?,sysdate,?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, nick);
			psmt.setString(2, "알");
			psmt.setInt(3, 0);
			psmt.setInt(4, 1);
			psmt.setString(5, user_id);
			psmt.setInt(6, 50);
			psmt.setInt(7, 50);
			psmt.setInt(8, 50);
			psmt.setInt(9, 50);
			cnt = psmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(nick + "이/가 생성되었습니다");
			}

		} catch (SQLException e) {
			System.out.println("이미 존재하는 별명입니다");
		} finally {
			close();
		}
	}

	// 스탯 변화
	public void update(Dama_DTO dama, int feed, int clean, int hp, int joy, int exp) {
		getCon();
		try {
			dama.setFeed(feed + dama.getFeed());
			dama.setClean(clean + dama.getClean());
			dama.setHp(hp + dama.getHp());
			dama.setJoy(joy + dama.getJoy());
			dama.setExp(exp + dama.getExp());

			String sql = "update dama set feed =?, clean =?, hp=?, joy=?, exp=? where id=? and nick=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dama.getFeed());
			psmt.setInt(2, dama.getClean());
			psmt.setInt(3, dama.getHp());
			psmt.setInt(4, dama.getJoy());
			psmt.setInt(5, dama.getExp());
			psmt.setString(6, dama.getId());
			psmt.setString(7, dama.getNick());

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 레벨 업
	public void levelUp(Dama_DTO dama) {
		getCon();
		try {
			dama.setExp(0);
			dama.setLev(1 + dama.getLev());
			if (dama.getLev() == 3) {
				System.out.println("알이 부화했습니다!!");
				dama.setType("아기새");
			}
			if (dama.getLev() == 10) {
				System.out.println("아기새가 성장했습니다!!");
				int growth = (int) Math.random() * 3;
				if (growth == 0) {
					dama.setType("비둘기");
				} else if (growth == 1) {
					dama.setType("오리");
				} else {
					dama.setType("닭");
				}
			}
			String sql = "update dama set exp =?, lev =?, type=? where id=? and nick=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dama.getExp());
			psmt.setInt(2, dama.getLev());
			psmt.setString(3, dama.getType());
			psmt.setString(4, dama.getId());
			psmt.setString(5, dama.getNick());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	//랭킹 보기 
	public ArrayList<Dama_DTO> rank() {
		// 전체 회원의 정보를 담을 수 있는 ArrayList 만들기
		ArrayList<Dama_DTO> totalList = new ArrayList<>();

		getCon();
		try {
			String sql = "SELECT row_number() OVER (ORDER BY lev DESC) as 등수, nick, lev, id, dama_date FROM dama";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				int rank = rs.getInt(1);
				String nick = rs.getString(2);
				int lev = rs.getInt(3);
				String id = rs.getString(4); 
				String date = rs.getString(5); 

				Dama_DTO rankin = new Dama_DTO(rank, nick, lev, id, date);
				totalList.add(rankin);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			close();
		}
		return totalList;
	}
	
	
	public void rankshow(ArrayList<Dama_DTO> rankList){
	System.out.println("====랭킹====");
	// ArrayList 출력!
	System.out.println("등수 / 별명 / 레벨 / 아이디/ 최근 접속날짜");
	for (int i = 0; i < rankList.size(); i++) {
		System.out.println(rankList.get(i).getRank() + " / " + rankList.get(i).getNick() + " / "
				+ rankList.get(i).getLev() + " / " + rankList.get(i).getId() + " / "
				+ rankList.get(i).getDate());
	}
	}
	
}
