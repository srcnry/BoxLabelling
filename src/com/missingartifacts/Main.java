package com.missingartifacts;

import com.missingartifacts.entity.Apple;
import com.missingartifacts.entity.Box;
import com.missingartifacts.entity.Fruit;
import com.missingartifacts.entity.Orange;
import com.missingartifacts.utils.RandomInitializer;
import com.missingartifacts.enums.Label;

import java.util.Map;
/**
 * @author Ali Sercan Kocagoncu
 */
public class Main {

    public static void main(String[] args) {
        /**
         * RandomInitializer class creates boxes with different contents and labels due to the
         * problem requirements.
         */
        Map<Enum<Label>,Box> boxes = RandomInitializer.getBoxes();

        System.out.println("Initial labels and contents of the boxes");
        printMap(boxes);

        correctTheLabels(boxes);

        System.out.println("After correcting labels and contents of the boxes");
        printMap(boxes);
    }

    public static void correctTheLabels(Map<Enum<Label>,Box> boxes) {
        Fruit fruit = boxes.get(Label.MIX).getRandomFruit();

        if(fruit instanceof Orange) {
            boxes.get(Label.MIX).setLabelEnum(Label.ORANGES);
            boxes.get(Label.APPLES).setLabelEnum(Label.MIX);
            boxes.get(Label.ORANGES).setLabelEnum(Label.APPLES);
        } else if(fruit instanceof Apple){
            boxes.get(Label.MIX).setLabelEnum(Label.APPLES);
            boxes.get(Label.APPLES).setLabelEnum(Label.ORANGES);
            boxes.get(Label.ORANGES).setLabelEnum(Label.MIX);
        }

    }

    public static void printMap( Map<Enum<Label>,Box> boxes){
        for (Enum<Label> label: boxes.keySet()) {
            System.out.print("Initial map label : " + label);
            System.out.println("--> current box label : " +boxes.get(label).toString());
        }
    }
}
