##1.Buffer
写数据到Buffer的方式有channel.read(buf)或者buf.put(xxx)<br/>
读数据的方式channel.write(buf)或者buf.get()
buf.rewind()postion=0再读一遍buf中的数据

`clear()`和`compact()`区别:
-   clear()会把position设置为0,limit设置为capacity,写入数据会覆盖之前未读取的数据,并且读取buf不会读到这些之前未读取的数据
-   compact会把position设置到未读取数据尾部的前面,limit=capacity,写入数据不会覆盖之前的未读数据,内部对这些未读数据做了标记

`mark()`和`reset()`作用:
-   标记position位置,reset()调用会回到mark()调用所标记的position位置,用于回到标记位重新读取

`equals()`对buf比较
-   有相同的类型（byte、char、int等）
-   Buffer中剩余的byte、char等的个数相等
-   Buffer中所有剩余的byte、char等都相同

`compareTo()`对buf比较
-   第一个不相等的元素小于另一个Buffer中对应的元素。
-   所有元素都相等，但第一个Buffer比另一个先耗尽(第一个Buffer的元素个数比另一个少)。

##2.Channel
`分散（Scatter）/聚集（Gather）`
```
//Scatter:将数据读取到多个buf中
ByteBuffer header = ByteBuffer.allocate(128);  
ByteBuffer body   = ByteBuffer.allocate(1024);  
  
ByteBuffer[] bufferArray = { header, body };  
channel.read(bufferArray);

//Gather:将多个buf中的数据写出
channel.write(bufferArray); 
```

通道间的数据读取:
如果两个通道其中有一个是FileChannel那么可以写成
```
FileChannel      toChannel = toFile.getChannel();  
long position = 0;  
long count = fromChannel.size();  
toChannel.transferFrom(position, count, fromChannel); 

//类似方法
fromChannel.transferTo(position, count, toChannel);
```
<font color="red">注:在SocketChannel中只会读取此刻准备好的数据,所以最终数据长度可能不足count</font>

##3.Selector
```
//与Selector一起使用时，Channel必须处于非阻塞模式下。
//这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。
//而套接字通道都可以。 
channel.configureBlocking(false);
SelectionKey key = channel.register(selector,
Selectionkey.OP_READ);
```
四种SelectionKey常量:
-   connect
-   accept
-   read
-   write
如果对多个感兴趣`int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE; `
```
//注册选择器会返回一个SelectionKey,可以通过下面的方式得到对应的值
int interestSet = selectionKey.interestOps();  
  
boolean isInterestedInAccept  = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT；  
boolean isInterestedInConnect = interestSet & SelectionKey.OP_CONNECT;  
boolean isInterestedInRead    = interestSet & SelectionKey.OP_READ;  
boolean isInterestedInWrite   = interestSet & SelectionKey.OP_WRITE; 
 
 //不过一般通过下面的方式处理
 selectionKey.isAcceptable();  
 selectionKey.isConnectable();  
 selectionKey.isReadable();  
 selectionKey.isWritable();  

```

附加对象的方式:
```
selectionKey.attach(theObject);  
Object attachedObj = selectionKey.attachment(); 

SelectionKey key = channel.register(selector, SelectionKey.OP_READ, theObject);  
```

处理事件:
```
Selector selector = Selector.open();  
channel.configureBlocking(false);  
SelectionKey key = channel.register(selector, SelectionKey.OP_READ);  
while(true) {  
    int readyChannels = selector.select();  
    if(readyChannels == 0) continue; 
    Set selectedKeys = selector.selectedKeys();  
    Iterator keyIterator = selectedKeys.iterator();  
    while(keyIterator.hasNext()) {  
        SelectionKey key = keyIterator.next();  
        if(key.isAcceptable()) {  
            // a connection was accepted by a ServerSocketChannel.  
        } else if (key.isConnectable()) {  
            // a connection was established with a remote server.  
        } else if (key.isReadable()) {  
            // a channel is ready for reading  
        } else if (key.isWritable()) {  
            // a channel is ready for writing  
        }  
        keyIterator.remove();
    }
}  
```

wakeUp()方法:
某个线程调用select()方法后阻塞了，即使没有通道已经就绪，也有办法让其从select()方法返回。
只要让其它线程在第一个线程调用select()方法的那个对象上调用Selector.wakeup()方法即可。
阻塞在select()方法上的线程会立马返回。 

如果有其它线程调用了wakeup()方法，但当前没有线程阻塞在select()方法上，下个调用select()方法的线程会立即“醒来（wake up）”。 

##4.FileChannel
force()强制将数据写入磁盘 
这个通道是阻塞模式

##5.SocketChannel和ServerSocketChannel
类似ServerSocket,和Socket

##6.DatagramChannel 

receive()方法会将接收到的数据包内容复制到指定的Buffer. 如果Buffer容不下收到的数据，多出的数据将被丢弃

##7.Pipe




