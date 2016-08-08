/**
 * 
 */
package com.czw.ehcache;

import java.net.URI;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.PersistentCacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.junit.Test;

/**
 * @author ZeviChen
 * @date 2016-08-08 20:37:16
 */
public class EhcacheTest {

	/**
	 * 缓存管理器预创建缓存和去数据的方式
	 */
	@Test
	public void cacheManager() {
		CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
				.withCache("preConfigured", CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class,
						String.class, ResourcePoolsBuilder.heap(10)))
				.build();
		cacheManager.init();

		Cache<Long, String> preConfigured = cacheManager.getCache("preConfigured", Long.class, String.class);

		Cache<Long, String> myCache = cacheManager.createCache("myCache", CacheConfigurationBuilder
				.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)).build());

		myCache.put(1L, "da one!");
		String value = myCache.get(1L);

		cacheManager.removeCache("preConfigured");

		cacheManager.close();
	}

	/**
	 * 分布是缓存,
	 */
	@Test
	public void clusterSupport() {
		// final CacheManagerBuilder<PersistentCacheManager>
		// clusteredCacheManagerBuilder =
		// CacheManagerBuilder.newCacheManagerBuilder()
		// .with(ClusteringServiceConfigurationBuilder.cluster(URI.create("terracotta://localhost:9510/my-application"))
		// .autoCreate());
		// final PersistentCacheManager cacheManager =
		// clusteredCacheManagerBuilder.build(true);
		//
		// cacheManager.close();
	}

}
