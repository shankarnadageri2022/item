package com.cg.item.service;

import java.util.List;

import com.cg.item.model.Item;

public interface ItemService {
	
	public Item saveItem(Item item);
	public Item updateItem(Item item);
	public Item getById(int id);
	public void deleteItem(int itemId);
	public List<Item> selectItemByName(String itemName);

}
