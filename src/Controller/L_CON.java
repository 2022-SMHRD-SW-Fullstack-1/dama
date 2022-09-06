package Controller;

import Model.Dama_DTO;

public class L_CON {

	J_CON con = new J_CON();

	public L_CON() {
	}

	// 업데이트문 순서
	// public void update(Dama_DTO dama, int feed, int clean, int hp, int joy, int exp)
	public void play(Dama_DTO dama) {// 놀아주기
		// 90%로 보통 놀기
		if (((int) Math.random() * 10 + 1) != 10) {
			System.out.println("놀았다");
			con.update(dama, -5, -5, -5, 20, 20);
		} else { // 10%로 잘 놀기
			System.out.println("재밌게 놀았다");
			con.update(dama, -5, -5, -5, 20, 40);
		}
		if (dama.getExp() >= 100) {
			con.levelUp(dama);
		}
	}

	public void feeding(Dama_DTO dama) {// 밥주기
		// 90%로 보통 먹기
		if (((int) Math.random() * 10 + 1) != 10) {
			System.out.println("그냥 먹었다");
			con.update(dama, 20, -5, -5, -5, 20);
		} else {// 10%로 잘먹기
			System.out.println("만족스럽게 먹었다");
			con.update(dama, 20, -5, -5, -5, 40);
		}
		if (dama.getExp() >= 100) {
			con.levelUp(dama);
		}
	}

	public void shower(Dama_DTO dama) {// 씻겨주기
		// 90%로 그냥 씻기
		if (((int) Math.random() * 10 + 1) != 10) {
			System.out.println("씻기는 기능");
			con.update(dama, -5, 20, -5, -5, 20);
		} else {// 잘 씻기
			System.out.println("깨끗하게 씻었다.");
			con.update(dama, -5, 20, -5, -5, 40);
		}
		if (dama.getExp() >= 100) {
			con.levelUp(dama);
		}
	}

	public void sleep(Dama_DTO dama) {// 재우기
		if (((int) Math.random() * 10 + 1) != 10) {
			System.out.println("재우는 기능");
			con.update(dama, -5, -5, 20, -5, 20);
		} else {// 잘 재우기
			con.update(dama, -5, -5, 20, -5, 40);
		}
		if (dama.getExp() >= 100) {
			con.levelUp(dama);
		}
	}

	public void waiting(Dama_DTO dama) {// 지켜보기
		System.out.println("지켜보는 기능");
	}

	public String needs(Dama_DTO dama) { // needs를 랜덤으로 출력해주는 함수, 만약 25이하인 수치가 있으면 그 욕구를 출력
		int needsrd = (int) Math.random() * 4 + 1;
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
		System.out.println("경험치 : " + dama.getExp());
		System.out.println("레벨 : " + dama.getLev());
		System.out.println("포만감 : " + dama.getFeed());
		System.out.println("청결도 : " + dama.getClean());
		System.out.println("즐거움 : " + dama.getJoy());
		System.out.println("체력 : "+dama.getHp());
	}
	
	
	
}

