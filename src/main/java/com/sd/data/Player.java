package com.sd.data;

public class Player {
	private int playerNum;
	private String playerName;
	private String position;
	private String school;
	
	public Player(int playerNum, String playerName, String position, String school) {
		
		this.playerNum = playerNum;
		this.playerName = playerName;
		this.position = position;
		this.school = school;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "LacrosseRoster [playerNum=" + playerNum + ", playerName=" + playerName + ", position=" + position
				+ ", school=" + school + "]";
	}
	
	
	
	

}
