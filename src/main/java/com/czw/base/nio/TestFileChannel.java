package com.czw.base.nio;

import com.czw.util.ComUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;


/**
 * capacity:缓冲区容量
 * position:读模式:开始读取位置,写模式:开始写的位置
 * limit:读模式:最多可以都的数据位置,写模式:capacity
 * <p>
 * 所以写模式到读模式的切换就是:limit=position,position=0,如果要考虑数据拷贝的性能提升，
 * 可以考虑DirectBuffer和HeapBuffer，暂时还没用，后面慢慢看吧
 * <p>
 * Created by ZeviChen on 2016/9/21.
 */
public class TestFileChannel {
    protected static Logger log = LoggerFactory.getLogger(TestFileChannel.class);

    @Test
    public void byteBufferTest() {
        try (
                RandomAccessFile raf = new RandomAccessFile(ComUtils.getFilePath("com.czw.base.nio", "nio.md", true), "rw");
                FileChannel fc = raf.getChannel()
        ) {

            System.out.println("file size: " + fc.size());
            ByteBuffer bb = ByteBuffer.allocateDirect(255);//分配系统内存，而非JVM内存
            while (fc.read(bb) != -1) {
                //写模式到读模式的切换
                bb.flip();
                Charset cs = Charset.defaultCharset();
                while (bb.hasRemaining()) {
                    System.out.println(cs.decode(bb));
                }
                //bb.clear();//清空所有数据
                bb.compact();//未读的数据放到缓冲区开始出等待下一次读取
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
