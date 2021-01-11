package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        Integer[] machinesCapacity = {1,2,4,10,5,6};
        int targetChipsets = 11;
        Arrays.sort(machinesCapacity);

        try {
            //TODO - retrieve input from file
            List<String> input = IOUtil.readSampleInput("src/test/resources/input.txt");
            if (input != null) {
                input.get(0);
                input.get(1).split(" ");
                input.get(2);
            }

            FactoryManager.detectMachinesToStart(Arrays.asList(machinesCapacity), targetChipsets, new ArrayList<Integer>(), 0);

            FactoryManager.showMachinesToStart();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Solution could not be processed. Provided input format is not correct.");
        }
    }
}

