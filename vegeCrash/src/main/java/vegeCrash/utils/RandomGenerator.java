package main.java.vegeCrash.utils;

import main.java.vegeCrash.data.enums.VegeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();

    public static int generateRandomIntValue(int upperBound) {
        return random.nextInt(upperBound);
    }

    private static List<VegeType> list = Arrays.asList(VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER);


    public static VegeType vegetableGenerator() {
        int randomValue = generateRandomIntValue(4);
        return list.get(random.nextInt(list.size()));
    }

    public static VegeType vegetableGenerator(VegeType vegeType) {
        List<VegeType> vegeList = new ArrayList<>(list);
        vegeList.remove(vegeType);
        return vegeList.get(random.nextInt(vegeList.size()));
    }
}


