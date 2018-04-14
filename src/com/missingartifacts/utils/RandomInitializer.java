package com.missingartifacts.utils;

import com.missingartifacts.entity.Apple;
import com.missingartifacts.entity.Box;
import com.missingartifacts.entity.Orange;
import com.missingartifacts.enums.FruitName;
import com.missingartifacts.enums.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ali Sercan Kocagoncu
 * The problem validator - the boxes are randomly generated regarding to the problem requirements
 */

public final class RandomInitializer {
    private final static int numberOfFruits = 10; // according to the problem requirement content is limited to 10

    private static List<com.missingartifacts.entity.Fruit> oranges = new ArrayList<>();
    private static List<com.missingartifacts.entity.Fruit> apples = new ArrayList<>();
    private static List<com.missingartifacts.entity.Fruit> mix = new ArrayList<>();

    private static Map<Enum<Label>,Box> boxes = new HashMap<Enum<Label>,Box>();

    /* 1. In static code block the boxes and incorrect labelling is done for once
    *  2. Contents are randomly created
    * */
    static {
        int limit = 0;
        while( limit < numberOfFruits) {
            oranges.add(new Orange(FruitName.ORANGE));
            apples.add(new Apple(FruitName.APPLE));
            mix.add(limit < (int)(numberOfFruits/2) ? new Orange(FruitName.ORANGE) :  new Apple(FruitName.APPLE));
            limit++;
        }
        int scenario =  (int)Math.round(Math.random());
        if(scenario == 0 ){
            boxes.put(Label.MIX,new Box(Label.MIX, oranges ));
            boxes.put(Label.ORANGES,new Box(Label.ORANGES, apples ));
            boxes.put(Label.APPLES,new Box(Label.APPLES, mix));
        } else {
            boxes.put(Label.MIX, new Box(Label.MIX, apples));
            boxes.put(Label.ORANGES, new Box(Label.ORANGES, mix));
            boxes.put(Label.APPLES, new Box(Label.APPLES, oranges ));
        }

    }

    public final static Map<Enum<Label>,Box> getBoxes(){
        return boxes;
    }

    private RandomInitializer() {
    }
}
