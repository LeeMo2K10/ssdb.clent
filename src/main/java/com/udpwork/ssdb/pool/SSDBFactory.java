package com.udpwork.ssdb.pool;

import org.apache.commons.pool.BasePoolableObjectFactory;

import com.udpwork.ssdb.SSDB;

/**
 * PoolableObjectFactory custom impl.
 */
class SSDBFactory extends BasePoolableObjectFactory<SSDB> {
	private final String host;
	private final int port;
	private final int timeout;

	public SSDBFactory(final String host, final int port, final int timeout) {
		super();
		this.host = host;
		this.port = port;
		this.timeout = timeout;
	}

	public SSDB makeObject() throws Exception {
		return new SSDB(this.host, this.port, this.timeout);
		// SSDB.connect();
		// if (null != this.password) {
		// SSDB.auth(this.password);
		// }
		// if( database != 0 ) {
		// SSDB.select(database);
		// }

	}

	@Override
	public void activateObject(SSDB obj) throws Exception {
		final SSDB ssdb = (SSDB) obj;
		ssdb.ping();
		// if (SSDB.getDB() != database) {
		// SSDB.select(database);
		// }
	}

	public void destroyObject(final SSDB obj) throws Exception {
		final SSDB ssdb = (SSDB) obj;
		ssdb.close();
	}

	public boolean validateObject(final SSDB obj) {
		final SSDB ssdb = (SSDB) obj;
		try {
			// //没有实现ping指令，暂时拿这个充当
			// return ssdb.get("ping").equals("pong".getBytes());
			ssdb.ping();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}