package com.charitra.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.charitra.Dao.AlienDao;
import com.charitra.model.Alien;



@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	
//	@GetMapping("add")  // This is written with help of servlet now we do same with JSP
//	public String add(HttpServletRequest req) {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		int ans = i+j;
//		// Now to return data to servlet we can use session
//		HttpSession session  = req.getSession();
//		session.setAttribute("ans",ans);
//		return "result.jsp";
//	}
	
	
//	@GetMapping("add")
//	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,HttpSession session)
//	{
//		int ans = i+j;
//		session.setAttribute("ans", ans);
//		return "result.jsp";
//	}
	
	// Now we are going to use ModelAndView instead of HttpSession
//	@GetMapping("add")
//	public ModelAndView add(@RequestParam("num1") int i,@RequestParam("num2") int j)
//	{
//		ModelAndView mv = new ModelAndView();
//		int ans = i+j;
//		mv.setViewName("result");
//		mv.addObject("ans",ans);
//		return mv;
//	}
	/* If we only want to set attribute and return string as path then we can use Model object in add parameter like Model m */
	
//	@GetMapping("addAlien")
//	public String addAlien(@RequestParam("aid") String a,@RequestParam("aname") String b, Model m) {
//		
//		Alien a1 = new Alien();
//		a1.setAid(Integer.parseInt(a));
//		a1.setAname(b);
//		m.addAttribute("alien",a1);
//		return "result.jsp";
//	}
	
	/* Now instead of creating object of alien and write request param we want values to be
	 * directly assigned so we @ModelAttribute*/
	@ModelAttribute
	public void ModelData(Model m) {
		m.addAttribute("name","Aliens");
	}
//	@PostMapping("addAlien")
//	public String addAlien(@ModelAttribute("alien") Alien a,Model m) // To use ModelAttribute take input names as same as class variable names
//	{
//		// alien is used in @ModelAttribute because we have written alien in result.jsp to represent data of Alien
//		// With the help of ModelAttribute we dont have to use m.addAttribute to set data in JSP
//		return "result";
//	}
	
	@Autowired
	AlienDao dao;
	
	@GetMapping("getAliens")
	public String getAll(Model m)
	{
		
		m.addAttribute("result", dao.getAliens());
		return "showAliens";
	}
	
	
	@GetMapping("addAlien")
	public String addAlien(@ModelAttribute("result") Alien a)
	{
		dao.addAlien(a);
		return "showAliens";
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam("aid") int id,Model m)
	{
		
		m.addAttribute("result", dao.getAlien(id));
		return "showAliens";
	}
	
}
