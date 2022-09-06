package Controller;

import Model.Dama_DTO;

public class L_CON {

	J_CON con = new J_CON();
	Ascii_con ascii_con = new Ascii_con();


	// 업데이트문 순서
	// public void update(Dama_DTO dama, int feed, int clean, int hp, int joy, int
	// exp)
	public void play(Dama_DTO dama, String needs) {// 놀아주기
		// 90%로 보통 놀기
		try {
			ascii_con.printASCII_Joy_A();
			System.out.println();
			System.out.println();
			Thread.sleep(500);
			ascii_con.printASCII_Joy_B();
			System.out.println();
			System.out.println();
			Thread.sleep(500);
				ascii_con.printASCII_Joy_C();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!needs.equals("놀기")) {
			System.out.println(dama.getNick() + "은/는 별로 놀고싶지 않은 것 같다...");
			con.update(dama, -5, -5, -5, 10, 10);
		} else if (((int) (Math.random() * 10) + 1) != 10) {
			System.out.println("");
			System.out.println(dama.getNick() + "와/과 그럭저럭 놀아주었다");
			con.update(dama, -5, -5, -5, 20, 20);
		} else { // 10%로 잘 놀기
			System.out.println(dama.getNick() + "와/과 재밌게 놀았다!");
			con.update(dama, -5, -5, -5, 20, 40);
		}
		
		if (dama.getExp() >= 100) {
			con.levelUp(dama);
		}
		maxSt(dama);
	}

	public void feeding(Dama_DTO dama, String needs) {// 밥주기
		try {
			ascii_con.printASCII_Feeding_A();
			System.out.println();
			System.out.println();
			Thread.sleep(500);
			ascii_con.printASCII_Feeding_B();
			System.out.println();
			System.out.println();
			Thread.sleep(500);
				ascii_con.printASCII_Feeding_C();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// 90%로 보통 먹기
		if(!needs.equals("밥먹기")) {
			System.out.println(dama.getNick() + "은/는 별로 먹고싶지 않은 것 같다...");
			con.update(dama, 10, -5, -5, -5, 10);
			} else if (((int) (Math.random() * 10) + 1) != 10) {
			System.out.println(dama.getNick() + "은/는 밥을 먹었다");
			con.update(dama, 20, -5, -5, -5, 20);
		} else {// 10%로 잘먹기
			System.out.println(dama.getNick() + "은/는 밥을 만족스럽게 먹었다!");
			con.update(dama, 20, -5, -5, -5, 40);
		}
		if (dama.getExp() >= 100) {
			con.levelUp(dama);
		}
		maxSt(dama);
	}

	public void shower(Dama_DTO dama, String needs) {// 씻겨주기
		// 90%로 그냥 씻기
		try {
			ascii_con.printASCII_Clean_A();
			System.out.println();
			System.out.println();
			Thread.sleep(500);
			ascii_con.printASCII_Clean_B();
			System.out.println();
			System.out.println();
			Thread.sleep(500);
				ascii_con.printASCII_Clean_C();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!needs.equals("씻기")) {
			System.out.println(dama.getNick() + "은/는 별로 씻고싶지 않은 것 같다...");
			con.update(dama, -5, 10, -5, -5, 10);
			} else if (((int) (Math.random() * 10) + 1) != 10) {
			System.out.println(dama.getNick() + "을/를 씻겨주었다");
			con.update(dama, -5, 20, -5, -5, 20);
		} else {// 잘 씻기
			System.out.println(dama.getNick() + "을/를 뽀송뽀송 깨끗하게 씻겨주었다!");
			con.update(dama, -5, 20, -5, -5, 40);
		}
		if (dama.getExp() >= 100) {
			con.levelUp(dama);
		}
		maxSt(dama);
	}

	public void sleep(Dama_DTO dama, String needs) {// 재우기
		try {
			ascii_con.printASCII_Sleep_A();
			System.out.println();
			System.out.println();
			Thread.sleep(500);
			ascii_con.printASCII_Sleep_B();
			System.out.println();
			System.out.println();
			Thread.sleep(500);
				ascii_con.printASCII_Sleep_C();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!needs.equals("잠자기")) {
			System.out.println(dama.getNick() + "은/는 별로 자고싶지 않은 것 같다...");
			con.update(dama, -5, -5, 10, -5, 10);
			} else if (((int) (Math.random() * 10) + 1) != 10) {
			System.out.println(dama.getNick() + "은/는 잠에 들었다...");
			con.update(dama, -5, -5, 20, -5, 20);
		} else {// 잘 재우기
			System.out.println(dama.getNick() + "은/는 푹 잠에 든 듯하다...zZ");
			con.update(dama, -5, -5, 20, -5, 40);
		}
		if (dama.getExp() >= 100) {
			con.levelUp(dama);
		}
		maxSt(dama);
	}

	public void waiting(Dama_DTO dama) {// 지켜보기
		System.out.println(dama.getNick()+"을/를 지켜본다...");
		System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\r\n"
				+ "█░░░░░░░░▀█▄▀▄▀██████░▀█▄▀▄▀██████░\r\n"
				+ "░░░░░░░░░░░▀█▄█▄███▀░░░ ▀██▄█▄███▀░\r\n"
				);
		try {
			ascii_con.printASCII_A(dama);
			System.out.println();
			System.out.println();
			Thread.sleep(1500);
			ascii_con.printASCII_B(dama);
			System.out.println();
			System.out.println();
			Thread.sleep(1500);
			ascii_con.printASCII_C(dama);
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	public String needs(Dama_DTO dama) { // needs를 랜덤으로 출력해주는 함수, 만약 25이하인 수치가 있으면 그 욕구를 출력
		int needsrd = (int) (Math.random() * 4) + 1;
		String needs;

		if (dama.getFeed() > 25 && dama.getClean() > 25 && dama.getJoy() > 25 && dama.getHp() > 25) {
			if (needsrd == 1) {
				needs = "잠자기";
			} else if (needsrd == 2) {
				needs = "밥먹기";
			} else if (needsrd == 3) {
				needs = "씻기";
			} else {// 4
				needs = "놀기";
			}
		} else { // 특정 욕구가 25이하이면, 그 욕구를 원한다고 출력
			if (dama.getHp() <= 25) {
				needsrd = 1;
			} else if (dama.getFeed() <= 25) {
				needsrd = 2;
			} else if (dama.getClean() <= 25) {
				needsrd = 3;
			} else {
				needsrd = 4;
			}

			if (needsrd == 1) {
				needs = "잠자기";
			} else if (needsrd == 2) {
				needs = "밥먹기";
			} else if (needsrd == 3) {
				needs = "씻기";
			} else {// 4
				needs = "놀기";
			}
		}
		return needs;
	}

	public void show(Dama_DTO dama) {
		System.out.println("이름 : " + dama.getNick());
		System.out.println("타입 : " + dama.getType());
		System.out.println("레벨 : " + dama.getLev());
		System.out.println("경험치 : " + dama.getExp());

		// 체력
		System.out.print("체 력 :  ");
		for (int i = 1; i <= 10; i++) {
			if (dama.getHp() / 10 >= i) { // play의 값의 자리수의 갯수 따라 특수문자 출력
				System.out.print("■"); // 그렇지 않으면 ■ 출력
				// j의 값을 10으로 나눈 몫이 i보다 크거나 같은면 □ 출력
			} else {
				System.out.print("□");
				// 그렇지 않으면 ■ 출력
			}
		}
		System.out.println();

		// 포만감
		System.out.print("포만감 : ");
		for (int i = 1; i <= 10; i++) {
			if (dama.getFeed() / 10 >= i) { // play의 값의 자리수의 갯수 따라 특수문자 출력
				System.out.print("■"); // 그렇지 않으면 ■ 출력
				// j의 값을 10으로 나눈 몫이 i보다 크거나 같은면 □ 출력
			} else {
				System.out.print("□");
				// 그렇지 않으면 ■ 출력
			}
		}
		System.out.println();

		// 청결
		System.out.print("깨끗함 : ");
		for (int i = 1; i <= 10; i++) {
			if (dama.getClean() / 10 >= i) { // play의 값의 자리수의 갯수 따라 특수문자 출력
				System.out.print("■"); // 그렇지 않으면 ■ 출력
				// j의 값을 10으로 나눈 몫이 i보다 크거나 같은면 □ 출력
			} else {
				System.out.print("□");
				// 그렇지 않으면 ■ 출력
			}
		}
		System.out.println();

		// 즐거음
		System.out.print("즐거움 : ");
		for (int i = 1; i <= 10; i++) {
			if (dama.getJoy() / 10 >= i) { // play의 값의 자리수의 갯수 따라 특수문자 출력
				System.out.print("■"); // 그렇지 않으면 ■ 출력
				// j의 값을 10으로 나눈 몫이 i보다 크거나 같은면 □ 출력
			} else {
				System.out.print("□");
				// 그렇지 않으면 ■ 출력
			}
		}
		System.out.println();

	}

	public void prologue() {
		System.out.println(
				"┊　　┊　　┊ 　 ┊    　┊　   ┊　 ┊\r\n" + "┊　　┊　　┊ 　 ☆    　┊　   ┊　 ┊\r\n" + "┊　　┊　　 ✬ 　 　   　✬ 　  ┊　 ┊\r\n"
						+ "┊　　★ 　　　 　 　    　　　   ★　 ┊\r\n" + "☆ 　　 　　　 　 　    　　　　　　 ☆\r\n" + "");
		System.out.println("평소처럼 지친 몸을 끌고 집에 가던 당신... ");
		System.out.println();
		System.out.println("오잉?!");
		System.out.println("하늘에서 갑자기 무언가가 떨어지는데...");
		System.out.println();
		
		try {
			Thread.sleep(1500);
			ascii_con.printASCII_Start_A();
			System.out.println();
			System.out.println();
			Thread.sleep(1500);
			ascii_con.printASCII_Start_B();
			System.out.println();
			System.out.println();
			Thread.sleep(1500);
			ascii_con.printASCII_Start_C();
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("반사적으로 받아보니 어라? .... 이건?");
		System.out.println("알.......?");
		System.out.println("하늘에서 알이 떨어지다니.... ");
		System.out.println("혹시 알을 잘 키우면 보답을 받을지도?");
		System.out.println("................");
		System.out.println("당신은 이 알을 키우기로 마음 먹었다!");
		System.out.println("이 알을 잘 키워보자!");

	}

	public void menuPrint() {
		System.out.println(" ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
				+ "|　메뉴     　　　　　　　　　　　　　　　　　　　　　　[－][口][×] |\r\n" + "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣ |\r\n"
				+ "|　 ＿＿＿＿＿＿　　  ＿＿＿＿＿＿　　 ＿＿＿＿＿＿　　 ＿＿＿＿＿＿　  |\r\n" + "| ｜1.회원가입 |　 ｜2.로그인 |  | 3.랭킹  |　 ｜ 4.종료  |  |\r\n"
				+ "|　 ￣￣￣￣￣￣　　  ￣￣￣￣￣￣　　 ￣￣￣￣￣￣　   ￣￣￣￣￣￣   |\r\n" + "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
		System.out.print("선택 >> ");
	}

	public boolean dead(Dama_DTO dama) {
		boolean dead = false;
		if (dama.getFeed() <= 0 || dama.getClean() <= 0 || dama.getJoy() <= 0 || dama.getHp() <= 0) {
			System.out.println();
			System.out.println("어.......?");
			System.out.println(dama.getNick() + "의 상태가 이상하다....");
			System.out.println("...............");
			System.out.println(dama.getNick() + "이/가 움직이지 않는다....");
			System.out.println("...............");
			System.out.println("미안해..... " + dama.getNick() + ".......");
			System.out.println(dama.getNick() + "은/는 무지개다리를 건넜습니다");
			System.out.println();
			dead = true;
		}
		return dead;
	}


	public void maxSt(Dama_DTO dama) {// 스탯이 100초과하면, 초과한 스탯을 100으로 고정
		if (dama.getClean() > 100) {
			dama.setClean(100);
		}
		if (dama.getFeed() > 100) {
			dama.setFeed(100);
		}
		if (dama.getHp() > 100) {
			dama.setHp(100);
		}
		if (dama.getJoy() > 100) {
			dama.setJoy(100);
		}
	}

}
