package com.choco.TIJ.IO.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static com.choco.Util.Print.println;

public class IntBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);

        IntBuffer ib = bb.asIntBuffer();

        ib.put(new int[]{1, 2, 3434, 5});
        println(ib.get(2) + "");
        ib.put(2, 18);
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            println(i + "");
        }
    }
}
