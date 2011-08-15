package com.mf.site.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mf.site.model.MojitoUser;
import com.mf.site.services.TwitterService;

@RequestMapping("/twitter/**")
@Controller
public class TwitterController {
	
	private TwitterService twitterService;
	
	@Inject
	public TwitterController(TwitterService twitterService){
		this.twitterService = twitterService;
	}
	
    @RequestMapping
    public String authenticate(HttpServletRequest request) {
    	String redirect = "redirect:";
    	HttpSession session = request.getSession(true);
    	
    	MojitoUser mojitoUser = (MojitoUser)session.getAttribute("mojitoUser");
    	
    	if(mojitoUser != null){
    		redirect+="/";
    	}else{
    		redirect+=twitterService.authenticate();
    	}
    	
    	return redirect;
    }

    @RequestMapping("/error")
    public String error(){
    	return "redirect:/hey";
    }

    @RequestMapping("/callback")
	public String callback(HttpServletRequest request,Model model) {
		MojitoUser mojitoUser = null;
    	HttpSession httpSession = null;
    	String redirect = "redirect:/twitter/error";
    	String oauth_verifier = request.getParameter("oauth_verifier");
		String denied = request.getParameter("denied");
    	
		if(denied != null){
			model.addAttribute("message","Acceso Denegado");
    	}else if(oauth_verifier != null){
    		mojitoUser = twitterService.verifyCredentials(oauth_verifier);
    		httpSession = request.getSession(true);
    		httpSession.setAttribute("mojitoUser", mojitoUser);
    		redirect = "redirect:/";
    	}
		return redirect;
	}
    
}
