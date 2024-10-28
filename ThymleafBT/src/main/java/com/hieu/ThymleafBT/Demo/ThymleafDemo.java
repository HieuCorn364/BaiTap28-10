package com.hieu.ThymleafBT.Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThymleafDemo {
	@GetMapping("/hello")
	public String Hello() {
		return "Ngo Trung Hieu";
	}
}


