package springmvc.demo;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleController {
	/*
	 * @GetMapping(value="/message") public String getMessage(Model m) {
	 * m.addAttribute("msg","hello sir"); m.addAttribute("date",LocalDate.now());
	 * return "show.jsp"; }
	 */
	@GetMapping(value="/message")
	public ModelAndView getMessage()
	{
		ModelAndView mv=new ModelAndView("show.jsp");
		mv.addObject("msg","hellosir");
		
		mv.addObject("date",LocalDate.now());
		return mv;
	}
}
