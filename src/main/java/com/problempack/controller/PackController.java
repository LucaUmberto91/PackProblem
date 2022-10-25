package com.problempack.controller;


import com.problempack.model.Item;
import com.problempack.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping(path = "/pack")
public class PackController {


	@Autowired
	PackService packService;


	@GetMapping(path = "/result")
	public @ResponseBody Object find(@RequestBody List<Item> itemList ,
									 @RequestParam (name = "weight")double weight) {
		itemList.add(new Item(0, 5, 70));

		return packService.bestChoice(itemList,weight);
	}

}
