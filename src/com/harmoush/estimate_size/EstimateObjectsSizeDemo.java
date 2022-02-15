package com.harmoush.estimate_size;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class EstimateObjectsSizeDemo {

    public static void run() {
        System.out.println("VM.current() = " + VM.current().details());
//        calculateArraySize();

        System.out.println("Class Person  " + ClassLayout.parseClass(Person.class).toPrintable());
        System.out.println("Class A " + ClassLayout.parseClass(C.class).toPrintable());
        System.out.println("**********************");

        boolean[] booleans = new boolean[3];
        System.out.println(ClassLayout.parseInstance(booleans).toPrintable());


        double d = Double.MAX_VALUE;
        double o = d + 1;
        System.out.println("d = " + d);
        System.out.println("o = " + (d + 10));
    }

    private static void calculateArraySize() {
        Short[] arr = new Short[5];
        System.out.println("ClassLayout.parseInstance(ints).toPrintable() = " + ClassLayout.parseInstance(arr).toPrintable());
    }



    public static class A {
        int a;
    }

    public static class B extends A {
        int b;
    }

    public static class C extends B {
        int c;
    }

}
