package com.missingartifacts.entity;

import com.missingartifacts.enums.FruitName;
/**
 * @author Ali Sercan Kocagoncu
 */
public class Fruit {
    private Enum<FruitName> name;

    public Fruit(Enum<FruitName> name) {
        this.name = name;
    }

    public Enum<FruitName> getName() {
        return name;
    }

    public void setName(Enum<FruitName> name) {
        this.name = name;
    }
}
