/*
 * *********************************************************************
 * Copyright (C) Calibo LLC 2021. All rights reserved.
 *
 * This software is confidential and proprietary information
 * of Calibo LLC. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms and conditions
 * entered into with Calibo LLC.
 * ********************************************************************
 */

package org.hackerrank.algorithms;

import java.util.stream.IntStream;

/**
 * @author Prashant Patel
 */
public class FizzBuzz {
    public static void main(String[] args) {
        IntStream.rangeClosed(1,100).forEach(i->{String s=""+i;if(i%3==0&&i%5==0)s="FizzBuzz";else if(i%3==0)s="Fizz";else if(i%5==0)s="Buzz";System.out.println(s);});
    }
}
