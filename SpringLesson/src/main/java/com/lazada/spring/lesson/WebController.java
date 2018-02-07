package com.lazada.spring.lesson;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController
{
	@GetMapping("/lalala")
	public String doSomething()
	{
		return "<h1>Did Something</h1>";
	}
	
	@GetMapping("/getWords")
	public List<String> getStrings()
	{
		return Arrays.asList("Yes","I","am","going","to","miss","you","all");
	}
	
	@GetMapping("/greeting/{param}")
	public String getParams(@PathVariable String param)
	{
		return "<h1>Welcome " + param + "</h1>";
	}
}





