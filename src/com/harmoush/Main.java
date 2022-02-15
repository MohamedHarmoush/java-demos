package com.harmoush;

import com.harmoush.ds.stack.ConvertInfixToPostfix;

public class Main {

    public static void main(String[] args) throws Exception {
//        StackDemo.run();
//        EstimateObjectsSizeDemo.run();
        System.out.println(ConvertInfixToPostfix.run("A+B*C$D/E-F"));
        System.out.println(ConvertInfixToPostfix.execute("A+B*C$D/E-F"));
    }


}
