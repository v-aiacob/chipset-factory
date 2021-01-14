package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    // change the input number 1 or 2 to adjust the input file (others can be added)
    private static final String INPUT_DATA_FILE_NUMBER = "2";

    public static void main(String args[]) {
        try {
            List<String> input = IOUtil.readSampleInput(String.format("src/test/resources/input%s.txt", INPUT_DATA_FILE_NUMBER));
            if (input != null) {
                // get the capacities
                List machinesCapacity = Arrays.stream(input.get(1).split(" "))
                        .map(s -> Integer.parseInt(s))
                        .collect(Collectors.toList());
                // retrieve the targeted chipsets per day
                int targetChipsets = Integer.parseInt(input.get(2));

                //sort the capacities
                Collections.sort(machinesCapacity);

                FactoryManager.detectMachinesToStart(machinesCapacity, targetChipsets, new ArrayList<Integer>(), 0);

                FactoryManager.showMachinesToStart();
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Solution could not be processed. Provided input format is not correct.");
        }
    }
}

