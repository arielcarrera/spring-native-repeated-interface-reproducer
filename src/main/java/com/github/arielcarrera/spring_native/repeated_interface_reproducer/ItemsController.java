package com.github.arielcarrera.spring_native.repeated_interface_reproducer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {

	SampleConfig config;
	
	@Autowired
	public ItemsController(SampleConfig config) {
		super();
		this.config = config;
	}

	@GetMapping(path = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<String> findItems() {
		return config.getPaths();
	}

	@PostMapping(path = "/items/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String addItem(@PathVariable(required = true) String name) {
		return "Added: " + name;
	}

}