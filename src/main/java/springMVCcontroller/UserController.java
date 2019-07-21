package springMVCcontroller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcg.springmvc.mongo.User;
import com.jcg.springmvc.mongo.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Logger log = Logger.getLogger(UserController.class);
	
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value="/list", method= RequestMethod.GET)
	public String getPersons(Model model)
	{
		log.debug("Request to fetch all users");
		List user_list = userService.getAll();
		model.addAttribute("users", user_list);
		return "welcome";		
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addUser (Model model)
	{
		log.debug("Request to open the new user");
		model.addAttribute("userAtrr",new User());
		return "form";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String editUser(@RequestParam(value="id", required=true) String id, Model model)
	{
		log.debug("Request to open the edit user");
		model.addAttribute("userAttr", userService.findUserId(id));
		return "form";
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam(value="id",required=true) String id, Model model)
	{
		userService.delete(id);
		return "redirect:list";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("userAttr") User user){
		if(user.getId() !=null && !user.getId().trim().equals(""))
		{
			userService.edit(user);
		}
		else
		{
			userService.add(user);
		}
		return "redirect:list";
	}

}
