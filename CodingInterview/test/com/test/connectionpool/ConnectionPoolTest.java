package com.test.connectionpool;

import org.junit.Assert;
import org.junit.Test;

import com.connectionpool.ConnectionPool;

public class ConnectionPoolTest {

	@Test
	public void testPutObjectToConnectionPool(){
		ConnectionPool<String, String> connectionPool = new ConnectionPool<>(5);
		connectionPool.put("A", "1");
		connectionPool.put("B", "2");
		connectionPool.put("C", "3");
		connectionPool.put("D", "4");
		connectionPool.put("E", "5");
		Assert.assertEquals(5, connectionPool.size());
	}
	
	@Test
	public void testGetObjectToConnectionPool(){
		ConnectionPool<String, String> connectionPool = new ConnectionPool<>(3);
		connectionPool.put("A", "1");
		connectionPool.put("B", "2");
		connectionPool.put("C", "3");
		connectionPool.put("D", "4");
		connectionPool.put("E", "5");
		Assert.assertEquals(3, connectionPool.size());
		Assert.assertNull(connectionPool.get("A"));
		Assert.assertNull(connectionPool.get("B"));
		Assert.assertEquals("3", connectionPool.get("C"));
		Assert.assertEquals("4", connectionPool.get("D"));
		Assert.assertEquals("5", connectionPool.get("E"));
	}
}
