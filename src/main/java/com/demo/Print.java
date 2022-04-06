package com.demo;

import java.util.List;

/**
 * Write the code. Change the world.
 *
 * @author rsyan
 * Created on 2022-03-27
 */
public class Print {
    public static void print(Object o){
        System.out.print(o.toString());
    }
    public static void println(Object o){
        System.out.println(o.toString());
    }
    public static void printf(Object o,Object o1){
        System.out.printf(String.format(o.toString()),o1);
    }

    public static void main(String[] args) {
        System.out.println("this is main");
    }
}
