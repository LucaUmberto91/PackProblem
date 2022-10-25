package com.problempack.model;

public class Item {
    private Integer id;
    private Integer weight;
    private Integer value;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Item(Integer id,Integer weight, Integer value) {
        this.weight = weight;
        this.value = value;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
