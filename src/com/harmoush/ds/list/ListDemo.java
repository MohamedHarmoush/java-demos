package com.harmoush.ds.list;

import com.harmoush.Utils;

public class ListDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        Utils.printCollection(list);
        list.set(0, 5);
        list.insert(1, 22);
        Utils.printCollection(list);

        System.out.println("list.remove(3) = " + list.remove(3));
        System.out.println("list.remove(element> 100) = " + list.remove(Integer.valueOf(100)));
        Utils.printCollection(list);

        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("list.indexOf(2) = " + list.indexOf(2));
        System.out.println("list.indexOf(25) = " + list.indexOf(25));

        list.clear();
        Utils.printCollection(list);

        System.out.println("*******************************************************");

        List<Integer> linkedList = new LinkedList<>();
        System.out.println("linkedList.remove(0) = " + linkedList.remove(0));

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(4);
        Utils.printCollection(linkedList);
        System.out.println("linkedList.size() = " + linkedList.size());
        linkedList.insert(0, 0);
        Utils.printCollection(linkedList);
        linkedList.insert(1, 22);
        Utils.printCollection(linkedList);
        linkedList.insert(3, 0);
        Utils.printCollection(linkedList);
        linkedList.set(0, 5);
        Utils.printCollection(linkedList);

        linkedList.set(5, 25);
        Utils.printCollection(linkedList);
        System.out.println("linkedList.get(2) = " + linkedList.get(2));
//
        System.out.println("list.remove(3) = " + linkedList.remove(3));
        Utils.printCollection(linkedList);
        System.out.println("list.remove(0) = " + linkedList.remove(0));
        Utils.printCollection(linkedList);
        System.out.println("list.remove(element> 25) = " + linkedList.remove(Integer.valueOf(25)));
        System.out.println("list.remove(element> 30) = " + linkedList.remove(Integer.valueOf(30)));
        Utils.printCollection(linkedList);
//
        System.out.println("list.indexOf(2) = " + linkedList.indexOf(2));
        System.out.println("list.indexOf(25) = " + linkedList.indexOf(25));

        linkedList.clear();
        System.out.println("linkedList.clear()");
        Utils.printCollection(linkedList);

    }

}
