package main.src.java.cardoso.HexToBase64;
import main.src.java.cardoso.HexToBase64.useful.CreateHashFromCSV;
import main.src.java.cardoso.HexToBase64.useful.UserInput;

import java.util.HashMap;


public class HexToBase64 {
    public static void main(String []args){
        System.out.println("Insira a string de hex para ser decodificada");
        String entrada = UserInput.scanner();
        char [] arr = entrada.toCharArray();
        String binarios = hexToCypher(arr);
        HashMap base64 = CreateHashFromCSV.database("base64.csv");
        System.out.println(binarios);
//        System.out.println(threeBytesToBase64(binarios, base64));
        System.out.println("Codigo Fonte em:");
    }

    public static String hexToCypher(char[]  hexa){
        HashMap base64 = CreateHashFromCSV.database("base64.csv");
        String cypher = "";
//        String bin = "";


        for(int index = 0; index < (hexa.length/3); index++){
            String three_bytes = "";
            for(int i = 0; i <= 2; i++){

                three_bytes = three_bytes+ hexa[i+index*3];
//                System.out.println(three_bytes);
             }
            int num = (Integer.parseInt(three_bytes, 16));
            String binary = Integer.toBinaryString(num);
            while (binary.length() != 12){
                binary = "0"+binary;
            }
//            bin = bin+ binary;
            cypher = cypher + threeBytesToBase64(binary, base64);

        }

        return cypher;


    }

    public static String threeBytesToBase64(String bytes, HashMap base64){
        char[] bits = bytes.toCharArray();
        String cifra1 = "";
        String cifra2 = "";
        for(int i = 0; i <= 11; i++){
            if(i <= 5){
                cifra1 = cifra1+bits[i];
            }
            if(i > 5){
                cifra2 = cifra2+bits[i];
            }
        }
        cifra1 = base64.get(cifra1).toString();
        cifra2 = base64.get(cifra2).toString();
        return cifra1+cifra2;
    }


}
