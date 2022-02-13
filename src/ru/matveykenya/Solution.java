package ru.matveykenya;

import java.util.Arrays;
import java.util.Locale;

class Solution{

    public static void main(String[] args) {
        System.out.println(Solution.toCamelCase("fff-rrrr-tttyy"));
    }

    static String toCamelCase(String s){
        var ss = s.split("-");
        var sss = new StringBuilder();
        for (String s1:ss){
            s1 = s1.substring(0, 1).toUpperCase() + s1.substring(1);
            sss.append(s1);
        }
        return sss.toString();
    }
}