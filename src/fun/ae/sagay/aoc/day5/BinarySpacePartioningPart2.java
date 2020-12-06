package fun.ae.sagay.aoc.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySpacePartioningPart2 {

    private List<Integer> seatLists = new ArrayList<>();

    BinarySpacePartioningPart2() {
        processSeats(getStreamForInputFile());
    }

    private String getStreamForInputFile() {
        File file = new File("Day5Part1Input.txt");
        StringBuilder builder = new StringBuilder();
        try (BufferedReader fis = new BufferedReader(new FileReader(file))) {
            fis.lines().forEach(str -> builder.append(str).append("\n"));
        } catch (Exception e) {
            System.out.println("Guess somethign wrong in your File " + e.getMessage());
        }
        return builder.toString();
    }

    private void processSeats(String seatCodes) {
        Arrays.stream(seatCodes.split("\n")).forEach(s ->
        {
            int row = BSPSearchUtil.binarySearch(s.substring(0, 7), 127);
            int col = BSPSearchUtil.binarySearch(s.substring(7, 10), 7);
            seatLists.add(row * 8 + col);
        }
        );

            Collections.sort(seatLists);

            for (int i = 0; i < seatLists.size(); i++) {
                if (seatLists.get(i) + 1 != seatLists.get(i + 1)) {
                   System.out.println(seatLists.get(i) + 1);
                    break;
                }
            }
        }



    public static void main(String[] args) {
        new BinarySpacePartioningPart2();
    }
}
