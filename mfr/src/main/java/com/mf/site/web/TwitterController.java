package com.mf.site.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mf.site.services.TwitterService;

@RequestMapping("/twitter/**")
@Controller
public class TwitterController {
	@Inject
	private TwitterService twitterService;

	
    @RequestMapping
    public String authenticate() {
    	return "redirect:"+twitterService.authenticate();
    }

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index() {
        return "twitter/index";
    }
}
