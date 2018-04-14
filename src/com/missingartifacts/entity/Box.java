package com.missingartifacts.entity;

import com.missingartifacts.enums.FruitName;
import com.missingartifacts.enums.Label;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Ali Sercan Kocagoncu
 * Box class is defined as final to restrict inheritance.
 *
 */
public final class Box {
    private Enum<Label> labelEnum;
    private List<Fruit> fruits;
    private int index;

    public Box(Enum<Label> labelEnum, List<Fruit> fruits) {
        this.labelEnum = labelEnum;
        this.fruits = fruits;
        this.index = (int)Math.random() * (fruits.size());  // generate random pickup between 0 to upper bound
    }

    public final Fruit getRandomFruit(){
       return fruits.get(index);
    }

    public Enum<Label> getLabelEnum() {
        return labelEnum;
    }

    public void setLabelEnum(Enum<Label> newLabel) {
        this.labelEnum = newLabel;
    }

    @Override
    public String toString() {
        return "Box{" +
                "labelEnum=" + labelEnum +
                "," +
                "box content=" + getBoxContent() +
                '}';
    }

    private String getBoxContent(){
        Map<Enum<FruitName>,List<Fruit>> groupByType =
                fruits.stream().collect(Collectors.groupingBy(Fruit::getName));
        StringBuilder sb = new StringBuilder();
        for (Enum<FruitName> fruitName: groupByType.keySet()) {
            sb.append(fruitName);
            sb.append("-->" + groupByType.get(fruitName).size() + ",");
        }
        return sb.toString();

    }
}
