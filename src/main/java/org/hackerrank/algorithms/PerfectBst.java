package org.hackerrank.algorithms;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Prashant Patel
 */
public class PerfectBst {

    public static void main(String[] args) {

        List<Integer> n1 = List.of(17,-1,-1);
        List<Integer> n2 = List.of(15,13,17);
        List<Integer> n3 = List.of(7,6,-1);
        List<Integer> n7 = List.of(10,5,15);
        List<Integer> n4 = List.of(13,-1,-1);
        List<Integer> n5 = List.of(5,3,7);
        List<Integer> n6 = List.of(3,-1,-1);
        List<Integer> n8 = List.of(6,-1,-1);
        List<List<Integer>> input = new ArrayList<>();
        input.add(n1);
        input.add(n7);
        input.add(n2);
        input.add(n3);
        input.add(n4);
        input.add(n5);
        input.add(n6);
        input.add(n8);
        System.out.println(findRoot(input));
    }

    public static int findRoot(List<List<Integer>> nodes) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        nodes.forEach(node -> {
            nodeMap.put(node.get(0), new Node(node.get(0)));
            if (node.get(1) != -1) {
                parentMap.put(node.get(1), node.get(0));
            }
            if (node.get(2) != -1) {
                parentMap.put(node.get(2), node.get(0));
            }
        });

        nodes.forEach(node -> {
            Node temp = nodeMap.get(node.get(0));
            if (node.get(1) != -1) {
                temp.left = nodeMap.get(node.get(1));
            }
            if (node.get(2) != -1) {
                temp.right = nodeMap.get(node.get(2));
            }
        });
        nodeMap.forEach((k, v) -> {
            System.out.println(k + "--" + v);
        });
        System.out.println("--------------");
        parentMap.forEach((k, v) -> {
            System.out.println(k + "--" + v);
        });
        int root = -1;
        for (Integer v : nodeMap.keySet()) {
            if (!parentMap.containsKey(v)) {
                root = v;
            }
        }
        if (!isPerfectBst(nodeMap.get(root))) {
            return -1;
        }
        System.out.println("Root : " + root);
        return root;
    }

    static boolean isPerfectBst(Node node) {
        if (node == null) {
            return true;
        }
        if ((node.left != null && node.right == null) || (node.right != null && node.left == null)) {
            return false;
        }
        if (node.left != null && node.right != null) {
            return node.value > node.left.value && node.value < node.right.value && isPerfectBst(node.left) && isPerfectBst(node.right);
        }
        return true;
    }

    @Data
    static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
