package com.example.demo.controller;

import java.util.Optional;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String Index() {
		return "hello";
	}
	
	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value= "name")String name, Model model) { 
		model.addAttribute("name", name);
		return "hello2";
	}
	
	@RequestMapping(value={"/hello2", "hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "Phoneix");
		}
		return "hello2";
	}
	
	@RequestMapping(value= "/calculator/{num}")
	public String hitung(@PathVariable String num, Model model) {
		model.addAttribute("num", num);
		int num1 = Integer.parseInt(Character.toString(num.charAt(0)));
		model.addAttribute("num1", num1);
		int num2 = Integer.parseInt(Character.toString(num.charAt(1)));
		model.addAttribute("num2", num2);
		int hasil = num1+num2;
		model.addAttribute("hasil", hasil);

		String[] angka = {"Nol", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh","Delapan", "Sembilan", "Sepuluh",
				"Sebelas", "Dua Belas", "Tiga Belas", "Empat Belas", "Lima Belas", "Enam Belas", "Tujuh Belas", "Delapan Belas"};

		String kata = angka[hasil];
		model.addAttribute("kata", kata);
		
		return "calculator";
	}
}