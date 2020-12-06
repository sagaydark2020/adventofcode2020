package fun.ae.sagay.aoc.Day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class CustomsQuestionairePart2 {

    private int countOfUniqueQuestions = 0;

    public CustomsQuestionairePart2() {
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
            System.out.println("-------");
            List<List<String>> doubleMatrix = new ArrayList<>();
            List<String> peopleInGroup = Arrays.stream(s.split("\n")).collect(Collectors.toList());
            Set<String> questionsAnswered = Arrays.stream(s.split("")).collect(Collectors.toSet());
            peopleInGroup.stream().forEach(p -> {
                List<String> gList = Arrays.stream(p.split("")).collect(Collectors.toList());
                doubleMatrix.add(gList);
            });
            System.out.println("doubleMatrix " + doubleMatrix);
            int rowCount = doubleMatrix.size();
            int allAnswererd = 0;
            for (String str : questionsAnswered) {
                int matches = 0;
                for (List<String> matchList : doubleMatrix) {
                    if (matchList.contains(str)) {
                        matches++;
                    }
                }
                if (matches == rowCount) {
                    allAnswererd++;
                }
            }
            System.out.println(" allAnswererd " + allAnswererd);
            countOfUniqueQuestions = countOfUniqueQuestions + allAnswererd;
            System.out.println(" countOfUniqueQuestions " + countOfUniqueQuestions);
        });
        System.out.println(" countOfUniqueQuestions " + countOfUniqueQuestions);
    }

    public static void main(String[] args) {
        new CustomsQuestionairePart2();
    }

}