package io;

import java.io.*;

public class CharIOExam2 {
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader(new FileReader("src/io/CharIOExam2.java"));
            pw = new PrintWriter(new FileWriter("test.txt"));
            String line = null;
            while ((line = br.readLine()) != null){
                pw.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                pw.close();
                br.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
