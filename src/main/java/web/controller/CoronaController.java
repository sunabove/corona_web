package web.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import web.model.CodeRepository;
import web.model.Corona;
import web.model.CoronaList;
import web.model.CoronaRepository;

@RequestMapping("/corona")
@Log4j
@RestController
public class CoronaController {   
	private static final long serialVersionUID = 4920966828847693392L;
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong(); 
	
	@Autowired public CoronaRepository coronaRepository;
	
	private static final SimpleDateFormat upDtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@GetMapping("data.json")
	public ArrayList<Corona> corona(@RequestParam(value="up_dt", defaultValue = "") Long upDtLong ) { 
		
		log.info( "upDtLong = " + upDtLong );
				
		CoronaList list ; 
		
		if( null == upDtLong ) { 
			Iterable<Corona> it = this.coronaRepository.findAll(); 
			
			list= new CoronaList();
			
			int rno = 0 ; 
			for( Corona obj : it ) {
				obj.setRno(rno);
				list.add( obj ); 
				rno ++ ;  
			}
		} else {
			Timestamp upDt = new Timestamp( upDtLong ); 
			list = this.coronaRepository.findAllByUpDtGreaterThanOrderById(upDt);
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