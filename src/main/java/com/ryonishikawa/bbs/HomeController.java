package com.ryonishikawa.bbs;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ryonishikawa.bbs.model.Article;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	HttpServletRequest request;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		HttpSession ses = request.getSession(false);
		if (ses == null || ses.getAttribute("count") == null) {
			ses = request.getSession(true);
			ses.setAttribute("count", 0);
			ses.setAttribute("user1", new User());
			ses.setAttribute("static", new UserStatic(ses.getId()));
		}

		ses.setAttribute("count", ((Integer) ses.getAttribute("count")) + 1);

		User us = (User) ses.getAttribute("user1");
		us.setName(ses.getId());
		ses.setAttribute("user1", us);

		UserStatic uss = (UserStatic) ses.getAttribute("static");
		ses.setAttribute("static", uss);

		System.out.println(ses.getId());
		System.out.println(ses.getAttribute("count"));
		System.out.println(ses.getAttribute("user1"));
		System.out.println(ses.getAttribute("static"));

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/test")
	public String test(Locale locale, Model model) {
		Article article = new Article();
		article.main();

		return "home";
	}

}
