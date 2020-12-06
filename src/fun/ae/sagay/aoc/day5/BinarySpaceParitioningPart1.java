package fun.ae.sagay.aoc.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class BinarySpaceParitioningPart1 {

    private int maxSeatsInCols = 7;
    private int maxRows = 127;
    private int highestSeatNumber = 0;

    BinarySpaceParitioningPart1() {
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
        Arrays.stream(seatCodes.split("\n")).forEach(s -> {
            int row = BSPSearchUtil.binarySearch(s.substring(0, 7), maxRows);
            int col = BSPSearchUtil.binarySearch(s.substring(7, 10), maxSeatsInCols);
            isMaxSeat(row, col);
        });
        System.out.println("Highest number : " + highestSeatNumber);
    }

    private void isMaxSeat(int row, int col) {
        int seatID = row * 8 + col;
        if (seatID > highestSeatNumber) highestSeatNumber = seatID;
    }


    public static void main(String[] args) {
        new BinarySpaceParitioningPart1();
    }
}
