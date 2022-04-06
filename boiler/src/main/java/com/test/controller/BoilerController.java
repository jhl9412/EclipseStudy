package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Boiler;
import com.test.mapper.BoilerMapper;

@RestController
public class BoilerController {
	
	@Autowired
	BoilerMapper mapper;
	@GetMapping("/boiler/boilerList")
	List<Boiler> getBoilerList(Model model){
		model.addAttribute("list", mapper.selectBoilerList());
		return mapper.selectBoilerList();
	}

	@GetMapping("/boiler/boilerInsert")
	public void getBoilerInsert() {}
	
	@PostMapping("/boiler/boilerInsert")
	public void postBoilerRegistry(Boiler boiler) {
		
		mapper.insertBoiler(boiler.getTemp(), boiler.getStatus());
		
	}
	
	/* @GetMapping("/boiler/boilerUpdate")
	public void getBoilerUpdate() {}
	
	@PostMapping("/boiler/boilerUpdate/{status}")
	public void postBoilerUpdate(Boiler boiler) {
		
		mapper.updateBoiler(boiler.getStatus(), boiler.getId());
	
	} */
	
	@GetMapping("/boiler/boilerUpdate/{status}")
	void getUpdateBoiler(@PathVariable("status") String status) {
		
		int id = 1;
		mapper.updateBoiler(status, id);

	}

}
