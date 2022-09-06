package Model;

public class Dama_DTO {

	private String nick;
	private String type;
	private int exp;
	private int lev;
	private String id;
	private String date;
	private int feed;
	private int clean;
	private int hp;
	private int joy;
	
	private int rank;
	
	public Dama_DTO(String nick, String type, int exp, int lev, String id, String date, int feed, int clean, int hp,
			int joy) {
		this.nick = nick;
		this.type = type;
		this.exp = exp;
		this.lev = lev;
		this.id = id;
		this.date = date;
		this.feed = feed;
		this.clean = clean;
		this.hp = hp;
		this.joy = joy;
	}

	public Dama_DTO(int rank, String nick, int lev, String id, String date) {
		this.rank = rank;
		this.nick = nick;
		this.lev = lev;
		this.id = id;
		this.date = date;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getFeed() {
		return feed;
	}

	public void setFeed(int feed) {
		this.feed = feed;
	}

	public int getClean() {
		return clean;
	}

	public void setClean(int clean) {
		this.clean = clean;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getJoy() {
		return joy;
	}

	public void setJoy(int joy) {
		this.joy = joy;
	}

	public int getRank() {
		return rank;
	}


}
