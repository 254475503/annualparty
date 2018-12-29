package com.sohu.auto.annualparty;

import java.io.*;

public class testclass {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/participatores.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       /* File file = new File("file.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
