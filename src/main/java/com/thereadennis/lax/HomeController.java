package com.thereadennis.lax;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sd.data.LacrosseFantasyDAO;
import com.sd.data.Player;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private LacrosseFantasyDAO lacrosseDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "GetInfo.do", method = RequestMethod.GET)
	public ModelAndView getInfo() {
	System.out.println("test");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("playerList", lacrosseDao.getPlayers());
		return mv;
	}
	
	@RequestMapping(value = "GetInfo.do", params="name", method = RequestMethod.GET)
	public ModelAndView getPlayerByName(@RequestParam("name") String n) {
		System.out.println("test");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("player", lacrosseDao.getPlayerByName(n));
		return mv;
	}
	@RequestMapping(value = "CreateNew.do", method = RequestMethod.GET)
	public ModelAndView createNew(Player player) {
		lacrosseDao.addFreeAgent(player);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("player", new Player());
		mv.addObject("playerList", lacrosseDao.getPlayers());
		return mv;
	}
	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("Delete") String playerName) {
		lacrosseDao.removePlayer(playerName);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("playerList", lacrosseDao.getPlayers());
		return mv;
	}
	@RequestMapping(value = "editPlayer.do", method = RequestMethod.GET)
	public ModelAndView editPlayer(@RequestParam("Edit") String playerName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("playerList", lacrosseDao.getPlayers());
		mv.addObject("player", lacrosseDao.getPlayerByName(playerName));
		return mv;
	}
	@RequestMapping(value = "edit.do", method = RequestMethod.GET)
	public ModelAndView edit(Player player) {
		System.out.println(player);
		lacrosseDao.editPlayer(player);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("playerList", lacrosseDao.getPlayers());
		mv.addObject("player", new Player());
		return mv;
	}
	
	
	
}
