package com.test.arrayandnumber;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MostFrequentWordFinder {

    Map<String, Integer> map = new HashMap<String, Integer>();

    public void getMostFrequentWord(File file) throws Exception {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        scanner.close();

        List<Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>(map.entrySet());

        Collections.sort(entries, new Comparator<Entry<String, Integer>>() {

            @Override
            public int compare(Entry<String, Integer> a, Entry<String, Integer> b) {
                return a.getValue().compareTo(b.getValue());
            }
        });

        for (Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
    }

    public static void main(String[] args) throws Exception {

        new MostFrequentWordFinder().getMostFrequentWord(new File("C:/Books/DS/Test.txt"));
    }

}
