package ru.matveykenya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private final static Integer INPUTS[][] = {
            {-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-6, -3, -2, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-4, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-6, -5, -4, -3, -2, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20, 100, 101, 102, 103, 105},
            {1, 3, 4, 6, 7, 9, 20, 21}
    };

    private final static String[] RESULTS = {
            "-6,-3-1,3-5,7-11,14,15,17-20",
            "-6,-3,-2,0,1,3-5,7-11,14,15,17-20",
            "-4-1,3-5,7-11,14,15,17-20",
            "-6--2,0,1,3-5,7-11,14,15,17-20,100-103,105",
            "1,3,4,6,7,9,20,21"
    };

    public static void main(String[] args) {

        for(int i = 0; i < INPUTS.length; i++){
            var result = convertToIntervals(INPUTS[i]);
            var expectedResult = RESULTS[i];
            boolean correct = result.equalsIgnoreCase(expectedResult);
            System.out.println("The result is " + (correct ? "correct. " : "incorrect. ") + "Result:" + result + " ExpectedResult:" + expectedResult);
        }
    }

    private static String convertToIntervals(Integer[] input) {
        final var result = new StringBuilder();
        int i1 = 0;
        int i2 = 0;
        String toResult;
        for (int i = 0; i <= input.length; i++) {
            if ((i + 1 > input.length) || (input[i] - input[i2] > 1)) {
                if (i1 == i2) {
                    toResult = input[i1].toString();
                } else if (i2 - i1 == 1) {
                    toResult = input[i1] + "," + input[i2];
                } else {
                    toResult = input[i1] + "-" + input[i2];
                }
                result.append(toResult);
                if (i < input.length) {
                    result.append(",");
                }
                i1 = i;
            }
            i2 = i;
        }
        return result.toString();
    }
}