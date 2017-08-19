package com.walid;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class App {

    public static void main(String[] args) {

        leftRotate();

        makeAnagram();
    }

    /**
     * Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.
     */
    public static void leftRotate() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        for (int i = 0; i < k; i++) {
            List<Integer> aList = IntStream.of(a)
                    .skip(1)
                    .boxed()
                    .collect(Collectors.toList());
            aList.add(a[0]);
            a = aList.stream().mapToInt(I -> I.intValue()).toArray();
        }

        System.out.println(IntStream.of(a)
                .boxed()
                .map(x -> String.valueOf(x))
                .collect(Collectors.joining(" ")));
    }


    /**
     * Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.
     */
    public static void makeAnagram() {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }

    private static long numberNeeded(String first, String second) {

        int needeNumber = 0;

        String firstMutable = first;
        String secondMutable = second;


        if (first == null || first.length() == 0) {
            return second.length();
        } else if (second == null || second.length() == 0) {
            return first.length();
        }

        for (char c : first.toCharArray()) {
            if (secondMutable.indexOf(c) == -1) {
                needeNumber++;
            } else {
                secondMutable = secondMutable.replaceFirst(String.valueOf(c), "");
            }
        }

        for (char c : second.toCharArray()) {
            if (firstMutable.indexOf(c) == -1) {
                needeNumber++;
            } else {
                firstMutable = firstMutable.replaceFirst(String.valueOf(c), "");
            }
        }

        return needeNumber;
    }
}