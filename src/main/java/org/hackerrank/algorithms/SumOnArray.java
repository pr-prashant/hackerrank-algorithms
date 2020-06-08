package org.hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Prashant Patel (312455)
 * Date: 3/13/2020
 **/
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class SumOnArray {
    public static void main(String args[] ) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String array = br.readLine();                // Reading input from STDIN

        int N = Integer.parseInt(n);
        List<Integer> list = Arrays.stream(array.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> sortedList = new LinkedList<>();

        for (int i=0; i< list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                for (int k = j+1; k < list.size(); k++) {
                    List<Integer> list1 = Stream.of(list.get(i), list.get(j),list.get(k)).sorted().collect(Collectors.toList());
                    int tripletScore = list1.get(1);
                    sortedList.add(tripletScore);
                }
            }
        }
        for(int i=0,j=i+1,k=i+2; i<3*N; i=i+3) {
            List<Integer> list1 = Stream.of(list.get(i), list.get(j),list.get(k)).sorted().collect(Collectors.toList());
            int tripletScore = list1.get(1);
            sortedList.add(tripletScore);
        }

        int sum=0;
        sortedList.sort(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            sum+=sortedList.get(i);
        }
        System.out.println(sum);
    }
}