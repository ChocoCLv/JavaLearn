package com.choco.TIJ.IO.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import static com.choco.Util.Print.println;

public class LargeMappedFiles {
    static int length = 0x8ffffff;

    public static void main(String[] args) throws Exception {
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw")
                .getChannel()
                //指定映射文件的起始位置和映射区域的长度，不一定映射文件的全部内容
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for(int i = 0;i<length;i++){
            out.put((byte)'x');
        }
        println("finish writing");
    }
}
