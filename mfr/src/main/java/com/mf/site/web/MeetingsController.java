package com.mf.site.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.mf.site.entity.Meeting;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RooWebScaffold(path = "meetings", formBackingObject = Meeting.class)
//@RequestMapping("/meetings")
@Controller
public class MeetingsController {
	@RequestMapping(value = "/hey", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		System.out.println("Ejecutando MeetingsController");
		
		return "home";
	}

}
