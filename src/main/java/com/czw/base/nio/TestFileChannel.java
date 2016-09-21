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
 * capacity:缓冲区容量
 * position:读模式:开始读取位置,写模式:开始写的位置
 * limit:读模式:最多可以都的数据位置,写模式:capacity
 *
 * 所以写模式到读模式的切换就是:limit=position,position=0
 *
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

            //写模式到读模式的切换
            bb.flip();
            while (bb.hasRemaining()) {
                System.out.println("remain:" + (char) bb.get());
            }

            bb.clear();//清空所有数据
            bb.compact();//未读的数据放到缓冲区开始出等待下一次读取
            flag = fc.read(bb);
            //
        }


    }
}
