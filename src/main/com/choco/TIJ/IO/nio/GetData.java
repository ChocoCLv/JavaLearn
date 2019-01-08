package com.choco.TIJ.IO.nio;

import java.nio.ByteBuffer;

import static com.choco.Util.Print.print;
import static com.choco.Util.Print.println;

public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);

        //Allocation automatically zeroes the ByteBuffer:
        int i = 0;
        //分配空间后自动置零
        while (i++ < bb.limit()) {
            if (bb.get() != 0)
                println("nonzero");
        }
        println("i = " + i);
        bb.rewind();
        //Store and read a char array:
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0) {
            print(c + " ");
        }
        println();
        bb.rewind();
        //Store and read a short
        //转换成short会截断
        bb.asShortBuffer().put((short) 471142);
        println(bb.getShort() + "");

    }
}
