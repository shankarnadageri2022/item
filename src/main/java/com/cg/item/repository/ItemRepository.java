package com.cg.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.item.model.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	List <Item> findByItemName(String itemName);
}
