package web.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;
import java.util.ArrayList;
import web.model.CodeRepository;
import web.model.Corona;
import web.model.CoronaRepository;

@RequestMapping("/corona")
@Log4j
@RestController
public class CoronaController {   
	private static final long serialVersionUID = 4920966828847693392L;
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong(); 
	
	@Autowired public CoronaRepository coronaRepository;
	
	@GetMapping("data.json")
	public ArrayList<Corona> corona(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		Iterable<Corona> it = this.coronaRepository.findAll();
		
		ArrayList<Corona> list = new ArrayList<Corona>();
		
		int rno = 0 ; 
		for( Corona obj : it ) {
			obj.setRno(rno);
			list.add( obj );
			rno ++ ; 
		}
		
		return list;
	}
	
	@GetMapping("greeting.json")
	public ArrayList<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		ArrayList<Greeting> list = new ArrayList<>();
		list.add( new Greeting(counter.incrementAndGet(), String.format(template, name)) );
		list.add( new Greeting(counter.incrementAndGet(), String.format(template, name)) );
		
		return list;  
	}

}