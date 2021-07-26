package br.com.homeponto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
public class HelloController {
	
	@RequestMapping("/api/")
	@ResponseBody
	public String helloController() {
		return "Olá Home Ponto";
	}
}
