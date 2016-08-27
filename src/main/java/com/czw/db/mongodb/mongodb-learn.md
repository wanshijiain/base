	
	
	
	Mongodb命令：【http://www.runoob.com/mongodb/mongodb-databases-documents-collections.html】
		
		关系型数据库区别：
			RDBMS			MongoDB
			数据库			数据库
			表格				集合(collection)
			行				文档(document)
			列				字段(field)
			表联合			嵌入文档
			主键				主键(默认_id自增主键,是字符串)
			
			注：$特定环境使用,_保留
		
		
		mongod.exe --dbpath "d:\opensource\mongodb\data"		//运行
		
		cmd  mongo.exe连接
		
		show dbs	//显示所有数据库
		db			//显示当前数据库，db.getName();
		use test	//使用测试数据库,当没有这个数据库就会创建
		db.stats();
		db.version();
		db.getMongo();
	
	注：数据库名不含特殊字符，最多64字节，全部小写
	
	//默认数据库
		admin		//给这个数据库添加用户默认可使用所有数据库
		local		//存储于本地的所有集合,不可复制
		config		//分片设置时保存相关信息
		
		注：文档不需要设置相同的字段，并且相同的字段不需要相同的数据类型
		
		运行mongodb连接数据库：
		mongodb://localhost		
		
		> mongodb://admin:123456@localhost/test
		
		//帮助
		db.help();
		db.yourColl.help();
		db.youColl.find().help();
		rs.help();
		
		//数据库
			db.cloneDatabase(“127.0.0.1”); 
			db.copyDatabase("mydb", "temp", "127.0.0.1");
		
		//集合
			db.getCollection("account");
			db.getCollectionNames();
			db.printCollectionStats();
		
		//用户
			db.addUser("name");
			db.addUser("userName", "pwd123", true); 
			db.auth("userName", "123123");
			show users;
			db.removeUser("userName");
		
		//crud
			db.userInfo.find();
			db.userInfo.find({$or: [{age: 22}, {age: 25}]});	//分页
			db.userInfo.getIndexes();
			db.userInfo.totalIndexSize();
			db.users.reIndex();
			db.users.dropIndex("name_1");
			db.users.dropIndexes();
		
		//js方式
			print("Hello World!");
			tojson(new Object());
			tojson(new Object('a'));
			
			>var cursor = db.users.find();
			>while (cursor.hasNext()) { 
			    printjson(cursor.next()); 
			}
			
			> var arr = db.users.find().toArray();
			> printjson(arr[2]);
		
	
	
	##1.增删改查：
		db.dbname.insert({"name":"mongodb"})	//插入数据
		db.dropDatabase()						//删除数据库
		
		db.collname.insert(document)			//插入文档
		
		document=({title:"标题"})
		db.collname.insert(document)			//定义变量然后插入
		>db.col.update({'title':'MongoDB 教程'},{$set:{'title':'MongoDB'}},{multi:true})					//更新,multi:true更改所有的文档
		save
		pretty			//格式化显示数据
		
		db.collection.remove(
		   <query>,						//删除的文档的条件,可选
		   {
		     justOne: <boolean>,		//true或者1,删除一行,可选
		     writeConcern: <document>	//抛出异常的级别,可选
		   }
		)	
		
		db.user.find({random:{$eq:7}},{"age":1,"name":1,"_id":0})		//默认返回_id,可以设置返回特定字段
	
	##2.比较：
		操作					格式								范例							RDBMS中的类似语句
		
		等于			{<key>:<value>}			db.col.find({"by":"菜鸟教程"}).pretty()		where by = '菜鸟教程'
		
		小于			{<key>:{$lt:<value>}}	db.col.find({"likes":{$lt:50}}).pretty()	where likes < 50
		
		小于或等于	{<key>:{$lte:<value>}}	db.col.find({"likes":{$lte:50}}).pretty()	where likes <= 50
		
		大于			{<key>:{$gt:<value>}}	db.col.find({"likes":{$gt:50}}).pretty()	where likes > 50
		
		大于或等于	{<key>:{$gte:<value>}}	db.col.find({"likes":{$gte:50}}).pretty()	where likes >= 50
		
		不等于		{<key>:{$ne:<value>}}	db.col.find({"likes":{$ne:50}}).pretty()	where likes != 50
		
		
		返回title为String类型的数据：【类型和数字的对应看$type  其中String对应2】
		db.col.find({"title" : {$type : 2}})
		
		limit(1).skip(1)		//指定数量的数据和跳过指定数量的数据
		
		sort({"likes":-1})		// 1 升序 -1降序
	
	
	##3.创建索引：
		
		db.values.ensureIndex({open: 1, close: 1}, {background: true})	//创建索引会阻塞数据库，background在后台建     1   升序   -1  降序
		
	##4.聚合的使用（就是数据库的分组概念）
		【select by_user,count(*) tongji from person group by by_user】
		db.mycol.aggregate([{$group : {_id : "$by_user", tongji : {$sum : 1}}}])
	
	
	##5.管道(linux中的概念：上个命令执行的结果可以作为下一个命令的参数):
		
		db.article.aggregate({ 
			$project : {
		        _id : 0 ,		//_id默认是返回的，如果不想返回就这么写
		        title : 1 ,
		        author : 1
	    }});
	    
	    db.articles.aggregate( [		//结果匹配
		    { $match : { score : { $gt : 70, $lte : 90 } } },
		    { $group: { _id: null, count: { $sum: 1 } } }
	    ]);
		说明：$match用于获取分数大于70小于或等于90记录，然后将符合条件的记录送到下一阶段$group管道操作符进行处理。
		
		db.article.aggregate(
	    { $skip : 5 });
		说明：经过$skip管道操作符处理后，前五个文档被"过滤"掉。
		
	##6.复制(副本集)
		
		创建master:mongod --port 27017 --dbpath "D:\set up\mongodb\data" --replSet rs0
		
		在另个服务器上打开命令行连接这个主服务器，rs.initiate()新建副本,rs.conf()查看副本配置,rs.status()使用状态,db.isMaster() 查看是否是主节点
		
		复制:rs.add(HOST_NAME:PORT)		//rs.add("mongod1.net:27017")	
		
	##7.分片(分布式存储)
		说明：一个副本集可以建12个节点,这种分布式结构有nginx,mongodb,分布存储服务器组成
		
		具体操作地址：http://www.runoob.com/mongodb/mongodb-sharding.html
	
	##8.备份
		mongodump -h dbhost -d dbname -o dbdirectory		//备份
		
		
		mongorestore -h dbhost -d dbname --directoryperdb dbdirectory		
		mongorestore		//恢复
	
	##9.监控
	
		mongostat		//mongo自带的检测命令，当数据库变慢等查看
		mongotop		//自带工具
	
	
	##10.关系
	
		现在版本的mongodb加入了join【再看】
	
		引用式关系：
			var result = db.users.findOne({"name":"Tom Benzamin"},{"address_ids":1})
			var addresses = db.address.find({"_id":{"$in":result["address_ids"]}})
	
	
	##11.引用
		
		数据库引用和手动引用：
			
			情况：当地址集合有address_home,address_office,address_mailing,手动引用需要分别去这几个集合中
				查找对应的地址信息，当数据量变大会影响查询速度
			
			{
			   "_id":ObjectId("53402597d852426020000002"),
			   "address": {
			   "$ref": "address_home",
			   "$id": ObjectId("534009e4d852427820000002"),
			   "$db": "w3cschoolcc"},
			   "contact": "987654321",
			   "dob": "01-01-1991",
			   "name": "Tom Benzamin"
			}
			
			var user = db.users.findOne({"name":"Tom Benzamin"})
			var dbRef = user.address
			db[dbRef.$ref].findOne({"_id":(dbRef.$id)})
	
	##12.覆盖索引查询
	
		就是建立索引字段，查询和返回的字段都是索引中的，索引存在于ram中，所以速度会快很多。
		
		explain()		来获取更详细的操作信息
		hint()			虽然mongodb有覆盖索引的优化，但可以使用该方法来强制使用指定索引
	
	
	##13.ObjectId()
		
		ObjectId 是一个12字节 BSON 类型数据，有以下格式：
			前4个字节表示时间戳
			接下来的3个字节是机器标识码
			紧接的两个字节由进程id组成（PID）
			最后三个字节是随机数。
				
		newObjectId = ObjectId()
		
		ObjectId("5349b4ddd2781d08c09890f4").getTimestamp()				//ISODate("2014-04-12T21:49:17Z")
	
		new ObjectId().str				//5349b4ddd2781d08c09890f3	(Guid格式的字符串)
	
	
	##14.MapReduce
		
		//通过一些参数计算对结果分组，list
		var map = function() {
		    var category;
		    if ( this.pagenum >= 1000 ) 
		        category = 'Big Books';
		    else 
		        category = "Small Books";
		    emit(category, {name: this.name});
		};
		
		//对分组结果进行计算
		var reduce = function(key, values) {		//key是category,values是emit的结果
		    var sum = 0;
		    values.forEach(function(doc) {
		    sum += 1;
		    });
		    return {books: sum};	
		};
		
		
		//计算
		db.books.mapReduce(map, reduce, {out: "book_results"});			// {out:{inline:1}}直接打印结果
		
		//查看结果
		db.book_results.find()
	
	
	##15.全文索引
		
		暂不支持中文
		
		db.posts.ensureIndex({post_text:"text"})					//建立全文索引
		db.posts.find({$text:{$search:"w3cschool.cc"}})				//根据全文索引查找
		db.posts.dropIndex("post_text_text")						//删除全文索引
	
	
	##16.正则表达式
	
		db.posts.find({post_text:{$regex:"w3cschool.cc"}})
		db.posts.find({post_text:/w3cschool.cc/})			//这两种写法都可以
		
		db.posts.find({post_text:{$regex:"w3cschool.cc",$options:"$i"}})	//添加这个配置项就不区分大小写
		
		//拼接字符串需要eval转换
		var name=eval("/" + 变量值key +"/i"); 
		
		//可以使用^   $   口头或结尾查找
		
	
	##17.GridFS
		
		存储音视频的大的文件(超过BSON 16M限制的文件),用两个文档来存储一个文件,file文档存储文件信息,
			chunk文档存储讲文件分块成256k/个的片段来进行存储
		
		mongofiles.exe -d gridfs put song.mp3
		db.fs.files.find()
		db.fs.chunks.find({files_id:ObjectId('534a811bf8b4aa4d33fdf94d')})		//通过find的_id找到文件的chunks
	
	
	##18.固定集合(Capped Collections)
		
		集合大小固定，当存储满了以后，插入新的数据会淘汰最早的数据
		
		//size集合大小设置,max文档个数设置
		db.createCollection("cappedLogCollection",{capped:true,size:10000,max:1000})
		
		db.user.isCapped()		//是否是固定集合
		
		//将集合转换成固定集合
		db.runCommand({"convertToCapped":"user",size:10000})
		
		//获取是按照插入的顺序返回，如果要改变顺序
		.sort({$natural:-1})
		
		
		功能特点：可以插入及更新,但更新不能超出collection的大小,否则更新失败,
			不允许删除,但是可以调用drop()删除集合中的所有行,但是drop后需要显式地重建集合。
			在32位机子上一个cappped collection的最大值约为482.5M,64位上只受系统文件大小的限制。
		
	
	##19.自增
		
		
		
		
		
		
		
	##20.原子操作
		
		mongodb不支持事务，但文档的增删改都是原子操作，要么完成操作要么不操作
		
		db.books.findAndModify ( {
		   query: {
		            _id: 123456789,
		            available: { $gt: 0 }		//只有在该字段大于0才可以做更新操作
		          },
		   update: {
		             $inc: { available: -1 },
		             $push: { checkout: { by: "abc", date: new Date() } }
		           }
		} )
		
		$set		//用来指定一个键并更新键值，若键不存在并创建。
		$unset		//用来删除一个键。
		$inc		//$inc可以对文档的某个值为数字型（只能为满足要求的数字）的键进行增减的操作。
		$push		//把value追加到field里面去，field一定要是数组类型才行，如果field不存在，会新增一个数组类型加进去。
		$pushAll	//同$push,只是一次可以追加多个值到一个数组字段内。
		$pull		//从数组field内删除一个等于value值。
		$addToSet	//增加一个值到数组内，而且只有当这个值不在数组内才增加。
		$pop 		//删除数组的第一个或最后一个元素
		$rename		//修改字段名称
		
		$bit		//位操作，integer类型
			{$bit : { field : {and : 5}}}  //and 与运算
	
	##21.游标
		
		说明：游标默认超过10分钟就关闭
		
		db.user.find().batchSize(10)		//每页返回是个数据 
		db.user.find().addOptions(DbQuery.Option.noTimeOut);		//用db.serverStatus().metrics.cursor查看设置状态
	
	