package org.hackerrank.algorithms;

import java.util.*;

/**
 * @author Prashant Patel
 */
public class StockPrice {
    private int latestTimestamp;
    private Map<Integer, Integer> timePriceMap;
    private TreeMap<Integer, Integer> priceCountMap;

    public StockPrice() {
        latestTimestamp = 0;
        timePriceMap = new HashMap<>();
        priceCountMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        // If the timestamp already exists, adjust the previous price count
        if (timePriceMap.containsKey(timestamp)) {
            int oldPrice = timePriceMap.get(timestamp);
            int count = priceCountMap.get(oldPrice);
            if (count == 1) {
                priceCountMap.remove(oldPrice);
            } else {
                priceCountMap.put(oldPrice, count - 1);
            }
        }

        // Update the timestamp with the new price
        timePriceMap.put(timestamp, price);

        // Update the price count map
        priceCountMap.put(price, priceCountMap.getOrDefault(price, 0) + 1);

        // Update the latest timestamp
        latestTimestamp = Math.max(latestTimestamp, timestamp);
    }

    public int current() {
        return timePriceMap.get(latestTimestamp);
    }

    public int maximum() {
        return priceCountMap.lastKey(); // TreeMap stores keys in sorted order
    }

    public int minimum() {
        return priceCountMap.firstKey();
    }

    // Sample usage
    public static void main(String[] args) {
        StockPrice sp = new StockPrice();
        sp.update(1, 100);
        sp.update(2, 80);
        sp.update(3, 120);
        sp.update(2, 90); // correction at timestamp 2
        System.out.println("Current: " + sp.current()); // 120
        System.out.println("Max: " + sp.maximum());     // 120
        System.out.println("Min: " + sp.minimum());     // 90
    }
}

