package chap06.admin.controller;

public class WorldCup {
	private int wid;
	private String name;
	private int voted;
	public WorldCup(int wid, String name, int voted) {
		this.wid = wid;
		this.name = name;
		this.voted  = voted;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVoted() {
		return voted;
	}
	public void setVoted(int voted) {
		this.voted = voted;
	}
	
	@Override
	public String toString() {
		return name+" 월드컵 게임";
	}
}
