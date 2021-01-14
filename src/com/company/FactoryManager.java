package com.company;

import java.util.ArrayList;
import java.util.List;

public class FactoryManager {
    private static int minWaste = Integer.MAX_VALUE;
    private static List<List<Integer>> result = new ArrayList();

    /**
     * Determine which machines should be started.
     * @param machinesCapacity - what is the capacity of each machine
     * @param targetCapacity - the capacity required to fulfill per minute
     * @param partialSolution - partial solutions that deliver with minimum waste
     * @param temporarySum - a temporary capacity sum which initial should be 0
     */
    static void detectMachinesToStart(List<Integer> machinesCapacity, int targetCapacity, List<Integer> partialSolution, int temporarySum) {
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
            List<Integer> partialTemp = new ArrayList(partialSolution);
            partialTemp.add(capacity);

            temporarySum += capacity;
            // initially add the capacity - which will be removed afterwards for recursivity
            detectMachinesToStart(remainingMachines, targetCapacity, partialTemp, temporarySum);
            // substract afterwards to avoid processing sum every time
            temporarySum -= capacity;
        }
    }

    /**
     * Display the machines to be started and what is their waste.
     */
    public static void showMachinesToStart() {
        IOUtil.writeSolutionOutput(result, minWaste);
    }
}
