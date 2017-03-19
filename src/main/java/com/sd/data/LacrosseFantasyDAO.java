package com.sd.data;

import java.util.List;

public interface LacrosseFantasyDAO {
	public void addFreeAgent(Player player);
	public Player getPlayerByName(String name);
	public Player getPlayerByNumber(int playerNum);
	public Player getPlayerByPosition(String position);
	public List<Player> getPlayers();
	public void removePlayer(String name);
	Player editPlayer(Player player);


}
