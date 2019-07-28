package com.jcg.springmvc.mongo.controller;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.springmvc.mongo.User;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
@Controller
@RequestMapping("/")
public class UserController 
{
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public ModelAndView addUser (Model model, HttpServletResponse res) throws IOException
	{
		MongoClient mongoclient = new MongoClient("localhost",27017);
		System.out.println("Connection Established");
		DB db = mongoclient.getDB("mydb");
		DBCollection dbcoll = db.getCollection("mycollection");
		DBCursor cursor = dbcoll.find();
		while(cursor.hasNext())
		{
			int i = 1;
			System.out.println(cursor.next());
			i++;
		}
		ModelAndView mv = new ModelAndView();
		System.out.println("In add user");
		model.addAttribute("userAtrr",new User());
		mv.setViewName("form.jsp");
		return mv;
	}
}
