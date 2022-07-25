package com.cg.item.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.item.exception.ItemNotFoundException;
import com.cg.item.model.Item;
import com.cg.item.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item saveItem(Item item) {

		Item newItem = itemRepository.save(item);
		return newItem;
	}

	@Override
	public Item updateItem(Item item) {
		Optional<Item> newOrder = itemRepository.findById(item.getItemId());
		Item item1 = itemRepository.save(item);

		return item1;
	}

	@Override
	public Item getById(int id) throws ItemNotFoundException {
		// TODO Auto-generated method stub
		Optional<Item> itemById = itemRepository.findById(id);

		if (itemById.isEmpty()) {
			throw new ItemNotFoundException(" order not found with id : " + id);
		}
		Item item = itemById.get();
		return item;

	}
	@Override
	public List <Item> selectItemByName(String itemName) {

		List<Item> item = itemRepository.findByItemName(itemName);

		if (item.isEmpty()) {
			throw new ItemNotFoundException("item not found with name " + itemName);
		}

		return item;
	}

	@Override
	public void deleteItem(int itemId) {

		Optional<Item> optionalProduct = itemRepository.findById(itemId);
		if (optionalProduct.isEmpty()) {
			throw new ItemNotFoundException("Product Not found with id: " + itemId);
		}

		itemRepository.deleteById(itemId);
	}

}
