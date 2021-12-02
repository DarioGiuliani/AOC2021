package solutions;

import java.util.ArrayList;
import java.util.List;

import util.FileReader;

public class SolutionDay02 {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input = FileReader.readFile("input/day02.txt");

        long startTime = System.currentTimeMillis();

        int resultPartOne = calculatePartOne(input);
        System.out.println(resultPartOne);

        long afterPartOne = System.currentTimeMillis();
        System.out.println("Execution time: " +  (afterPartOne - startTime) + "ms");

        int resultPartTwo = calculatePartTwo(input);
        System.out.println(resultPartTwo);

        System.out.println("Execution time: " +  (System.currentTimeMillis() - afterPartOne) + "ms");
    }

    public static int calculatePartOne(List<String> input) {
        int depth = 0;
        int horizon = 0;

        for (String string : input) {
            String[] splitString = string.split(" ");
            
            switch(splitString[0]) {
                case "forward":
                    horizon += Integer.parseInt(splitString[1]);
                    break;
                case "down":
                    depth += Integer.parseInt(splitString[1]);
                    break;
                case "up":
                    depth -= Integer.parseInt(splitString[1]);
                    break;
            }
        }

        return horizon * depth;
    }

    public static int calculatePartTwo(List<String> input) {
        int depth = 0;
        int horizon = 0;
        int aim = 0;

        for (String string : input) {
            String[] splitString = string.split(" ");
            int value = Integer.parseInt(splitString[1]);

            switch(splitString[0]) {
                case "forward":
                    horizon += value;
                    depth += aim * value;
                    break;
                case "down":
                    aim += value;
                    break;
                case "up":
                    aim -= value;
                    break;
            }
        }

        return horizon * depth;
    }
}
