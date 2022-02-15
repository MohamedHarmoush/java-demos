package com.harmoush.estimate_size;

public class UserCache {

    public static void main(String[] args){
        User [] cachedUsers = new User[1_000_000];
        while(true){}
    }
    private static class User{
        Long id;
        String name; //assume 36 characters long
        Integer salary;
        Double account;
        Boolean isActive;
    }
}
