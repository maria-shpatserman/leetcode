package ru.netunix.leetcode.service;

public class SolutionNew {
    public static void main(String[] args) {
        int x = 0;
        SolutionNew s = new SolutionNew();
        int result = s.reverse(x);
        System.out.println("MAIN result "+result);

        int xx = 10200;
        int result2 = s.reverse(xx);
        System.out.println("MAIN result2 "+result2);


    }

    public int reverse(int x) {

        Boolean isNegative = (x < 0) ? true : false;
        String reversedString = getUnsignedReversedStringFromIntX(x, isNegative);
        System.out.println(reversedString);
        String trimmedZeros = removeZerosFromBeginning(reversedString);

        return  combineIntegerResult(trimmedZeros,isNegative);

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
        return (noZeros.length==0)?"0":noZeros[noZeros.length - 1];
    }

    int combineIntegerResult(String s, Boolean isNegative) {
        String maxIntegerValue = "2147483648";
        Integer maxLength = maxIntegerValue.length();
        int factor = (isNegative) ? -1 : 1;
        if (s.length() < maxLength) {
            return factor * Integer.parseInt(s);
        }
        if(s.compareTo(maxIntegerValue)<0){
            return factor * Integer.parseInt(s);
        }
        if (s.compareTo(maxIntegerValue)>0){
            return 0;
        }
        if(isNegative){
            return factor * Integer.parseInt(s);
        }
        return 0;
    }


}