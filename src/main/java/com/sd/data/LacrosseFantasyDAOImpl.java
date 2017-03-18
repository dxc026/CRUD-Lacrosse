package com.sd.data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.omg.PortableServer.POAManagerPackage.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class LacrosseFantasyDAOImpl implements LacrosseFantasyDAO{
	
	private static final String FILE_NAME="/WEB-INF/roster.csv";
	private List<Player> players = new ArrayList<>();
	/*
	 * Use Autowired to have Spring inject an instance
	 * of a WebApplicationContext into this object after
	 * creation.  We will use the WebApplicationContext to
	 * retrieve an ServletContext so we can read from a 
	 * file.
	 */
	@Autowired 
	private WebApplicationContext wac;

	/*
	 * The @PostConstruct method is called by Spring after 
	 * object creation and dependency injection
	 */
	@PostConstruct
	public void init() {
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		System.out.println("in methodss");
		try (
				InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));
			) {
			System.out.println("in try");
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				System.out.println("in while");
				String[] tokens = line.split(", ");
				int playerNum = Integer.parseInt(tokens[0]);
				String playerName = tokens[1];
				String position = tokens[2];
				String school = tokens[3];
				System.out.println(playerNum);
				players.add(new Player(playerNum, playerName, position, school));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public void addFreeAgent(Player player) {
		players.add(player);
		
	}

	@Override
	public Player getPlayerByName(String name) {
		Player p = null;
		for (Player pl : players) {
			if (pl.getPlayerName().equals(name)) {
				p = pl;
				break;
			}
		}
		return p;		
	}

	@Override
	public Player getPlayerByNumber(int playerNum) {
		Player p = null;
		for (Player pl : players) {
			if (pl.getPlayerNum()==playerNum) {
				p = pl;
				break;
			}
		}
		return p;		
	}

	@Override
	public Player getPlayerByPosition(String position) {
		Player p = null;
		for (Player pl : players) {
			if (pl.getPlayerName().equals(position)) {
				p = pl;
				break;
			}
		}
		return p;		
	}

	@Override
	public List<Player> getPlayers() {
		return players;
		
	}
	@Override
    public void removePlayer() {
        int index = 0;
            for (Beer beer2 : beers) {
                if(beer2.getName().equals(name)){
                    index = beers.indexOf(beer2);
                    break;
                }
            }
        beers.remove(index);
    }
}
