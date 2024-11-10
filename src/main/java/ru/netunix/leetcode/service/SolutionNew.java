package ru.netunix.leetcode.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionNew {
    public static void main(String[] args) {
//        int x = 0;
//        SolutionNew s = new SolutionNew();
//        int result = s.reverse(x);
//        System.out.println("MAIN result "+result);
//
//        int xx = 10200;
//        int result2 = s.reverse(xx);
//        System.out.println("MAIN result2 "+result2);
        SolutionNew s = new SolutionNew();
        String input = "42";
        int result = s.myAtoi(input);
        System.out.println("MAIN result = " + result);
        input = "    -042";
        result = s.myAtoi(input);
        System.out.println("MAIN result = " + result);
        input = "1337c0d3";

        result = s.myAtoi(input);
        System.out.println("MAIN result = " + result);
        input = "0-1";
        result = s.myAtoi(input);
        System.out.println("MAIN result = " + result);
        input = "  0000000000012345678";
        result = s.myAtoi(input);
        System.out.println("MAIN result = " + result);


    }

    public int reverse(int x) {

        Boolean isNegative = (x < 0) ? true : false;
        String reversedString = getUnsignedReversedStringFromIntX(x, isNegative);
        System.out.println(reversedString);
        String trimmedZeros = removeZerosFromBeginning(reversedString);

        return combineIntegerResult(trimmedZeros, isNegative);

    }

    String getUnsignedReversedStringFromIntX(int x, Boolean isNegative) {
        String intToStr;
        if (isNegative) {
            intToStr = Integer.toString(x).substring(1);

        } else intToStr = Integer.toString(x);
        return new StringBuilder(intToStr).reverse().toString();
    }

    String removeZerosFromBeginning(String s) {
        //remove zeros
        String[] noZeros = s.split("^0*");
        return (noZeros.length == 0) ? "0" : noZeros[noZeros.length - 1];
    }

    int combineIntegerResult(String s, Boolean isNegative) {
        String maxIntegerValue = "2147483648";
        Integer maxLength = maxIntegerValue.length();
        int factor = (isNegative) ? -1 : 1;
        if (s.length() < maxLength) {
            return factor * Integer.parseInt(s);
        }
        if (s.compareTo(maxIntegerValue) < 0) {
            return factor * Integer.parseInt(s);
        }
        if (s.compareTo(maxIntegerValue) > 0) {
            return 0;
        }
        if (isNegative) {
            return factor * Integer.parseInt(s);
        }
        return 0;
    }

    public int myAtoi(String s) {
        if (s == null) return 0;
        String trimmed = s.trim();
        if (trimmed.isBlank()) return 0;
        Pattern regexp = Pattern.compile("(^[-+]?)([0-9]+).*");
        Matcher m = regexp.matcher(trimmed);

        if (m.find()) {
            String sign = m.group(1);
            String value =removeZerosFromBeginning( m.group(2));

            return combineRoundedIntegerResult(value, sign.equals("-"));
        } else return 0;


    }

    int combineRoundedIntegerResult(String s, Boolean isNegative) {
        String maxIntegerValue = "2147483648";
        Integer maxLength = maxIntegerValue.length();
        if(s.length()>maxLength)
            return  getBoundaryInteger(isNegative);

        int factor = (isNegative) ? -1 : 1;
        if (s.length() < maxLength) {
            return factor * Integer.parseInt(s);
        }
        if (s.compareTo(maxIntegerValue) < 0) {
            return factor * Integer.parseInt(s);
        }
        return getBoundaryInteger(isNegative);

    }

    int getBoundaryInteger(Boolean isNegative) {
        if (isNegative) {
            return -1 * Integer.parseInt("2147483647") - 1;
        }
        return Integer.parseInt("2147483647");

    }


}
