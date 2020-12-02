package com.sagay.aoc2020.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordPolicyPart1 {
    public static void main(String[] args) throws IOException {
        PasswordPolicyPart2 passwordPolicy = new PasswordPolicyPart2();
        File file = new File("Day2Part1Input.txt");
        try (BufferedReader fis = new BufferedReader(new FileReader(file))) {
            String lineEntry = null;
            int matchingCount = 0;
            while ((lineEntry = fis.readLine()) != null) {
                String[] entry = lineEntry.split(" ");
                String condition = entry[0].replaceAll("-", ",");
                Integer min = Integer.valueOf(entry[0].split("-")[0]);
                Integer max = Integer.valueOf(entry[0].split("-")[1]);
                String value = entry[1].replaceAll(":", "");
                Matcher matcher
                        = Pattern.compile(String.valueOf(value))
                        .matcher(entry[2]);
                int match = 0;
                while (matcher.find()) {
                    match++;
                }
                if (match >= min & match <= max) {
                    System.out.println("Valid Match" + match);
                    matchingCount++;
                }
            }
            System.out.println("Count: " + matchingCount);
        }
    }


}





