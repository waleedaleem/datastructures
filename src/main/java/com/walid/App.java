package com.walid;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class App {

    public static void main(String[] args) {
        leftRotate();
    }

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
}