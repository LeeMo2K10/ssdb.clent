package com.udpwork.ssdb.pool;

import org.apache.commons.pool.impl.GenericObjectPool.Config;
import com.udpwork.ssdb.SSDB;

public class SSDBPool extends Pool<SSDB>{
	
	private static final int DEFAULT_TIMEOUT = 2000;
	
	public SSDBPool(String host, int port) {
        this(new Config(), host, port, DEFAULT_TIMEOUT);
    }
	
	public SSDBPool(String host, int port,int timeout) {
        this(new Config(), host, port, timeout);
    }
	
	public SSDBPool(final Config poolConfig,String host, int port) {
        this(poolConfig, host, port, DEFAULT_TIMEOUT);
    }
	
	 public SSDBPool(final Config poolConfig, final String host, int port, int timeout) {
		super(poolConfig, new SSDBFactory(host, port, timeout));
	}
	
	public void returnBrokenResource(final SSDB resource) {
    	returnBrokenResourceObject(resource);
    }
    
    public void returnResource(final SSDB resource) {
    	returnResourceObject(resource);
    }   
}
