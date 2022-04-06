package com.reflect.showmethods;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Write the code. Change the world.
 *
 * @author rsyan
 * Created on 2022-04-06
 */
public class ShowMethods {
    private static String usage = "usage:\n" +
            "ShowMethods qualified.class.name\n" +
            "To show all methods in class or:\n" +
            "ShowMethods qualified.class.name word\n" +
            "To search for methods involving 'word'";
    private static Pattern pattern = Pattern.compile("\\w+\\.");

    public static void getMethods(String[] args) {
        if (args.length < 1){
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try{
            Class<?> aClass = Class.forName(args[0]);
            Method[] methods = aClass.getMethods();
            Constructor<?>[] constructors = aClass.getConstructors();
            if (args.length == 1){
                for (Method method : methods) {
                    System.out.println(pattern.matcher(method.toString()).replaceAll(""));
                }
                for (Constructor<?> constructor : constructors) {
                    System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
                }
                lines = methods.length + constructors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().indexOf(args[1]) != -1){
                        System.out.println(pattern.matcher(method.toString()).replaceAll(""));
                        lines ++;
                    }
                }
                for (Constructor<?> constructor : constructors) {
                    if (constructor.toString().indexOf(args[1]) != -1){
                        System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
                        lines ++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}
