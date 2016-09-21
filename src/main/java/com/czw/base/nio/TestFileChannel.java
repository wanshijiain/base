package com.czw.base.nio;

import com.czw.util.ComUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * Created by ZeviChen on 2016/9/21.
 */
public class TestFileChannel {
    protected static Logger log = LoggerFactory.getLogger(TestFileChannel.class);

    @Test
    public void byteBufferTest() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(ComUtils.getFilePath(TestFileChannel.class, "com.czw.base.nio", "nio.md", true), "rw");
        FileChannel fc = raf.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(48);
        int flag = fc.read(bb);
        while (flag != -1) {
            System.out.println("flag = " + flag);

            bb.flip();
            while (bb.hasRemaining()) {
                System.out.println("remain:" + (char) bb.get());
            }

            bb.clear();
            flag = fc.read(bb);
            //
        }


    }
}
