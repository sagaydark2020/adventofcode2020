package fun.ae.sagay.aoc.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Triplet {

    private static final String FILE_PATH = "Day1Part2Input.txt";
    private static final int TARGET = 2020;
    Triplet() {
        try {
            List<Integer> inputDataSet = processInputFromFileSystem();
            List<List<Integer>> matchingCombos = identifyCombinationSum(convertIntegers(inputDataSet),TARGET);
            printValidOuput(matchingCombos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printValidOuput(List<List<Integer>> validCombos) {
        int productOfComboSum = 1;
        for (List<Integer> list: validCombos) {
            if(list.size() == 3) {
                for (Integer numbers: list) {
                    System.out.println("Numbers are " + numbers);
                    productOfComboSum = productOfComboSum*numbers;
                }
            }
        }
        System.out.println(" Result "  + productOfComboSum);
    }

    private List<Integer> processInputFromFileSystem() throws IOException {
        File file = new File(FILE_PATH);
        List<Integer> datalist = new ArrayList<>();
        try (BufferedReader fis = new BufferedReader(new FileReader(file))) {
            String lineEntry = null;
            while ((lineEntry = fis.readLine()) != null) {
                datalist.add(Integer.valueOf(lineEntry));
            }
        }
        return datalist;
    }

    public List<List<Integer>> identifyCombinationSum(int[] inputData, int sumTarget) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recurseCombo(inputData, 0, sumTarget, 0, temp, result);
        return result;
    }

    private void recurseCombo(int[] inputData, int startindex, int sumTarget, int currentSum,
                              List<Integer> list, List<List<Integer>> result){
        if(currentSum>sumTarget){
            return;
        }

        if(currentSum==sumTarget){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=startindex; i<inputData.length; i++){
            list.add(inputData[i]);
            recurseCombo(inputData, i, sumTarget, currentSum+inputData[i], list, result);
            list.remove(list.size()-1);
        }
    }

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }


    public static void main(String[] args) throws Exception {
        Triplet triplet = new Triplet();
     }

}
