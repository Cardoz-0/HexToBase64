package main.src.java.cardoso.HexToBase64.useful;

import java.util.Arrays;

public class AppendArray {
    public static char[] appendCharToArray(char[] arr, char element) {
//        System.out.println(Arrays.toString(arr));
        int len = arr.length;
        char[] newArray = new char[len + 1];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        ;
        newArray[len] = element;
//        System.out.println(Arrays.toString(newArray));
//        System.out.println("\n");
        return newArray;
    }
}