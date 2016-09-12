package com.czw.util;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

/**
 * @author ZeviChen
 * @Date 2016-09-12 17:41:33
 */
public class MorphiaUtils {
	
	final static Morphia morphia;
	final static Datastore dataStore;
	
	static{
		morphia = new Morphia();
		morphia.mapPackage("com.czw.db.mongodb");
		dataStore = morphia.createDatastore(new MongoClient("192.168.229.128"), "test");
		dataStore.ensureIndexes();
		
	}
	
	
	
	
	
	
	
	
	
}
