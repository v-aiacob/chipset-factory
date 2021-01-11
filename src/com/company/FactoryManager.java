package com.company;

import java.util.ArrayList;
import java.util.List;

public class FactoryManager {
    private static int minWaste = Integer.MAX_VALUE;
    private static List<List<Integer>> result = new ArrayList();

    static void detectMachinesToStart(List<Integer> machinesCapacity, int targetCapacity, List partialSolution, int temporarySum) {
        //minimum waste is 0/met
        if (temporarySum == targetCapacity) {
            if (minWaste > 0) {
                //the previous solutions can be cleared as the current has the minimum waste
                result.clear();
            }
            //add and assign
            result.add(partialSolution);
            minWaste = 0;
            return;
        }

        if (temporarySum > targetCapacity) {
            if (minWaste > temporarySum - targetCapacity) {
                minWaste = temporarySum - targetCapacity;
                //the previous solutions can be cleared as the current has the minimum waste
                result.clear();
                result.add(partialSolution);
            }
            return;
        }

        for (int i = 0; i < machinesCapacity.size(); i++) {
            int capacity = machinesCapacity.get(i);
            List<Integer> remainingMachines = new ArrayList();
            for (int j = i + 1; j < machinesCapacity.size(); j++) {
                remainingMachines.add(machinesCapacity.get(j));
            }
            //create new object from partial solution
            List<Integer> partialTemp = new ArrayList<Integer>(partialSolution);
            partialTemp.add(capacity);

            temporarySum += capacity;
            //
            detectMachinesToStart(remainingMachines, targetCapacity, partialTemp, temporarySum);
            // substract afterwards to avoid processing sum every time
            temporarySum -= capacity;
        }
    }

    public static void showMachinesToStart() {
        IOUtil.writeSolutionOutput(result, minWaste);
    }
}
