ehcache 包可用方法介绍：
	创建CacheManager 的方法：
	
	方法一：
	CacheManager manager = new CacheManager();
	
	方法二：
	CacheManager manager = new CacheManager("src/config/ehcache.xml");
	
	方法三：
	URL url = getClass().getResource("/anotherconfigurationname.xml");
	CacheManager manager = new CacheManager(url);
	
	方法四：
	InputStream fis = new FileInputStream(new File("src/config/ehcache.xml").getAbsolutePath());
	try {
		CacheManager manager = new CacheManager(fis);
	} finally {
		is.close();
	}


获取cacheNames 列表：

	方法一：
	CacheManager.create();
	String[] cacheNames = CacheManager.getInstance().getCacheNames();
	
	方法二：
	CacheManager manager = new CacheManager();
	String[] cacheNames = manager.getCacheNames();
	
	方法三：
	CacheManager manager1 = new CacheManager("src/config/ehcache1.xml");
	CacheManager manager2 = new CacheManager("src/config/ehcache2.xml");
	String[] cacheNamesForManager1 = manager1.getCacheNames();
	String[] cacheNamesForManager2 = manager2.getCacheNames();

添加和删除缓存元素：

设置一个名为testCache 的新cache，属性为默认：
CacheManager singletonManager = CacheManager.create();
singletonManager.addCache("testCache");
Cache test = singletonManager.getCache("testCache");

设置一个名为testCache 的新cache，并定义其属性： 
CacheManager singletonManager = CacheManager.create();
Cache memoryOnlyCache = new Cache("testCache", 5000, false, false, 5, 2);
singletonManager.addCache(memoryOnlyCache);
Cache test = singletonManager.getCache("testCache");

Cache 属性说明：

构造函数：
	public Cache(String name,
	
	int maxElementsInMemory,
	
	boolean overflowToDisk,
	boolean eternal,
	
	long timeToLiveSeconds,
	
	long timeToIdleSeconds)
	
	参数说明：
	name ：元素名字。
	maxElementsInMemory ：设定内存中创建对象的最大值。
	overflowToDisk ： 设置当内存中缓存达到 maxInMemory 限制时元素是否可写到磁盘上。
	eternal ： 设置元素是否永久驻留。
	timeToIdleSeconds ： 设置某个元素消亡前的停顿时间。也就是在一个元素消亡之前，两次访问时间的最大时间间隔值。只能在元素不是永久驻留时有效。
	timeToLiveSeconds ： 设置某个元素消亡前的生存时间。也就是一个元素从构建到消亡的最大时间间隔值。只能在元素不是永久驻留时有效。

删除缓存元素：
	CacheManager singletonManager = CacheManager.create();
	singletonManager.removeCache("testCache");


关闭缓存管理器 CacheManager
	CacheManager.getInstance().shutdown();


对于缓存对象的操作：


放入一个简单的对象到缓存元素；
	Cache cache = manager.getCache("testCache");
	Element element = new Element("key1", "value1");
	cache.put(element);

得到一个序列化后的对象属性值；
	Cache cache = manager.getCache("testCache");
	Element element = cache.get("key1");
	Serializable value = element.getValue();

得到一个没有序列化后的对象属性值；
	Cache cache = manager.getCache("testCache");
	Element element = cache.get("key1");
	Object value = element.getObjectValue();

删除一个对象从元素；
	Cache cache = manager.getCache("testCache");
	Element element = new Element("key1", "value1");
	cache.remove("key1");

对于永固性磁盘存储，立即存储到磁盘：
	Cache cache = manager.getCache("testCache");
	cache.flush();


获得缓存大小：


得到缓存的对象数量；
	Cache cache = manager.getCache("testCache");
	int elementsInMemory = cache.getSize();

得到缓存对象占用内存的数量
	Cache cache = manager.getCache("testCache");
	long elementsInMemory = cache.getMemoryStoreSize();

得到缓存对对象占用磁盘的数量
	Cache cache = manager.getCache("testCache");
	long elementsInMemory = cache.getDiskStoreSize();

关于缓存的读取和丢失的记录：


得到缓存读取的命中次数；
	Cache cache = manager.getCache("testCache");
	int hits = cache.getHitCount();

得到内存中缓存读取的命中次数；
	Cache cache = manager.getCache("testCache");
	int hits = cache.getMemoryStoreHitCount();

得到磁盘中缓存读取的命中次数；
	Cache cache = manager.getCache("testCache");
	int hits = cache.getDiskStoreCount();

得到缓存读取的丢失次数；
	Cache cache = manager.getCache("testCache");
	int hits = cache.getMissCountNotFound();

得到缓存读取的已经被销毁的对象丢失次数；
	Cache cache = manager.getCache("testCache");
	int hits = cache.getMissCountExpired();