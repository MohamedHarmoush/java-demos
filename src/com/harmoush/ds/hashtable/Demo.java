package com.harmoush.ds.hashtable;

import java.util.List;

public class Demo {

    public static void main(String[] args) {
        /*Map<String, Integer> hashTable = new HashTable<>();
        System.out.println("HashTable");
        hashTableExample(hashTable);


        Map<String, Integer> hashTableV2 = new HashTableV2<>();
        System.out.println("*******************");
        System.out.println("HashTableV2");
        hashTableExample(hashTableV2);*/

        Map<String, Integer> tableLinearProbing = new HashTableLinearProbing<>(5);
        System.out.println("*******************");
        System.out.println("HashTableLinearProbing");
        hashTableExample(tableLinearProbing);
    }

    private static void hashTableExample(Map<String, Integer> hashTable) {
        System.out.println("hashTable.containsKey(K-18) = " + hashTable.containsKey("K-18"));
        System.out.println("hashTable.containsValue(18) = " + hashTable.containsValue(18));
        System.out.println("hashTable.isEmpty() = " + hashTable.isEmpty());
        System.out.println("hashTable.size() = " + hashTable.size());

        System.out.println("keys = " + convertListToString(hashTable.keys()));
        System.out.println("values = " + convertListToString(hashTable.values()));

        System.out.println("hashTable.get(K-18) = " + hashTable.get("K-18"));
        hashTable.remove("K-18");

        hashTable.put("K-17", 17);
        System.out.println("before clear> hashTable.size() = " + hashTable.size());
        hashTable.clear();
        System.out.println("after clear> hashTable.size() = " + hashTable.size());

        hashTable.put("K-18", 18);
        hashTable.put("K-19", 19);
        hashTable.put("K-15", 15);
        hashTable.put("K-17", 17);
        hashTable.put("K-14", 14);

        System.out.println("keys = " + convertListToString(hashTable.keys()));
        System.out.println("values = " + convertListToString(hashTable.values()));

        System.out.println("hashTable.containsKey(K-18) = " + hashTable.containsKey("K-18"));
        System.out.println("hashTable.containsValue(18) = " + hashTable.containsValue(18));
        System.out.println("hashTable.isEmpty() = " + hashTable.isEmpty());
        System.out.println("hashTable.size() = " + hashTable.size());

        System.out.println("hashTable.get(K-14) = " + hashTable.get("K-14"));
        hashTable.put("K-14", 15);
        hashTable.put("K-14", 77);

        System.out.println("hashTable = " + hashTable);
    }

    private static <T> String convertListToString(List<T> list) {
        StringBuilder builder = new StringBuilder("[");
        if (list.isEmpty()) {
            builder.append("]");
        } else {
            for (int i = 0; i < list.size(); i++) {
                T item = list.get(i);
                builder.append(item.toString());
                if (i != list.size() - 1) {
                    builder.append(", ");
                } else {
                    builder.append("]");
                }
            }
        }
        return builder.toString();
    }
}
