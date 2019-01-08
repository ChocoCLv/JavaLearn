package com.choco.TIJ.IO;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try{
            DataInputStream in  = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read("D:\\Project\\Java\\AlgorithmTraining\\src\\main\\com\\choco\\TIJ\\IO\\FormattedMemoryInput.java").getBytes()
                    )
            );
            while (true){
                System.out.print((char)in.readByte());
            }
        }catch (EOFException e){
            System.out.println("End of stream");
        }
    }
}
