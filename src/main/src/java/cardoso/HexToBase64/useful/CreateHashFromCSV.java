package main.src.java.cardoso.HexToBase64.useful;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CreateHashFromCSV {
    public static HashMap database(String csvFile){
        HashMap<String, String> base64 = new HashMap<String, String>();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] coluna = line.split(splitBy);
                base64.put(coluna[1], coluna[0]);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return base64;
    }
}
