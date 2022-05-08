package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Controllercls {
	@Autowired
	Repositorycustomer repo;
	
	@Autowired
	mailsendercls mailsen;
	
	@RequestMapping("/")
	public String dis() {
		return "index";
	}
    @RequestMapping("/completed")
    public ModelAndView com(Usercls user) {
    	ModelAndView mv=new ModelAndView();
    	int i=0;
    	
    String fin=user.getEmail();
    boolean flag=true;
    for(Usercls f:repo.findAll()) {
    	if(fin.equals(f.getEmail())) {
    		String dup="You have already registered with same mail ID";
    		mv.addObject("dup", dup);
    		flag=false;
    	}
    }
       if(flag) {
    	   if(user.getGender().contains("female")) {
       		String out="Ms."+user.getFirstname();
       		mv.addObject("first",out);
       	}else {
       		String out="Mr."+user.getFirstname();
       	mv.addObject("first",out);}
       
    	repo.save(user);
    	try {
    	String semail=user.getEmail();
    	String body="Thanks for your valuable time. Your message will be consider as soon as possible. Follow your dreams. Thank you! ";
    	String sub="Acknowlegement mail";
    	mailsen.sender(semail, body, sub);}
    	catch(Exception e) {
    		System.out.println(e);
    	}}
    	return mv;
    }
    
}