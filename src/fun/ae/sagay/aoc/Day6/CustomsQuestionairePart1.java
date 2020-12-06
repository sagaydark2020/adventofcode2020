package fun.ae.sagay.aoc.Day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CustomsQuestionairePart1 {

    private int countOfUniqueQuestions = 0;

    public CustomsQuestionairePart1() {
        processTickets(getStreamForInputFile());
    }

    private String getStreamForInputFile() {
        File file = new File("Day6Part1Input.txt");
        StringBuilder builder = new StringBuilder();
        try (BufferedReader fis = new BufferedReader(new FileReader(file))) {
            fis.lines().forEach(str -> {
                builder.append(str).append("\n");
                if (str.trim().equals("")) {
                    builder.append("GROUP");
                }

            });
        } catch (Exception e) {
            System.out.println("Guess somethign wrong in your File " + e.getMessage());
        }
        //System.out.println("Group" + builder.toString());
        return builder.toString();
    }

    private void processTickets(String seatCodes) {

        Arrays.stream(seatCodes.split("GROUP")).forEach(s -> {
            int uniquesInGroup = Arrays.stream(s.split("")).collect(Collectors.toSet()).size() - 1;
            System.out.println(" Individual Set " + uniquesInGroup);
            countOfUniqueQuestions = countOfUniqueQuestions + uniquesInGroup;
            System.out.println("Count of Questions " + countOfUniqueQuestions);
        });
    }

    public static void main(String[] args) {
        new CustomsQuestionairePart1();
    }

}