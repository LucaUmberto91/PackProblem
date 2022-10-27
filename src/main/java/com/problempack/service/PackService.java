package com.problempack.service;

import com.problempack.model.Item;

import java.util.ArrayList;
import java.util.List;

public interface PackService {

	public  Integer inPack(double weight, List<Item> item, List<Item> optimalChoice, Integer n);
	public  List<Item> bestChoice(List<Item> itemList, double weight);
	public boolean verify(List<Item> list);
	public List<Item> filter(List<Item> list);

}
