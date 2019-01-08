package com.choco.TIJ.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
    //Throws exceptions to console
    public static String
    read(String fileName) throws IOException{
        //Reading input by lines:
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine())!=null){
            sb.append(s+"\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        System.out.println(read("D:\\Project\\Java\\AlgorithmTraining\\src\\main\\com\\choco\\TIJ\\IO\\BufferedInputFile.java"));
    }
}
