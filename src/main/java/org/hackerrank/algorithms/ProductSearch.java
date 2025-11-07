package org.hackerrank.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Prashant Patel
 */
public class ProductSearch {

    public static List<List<String>> getProductSuggestions(List<String> products, String search) {
        Collections.sort(products);
        List<List<String>> suggestions = new ArrayList<>();
        char[] charArray = search.toCharArray();
        StringBuilder prefix = new StringBuilder();
        for (char c : charArray) {
            prefix.append(c);
            suggestions.add(products.stream().filter(p -> p.startsWith(prefix.toString())).limit(3).toList());
        }
        return suggestions;
    }

    public static void main(String[] args) {
        List<String> products = new ArrayList<>();
        products.add("carpet");
        products.add("cart");
        products.add("car");
        products.add("camera");
        products.add("crate");
        System.out.println(getProductSuggestions(products, "camera"));
    }
}
