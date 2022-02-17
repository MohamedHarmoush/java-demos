package com.harmoush.ds.list;

import com.harmoush.Utils;

public class ListDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.set(0, 5);
        list.insert(1, 22);
        Utils.printCollection(list);

        System.out.println("list.remove(3) = " + list.remove(3));
        Utils.printCollection(list);

        list.clear();
        Utils.printCollection(list);

    }

}
