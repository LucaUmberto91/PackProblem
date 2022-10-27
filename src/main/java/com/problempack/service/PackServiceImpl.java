package com.problempack.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.problempack.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class PackServiceImpl implements  PackService{
    @JsonProperty("myPack")
    public List<Item> pack;
    @Override
    public Integer inPack(double weight, List<Item> items, List<Item> bestChoice, Integer n) {
        //base case
        if (n == 0 || weight == 0)
            return 0;

        if (items.get(n - 1).getWeight() > weight) {
            List<Item> subOptimalChoice = new ArrayList<>();
            int optimalCost = inPack(weight, items, subOptimalChoice, n - 1);
            bestChoice.addAll(subOptimalChoice);
            return optimalCost;
        } else {
            List<Item> includeBestChoice = new ArrayList<>();
            List<Item> excludeBestChoice = new ArrayList<>();
            int include_cost = items.get(n - 1).getValue() + inPack((weight - items.get(n - 1).getWeight()), items, includeBestChoice, n - 1);
            int exclude_cost = inPack(weight, items, excludeBestChoice, n - 1);
            if (include_cost > exclude_cost) {
                bestChoice.addAll(includeBestChoice);
                bestChoice.add(items.get(n - 1));
                return include_cost;
            } else {
                bestChoice.addAll(excludeBestChoice);
                return exclude_cost;
            }
        }
    }

    @Override
        public List<Item> bestChoice(List<Item> itemList, double weight) {
        pack = new ArrayList<>();
        List<Item> myPack = new ArrayList<Item>();
        inPack(weight, itemList, pack, itemList.size());
            System.out.println("Best choice for weight: " + weight);
            for(int i = 0; i <pack.size(); i++) {
                myPack.add(pack.get(i));
                myPack.get(i).setId(i);
                System.out.println("Elemento con id : "+pack.get(i).getId()+" e con peso: "+pack.get(i).getWeight()+" e valore: "+pack.get(i).getValue());
            }
            System.out.println("Per un totale di euro : "+inPack(weight, itemList, pack, itemList.size()));
            return myPack;
        }

    @Override
        public boolean verify(List<Item> list){
        boolean verify = true;
        if(list.size()>15) verify=false;
        return verify;
    }

    @Override
    public List<Item> filter(List<Item> list){
        List newList = new ArrayList<>();
        for(Item i : list){
            if(i.getWeight()<=100 && i.getValue()<=100) newList.add(i);

        }
        return newList;
    }

    public List<Item> getMy_pack() {
        return pack;
    }

    public void setMy_pack(List<Item> my_pack) {
        this.pack = my_pack;
    }
}
