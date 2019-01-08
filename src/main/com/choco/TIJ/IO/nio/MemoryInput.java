package com.choco.TIJ.IO.nio;

import com.choco.TIJ.IO.BufferedInputFile;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("D:\\Project\\Java\\AlgorithmTraining\\src\\main\\com\\choco\\TIJ\\IO\\MemoryInput.java"));
        int c;
        while((c = in.read())!=-1){
            System.out.print((char)c);
        }
    }
}
