package com.programmingfree.springservice.controller;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Node;

import com.programmingfree.springservice.dao.UserService;
import com.programmingfree.springservice.domain.User;
import com.programmingfree.springservice.domain.Users;
import com.programmingfree.springservice.util.XMLUtils;

@RestController
@RequestMapping("/service/user/")
public class SpringServiceController {

	UserService userService=new UserService();

	@RequestMapping(value = "/json/{id}", method = RequestMethod.GET, headers="Accept=application/json")
	public User getUser(@PathVariable int id) {
		User user=userService.getUserById(id);
		return user;
	}
	@RequestMapping(value = "/xml/{id}", method = RequestMethod.GET, headers="Accept=application/xml")
	public User getUser2(@PathVariable int id) {
		User user=userService.getUserById(id);
		System.out.println("1541-1 "+user.getFirstName()); ////
		return user;
	}

	@RequestMapping(value = "/post/xml", method = RequestMethod.POST, consumes = "application/xml")
	public String getUser3(@RequestBody String requestBody) throws JAXBException {
		System.out.println(requestBody);
		User user2 = new User();
		JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Node node = XMLUtils.stringToNode(requestBody);
		user2 = (User) jaxbUnmarshaller.unmarshal(node);
		System.out.println(user2.getFirstName());
		return "ran SpringByExample post";
	}

	@RequestMapping(value = "/post/json", method = RequestMethod.POST, headers="Accept=application/json")
	public String getUser4(User user) {
		System.out.println("1739-2-userId="+user.getUserid());
		int id = user.getUserid();
		User user2=userService.getUserById(id);
		return "ran SpringByExample post";
	}

	@RequestMapping(value = "/post/form", method = RequestMethod.POST)
	public ModelAndView getUser4(@ModelAttribute("SpringWeb")User user, ModelMap modelMap) {
		user.setFirstName("Mr. "+user.getFirstName());
		System.out.println("1131-1 - FirstName="+user.getFirstName());
		
		// the ModelMap is necessary and is implicitly passed to the ModelAndView, at least if it has no form tag
		// comment out if you want user propagated to original entry screen
/*		modelMap.addAttribute("userid", user.getUserid());
		modelMap.addAttribute("firstName", user.getFirstName());
		modelMap.addAttribute("lastName", user.getLastName());
		modelMap.addAttribute("email", user.getEmail());
		return new ModelAndView("userResult", "command", user);*/
		
		return new ModelAndView("userEntry", "command", user);
		//return "userResult"; // seems to not work here, though it does in MVC_FormHandling
	}

	@RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
	public List<User> getAllUsers() {
		List<User> users=userService.getAllUsers();
		return users;
	}
	@RequestMapping(value = "/xml", method = RequestMethod.GET,headers="Accept=application/xml")
	public Users getAllUsers2() {
		System.out.println("0854-2");
		Users users=userService.getAllUsers2();
		return users;
	}

}
