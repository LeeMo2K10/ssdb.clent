package com.udpwork.ssdb.demo;

import com.udpwork.ssdb.SSDB;
import com.udpwork.ssdb.pool.SSDBPool;

public class Test1 {
	
	public static void main(String[] args) {
		
		SSDBPool ssdbPool = new SSDBPool("127.0.0.1", 8888);
		SSDB resource = ssdbPool.getResource();
		boolean broken = false;
		try {
			resource.set("test_pool", "test_pool_value");
		} catch (Exception e) {
			e.printStackTrace();
			broken = true;
		}
		if(broken){
			ssdbPool.returnBrokenResource(resource);
		}else{
			ssdbPool.returnResource(resource);
		}
		
		resource = ssdbPool.getResource();
		broken = false;
		try {
			byte[] bs = resource.get("test_pool");
			System.out.println(new String(bs));
		} catch (Exception e) {
			e.printStackTrace();
			broken = true;
		}
		if(broken){
			ssdbPool.returnBrokenResource(resource);
		}else{
			ssdbPool.returnResource(resource);
		}
		
		
		ssdbPool.destroy();
		
	}
}
