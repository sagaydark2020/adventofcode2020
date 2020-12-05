package com.sagay.aoc2020.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PasswordPolicyPart2 {
    public static void main(String[] args) throws IOException {
        PasswordPolicyPart2 passwordPolicy = new PasswordPolicyPart2();
        File file = new File("Day2Part2Input.txt");
        try (BufferedReader fis = new BufferedReader(new FileReader(file))) {
            String lineEntry = null;
            int matchingCount = 0;
            while ((lineEntry = fis.readLine()) != null) {
                System.out.println("Policy Entry : " + lineEntry);
                String[] entry = lineEntry.split(" ");
                Integer first = Integer.valueOf(entry[0].split("-")[0]);
                Integer second = Integer.valueOf(entry[0].split("-")[1]);
                first = first - 1;
                second = second - 1;
                String value = entry[1].replaceAll(":", "");
                int indexOfValue = entry[2].indexOf(value);
                if (indexOfValue != -1) {
                    if (!(entry[2].charAt(first) == value.toCharArray()[0] && entry[2].charAt(second) == value.toCharArray()[0])) {
                        if (entry[2].charAt(first) == value.toCharArray()[0] || entry[2].charAt(second) == value.toCharArray()[0]) {
                            System.out.println("Valiuid");
                            matchingCount++;
                        }
                    }

                }
            }
            System.out.println("Count: " + matchingCount);
        }
    }

}



