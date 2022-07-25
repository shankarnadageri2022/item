package com.cg.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.item.model.Item;
import com.cg.item.service.ItemService;


@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	@PostMapping("/save")
	public Item addItem(@RequestBody Item item) {


		return itemService.saveItem(item);
	}
	
	@PutMapping("/update")
	public Item updatedItemProfile(@RequestBody Item item) {
		
		return itemService.updateItem(item);
	}
	
	@GetMapping("/find/{itemId}")
	public Item fetchItemById(@PathVariable("itemId") int itemId) {
		
		return itemService.getById(itemId);
	}
	
	@GetMapping("/byname/{itemName}")
	public List<Item> fetchItemByName(@PathVariable("itemName") String itemName) {

		return itemService.selectItemByName(itemName);
	}
	
	@DeleteMapping("/delete/{itemId}")
	public ResponseEntity<String> removeItem(@PathVariable("itemId") int itemId) {
		
		itemService.deleteItem(itemId);		
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Product Deleted Successfully.", HttpStatus.OK);
		return responseEntity;		
	}

}
