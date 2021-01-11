package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IOUtil {

    public static List<String> readSampleInput(String fileName)
    {
        try
        {
            return Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeSolutionOutput(List<List<Integer>> result, int minWaste) {
        int solutions = result.size();
        System.out.println("Nr solutions=" + solutions);
        for (List<Integer> res: result) {
            for(Integer machine: res) {
                System.out.print(machine + " ");
            }
            System.out.println();
        }
        if (solutions > 0) {
            System.out.println("Waste=" + minWaste);
        }
    }
}
