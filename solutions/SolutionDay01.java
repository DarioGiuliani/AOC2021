package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import util.FileReader;

public class SolutionDay01 {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input = FileReader.readFile("input/day01.txt");
        List<Integer> inputNumbers = input.stream().map(string -> Integer.parseInt(string)).collect(Collectors.toList());

        long startTime = System.currentTimeMillis();

        int resultPartOne = calculatePartOne(inputNumbers);
        System.out.println(resultPartOne);

        long afterPartOne = System.currentTimeMillis();
        System.out.println("Execution time: " +  (afterPartOne - startTime) + "ms");

        int resultPartTwo = calculatePartTwo(inputNumbers);
        System.out.println(resultPartTwo);

        System.out.println("Execution time: " +  (System.currentTimeMillis() - afterPartOne) + "ms");
    }

    public static int calculatePartOne(List<Integer> input) {
        int increases = 0;
        int previousNumber = input.get(0);

        for (Integer inputNumber : input) {
            if(inputNumber > previousNumber) {
                increases++;
            }

            previousNumber = inputNumber;
        }
        
        return increases;
    }

    public static int calculatePartTwo(List<Integer> input) {
        int increases = 0;
        int previousWindowSum = input.get(0) + input.get(1) + input.get(2);

        for (int i = 1; i < input.size() - 2; i++) {
            int windowSum = input.get(i) + input.get(i + 1) + input.get(i + 2);

            if(windowSum > previousWindowSum) {
                increases++;
            }

            previousWindowSum = windowSum;
        }

        return increases;
    }
}
