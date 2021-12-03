package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import util.FileReader;

public class SolutionDay03 {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input = FileReader.readFile("input/day03.txt");

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
        StringBuilder gammaRate = new StringBuilder();

        for (int i = 0; i < input.get(0).length(); i++) {
            final int currentChar = i;
            gammaRate.append(input.stream().filter(string -> string.charAt(currentChar) == '1').collect(Collectors.toList()).size() > input.size() / 2.0 ? '1' : '0');
        }

        return Integer.parseInt(gammaRate.toString(), 2) * Integer.parseInt(gammaRate.toString().replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1"), 2);
    }

    public static int calculatePartTwo(List<String> input) {
        List<String> oxygenList = new ArrayList<>(input);
        List<String> CO2List = new ArrayList<>(input);
        int oxygenCharPosition = 0;

        while(oxygenList.size() != 1) {
            final int finalCurrentCharPosition = oxygenCharPosition;
            char mostCommonBit = oxygenList.stream().filter(string -> string.charAt(finalCurrentCharPosition) == '1').collect(Collectors.toList()).size() >= oxygenList.size() / 2.0 ? '1' : '0';
            oxygenList = new ArrayList<>(oxygenList.stream().filter(string -> string.charAt(finalCurrentCharPosition) == mostCommonBit).collect(Collectors.toList()));
            
            oxygenCharPosition++;
        }

        int CO2CharPosition = 0;

        while(CO2List.size() != 1) {
            final int finalCurrentCharPosition = CO2CharPosition;
            char leastCommonBit = CO2List.stream().filter(string -> string.charAt(finalCurrentCharPosition) == '0').collect(Collectors.toList()).size() <= CO2List.size() / 2.0 ? '0' : '1';
            CO2List = new ArrayList<>(CO2List.stream().filter(string -> string.charAt(finalCurrentCharPosition) == leastCommonBit).collect(Collectors.toList()));

            CO2CharPosition++;
        }

        return Integer.parseInt(oxygenList.get(0), 2) * Integer.parseInt(CO2List.get(0), 2);
    }
}
