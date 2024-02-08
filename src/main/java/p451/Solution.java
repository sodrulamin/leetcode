package p451;

import java.util.*;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 07/02/2024
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Node> queue = new PriorityQueue<>(new MyComparator());

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i = 0; i < node.freq; i++){
                sb.append(node.c);
            }
        }

        return sb.toString();
    }

    private static class Node {
        char c;
        int freq;
        Node(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }

    private static class MyComparator implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if(a.freq == b.freq){
                return a.c - b.c;
            }
            return b.freq - a.freq;
        }
    }
}
