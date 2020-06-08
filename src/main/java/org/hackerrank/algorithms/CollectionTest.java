package org.hackerrank.algorithms;

import java.util.*;

public class CollectionTest implements Cloneable {
    public static void main(String[] args) {
       //tryQueue();
       tryMap();


    }

    public static void tryQueue(){
        Deque<String> deque = new ArrayDeque<>();
        deque.add("1");
        deque.add("2");
        deque.add("3");
        System.out.println(deque);
        System.out.println(deque.peek());
        System.out.println(deque.peek());
        deque.poll();
        System.out.println(deque);
    }

    public static void tryMap(){
        Map<String,String> tMap = new TreeMap<>(Comparator.reverseOrder());
        tMap.put("1","ni");
        tMap.put("2","aa");
        System.out.println(tMap);

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
