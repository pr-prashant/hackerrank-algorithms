package org.hackerrank.algorithms;

/**
 * @author Prashant Patel (312455)
 * Date: 3/12/2020
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ClosetToZero {
    static int Solve(int N, int[] A){
        int closet = Integer.MAX_VALUE;
        // Write your code here
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int absValue = Math.abs(A[i]);
            if(absValue<closet) {
                closet = Math.abs(A[i]);
            }
            map.putIfAbsent(absValue,new ArrayList<>());
            List<Integer> list = map.get(absValue);
            list.add(A[i]);
            map.put(absValue,list);
        }
        return Collections.max(map.get(closet));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        String[] arr_A = br.readLine().split(" ");
        for(int i_A = 0; i_A < N; i_A++) {
            A[i_A] = Integer.parseInt(arr_A[i_A]);
        }
        int out_ = Solve(N, A);
        System.out.println(out_);

        wr.close();
        br.close();
    }

}
