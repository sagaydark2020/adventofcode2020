package fun.ae.sagay.aoc.day5;

public class BSPSearchUtil {

    public static int binarySearch(String data, int maxRange) {
        int minRange = 0;
        for (String s : data.split("")) {
            int diff = maxRange - minRange;
            maxRange = processLowerOrLeft(maxRange, s, diff);
            minRange = processUpperOrRight(minRange, s, diff);
        }
        return maxRange;
    }

    private static int processUpperOrRight(int minRange, String s, int diff) {
        if (BSPValidatorData.UPPER_RIGHT.contains(s)) minRange += diff / 2;
        return minRange;
    }

    private static int processLowerOrLeft(int maxRange, String s, int diff) {
        if (BSPValidatorData.LOWER_LEFT.contains(s)) maxRange -= Math.ceil(diff / 2.0);
        return maxRange;
    }
}
