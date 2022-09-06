import java.util.ArrayList;
import java.util.Scanner;

import Controller.Ascii_con;
import Controller.J_CON;
import Controller.L_CON;
import Controller.Music_con;
import Model.Dama_DTO;
import Model.User_DTO;

public class View {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J_CON con = new J_CON();
		L_CON logicCon = new L_CON();
		Ascii_con asciiCon = new Ascii_con();
		Music_con musicCon = new Music_con();

		musicCon.play(3);
		asciiCon.printASCII_Title();

		while (true) {
			logicCon.menuPrint();
			int menu = sc.nextInt();
			musicCon.stop();
			musicCon.play(0);
			if (menu == 1) { // 회원가입
				System.out.println("᠃ ⚘᠂ ⚘ ˚ ⚘ ᠂ ⚘ ᠃회원가입᠃ ⚘᠂ ⚘ ˚ ⚘ ᠂ ⚘ ᠃");
				System.out.print("ID를 입력해주세요 >> ");
				String id = sc.next();
				System.out.print("PW를 입력해주세요 >> ");
				String pw = sc.next();
				musicCon.play(0);
				con.join(id, pw);

			} else if (menu == 2) { // 로그인
				System.out.println();
				System.out.println("᠃ ⚘᠂ ⚘ ˚ ⚘ ᠂ ⚘ ᠃로그인᠃ ⚘᠂ ⚘ ˚ ⚘ ᠂ ⚘ ᠃");
				System.out.print("ID를 입력해주세요 >> ");
				String id = sc.next();
				System.out.print("PW를 입력해주세요 >> ");
				String pw = sc.next();
				musicCon.play(0);

				User_DTO user = new User_DTO(id, pw);
				String loginresult = con.userlogin(user);

				if (loginresult != null) { // 로그인 성공
					System.out.println("환영합니다 " + user.getId() + "님");
					while (true) {
						// 생존해있는 캐릭터 유무 체크
						Dama_DTO dama = con.damalogin(user.getId());
						System.out.println("。.。:+* ゜ ゜゜ *+:。.。:+* ゜ ゜゜ *+:。.。.。:+* ゜ ゜゜");
						System.out.println("[1]새 캐릭터 생성 [2]캐릭터 키우기 [3]캐릭터 현재 상태 보기 [4]뒤로 가기 >> ");
						int menu2 = sc.nextInt();
						musicCon.play(0);
						// 새 캐릭터 생성
						if (menu2 == 1) {
							if (dama != null) { // 생존해있는 캐릭터가 이미 있는 경우
								System.out.println("이미 생성된 캐릭터가 있습니다");
							} else {
								logicCon.prologue();
								System.out.println();
								System.out.print("알의 이름을 지어주세요 >> ");
								String nick = sc.next();
								musicCon.play(0);
								con.damajoin(user.getId(), nick);
							}
						} else if (menu2 == 2) { // 육성 기능
							if (dama == null) {
								System.out.println("캐릭터 생성 먼저 해주세요");
							} else {
								con.dateUpdate(dama);
								asciiCon.defaulPrint(dama);
								String needs = logicCon.needs(dama);
								System.out.println(dama.getNick() + "은/는 " + needs + "를 원하는 눈치이다");
								System.out.println("。.。:+* ゜ ゜゜ *+:。.。:+* ゜ ゜゜ *+:。.。.。:+* ゜ ゜゜");
								System.out.println("[1]잠자기 [2]밥먹기 [3]씻기 [4]놀기 [5]지켜보기 >> ");
								int menu3 = sc.nextInt(); // 세부메뉴 선택
								musicCon.play(0);
								if (menu3 == 1) {
									logicCon.sleep(dama, needs);
								} else if (menu3 == 2) {
									logicCon.feeding(dama, needs);
								} else if (menu3 == 3) {
									logicCon.shower(dama, needs);
								} else if (menu3 == 4) {
									logicCon.play(dama, needs);
								} else if (menu3 == 5) {
									logicCon.waiting(dama);
								} else {
									System.out.println("다시 선택해주세요");
								}
								
								if (logicCon.dead(dama) == true) {
									break;
								}
							}
						} // 육성기능 끝
						else if (menu2 == 3) { // 현재 상태 보기
							if (dama == null) {
								System.out.println("캐릭터 생성 먼저 해주세요");

							} else {
								asciiCon.defaulPrint(dama);
								// asciiCon.printASCII_A(dama);
								logicCon.show(dama);
							}
						} else if (menu2 == 4) { // 뒤로 가기
							System.out.println("메인화면으로 돌아갑니다");
							break;
						} else {
							System.out.println("다시 선택해주세요");
						}
					} // 로그인 세부메뉴 끝
				} else {
					System.out.println("아이디와 비밀번호를 다시 확인해주세요");
				} // 로그인 실패시
			} else if (menu == 3) { // 랭킹 보기
				ArrayList<Dama_DTO> rankList = new ArrayList<Dama_DTO>(con.rank());
				con.rankshow(rankList);

			} else if (menu == 4) {
				System.out.println("게임을 종료합니다");
				break;
			} else {
				System.out.println("다시 선택해주세요");
			}
		}
	}
}
