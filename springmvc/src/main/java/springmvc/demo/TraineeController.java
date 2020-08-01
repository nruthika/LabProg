package springmvc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capg.model.Trainee;

import springmvc.service.TraineeService;

@Controller
public class TraineeController {
	@Autowired
	TraineeService service;
	/*
	 * @PostMapping("/add") public String addTrainee(HttpServletRequest req) { int
	 * id=Integer.parseInt(req.getParameter("id")); String
	 * name=req.getParameter("name"); String email=req.getParameter("email");
	 * Trainee T1=new Trainee(id,name,email); req.setAttribute("Trai", T1);
	 * System.out.println(req.getAttribute("Trai")); return "show.jsp";
	 * 
	 * }
	 */
	/*
	 * @PostMapping("/add") public String addTrainee(@RequestParam("id") int
	 * id,@RequestParam("name") String name,@RequestParam("email") String
	 * email,Model m) {
	 * 
	 * Trainee T1=new Trainee(id,name,email); m.addAttribute("Trai", T1);
	 * 
	 * return "show.jsp";
	 * 
	 * }
	 */
	@GetMapping
	public String showTrainee()
	{
		return "index.jsp";
	}
	@PostMapping("/add")
	public String addTrainee(@ModelAttribute Trainee t1,Model m)
	{
		
		service.addTrainee(t1);
		m.addAttribute("Trai", t1);
		 
		return "show.jsp";
		
	}
	@PostMapping("/show")
	public String fetchTrainee(@RequestParam("id") int id,Model m)
	{
		
		Trainee t1=service.getTrainee(id);
		m.addAttribute("trainee", t1);
		 
		return "findjsp";
		
	}
@PostMapping("/login")
public String loginControl(@RequestParam("userid") String id)
{
	if(id.equals("harsh"))
	{
		return "firstpage.jsp";
	}
	else
		return "index.jsp";
		
}

}
