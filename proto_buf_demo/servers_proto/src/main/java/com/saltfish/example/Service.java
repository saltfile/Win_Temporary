package com.saltfish.example;

import java.util.Arrays;

public class Service {
    public static void main(String[] args) {
        Meta.Pers.Builder bs = Meta.Pers.newBuilder();
        bs.setMessage("aaa");
        bs.setAge(11);


        Meta.Pers pers = bs.build();
        byte[] bytes = pers.toByteArray();
        System.out.println(Arrays.toString(bytes));

    }
}
