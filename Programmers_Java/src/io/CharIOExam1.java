package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharIOExam1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        try {
            line = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(line);


    }
}
