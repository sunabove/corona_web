package web.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GreetingController extends ComController { 

	private static final long serialVersionUID = 993614188500846740L;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) { 
		return "greeting.html";  
	}
	
	@GetMapping("/")
	public String index() {
		return "index.html";
	} 

	@GetMapping("index")
	public String index2() {
		return "index.html";
	} 

}