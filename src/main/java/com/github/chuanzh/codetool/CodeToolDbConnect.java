package com.github.chuanzh.codetool;
 
import com.github.chuanzh.orm.DbConfBean;
import com.github.chuanzh.orm.dbadapter.MysqlDb;
import com.github.chuanzh.util.ConfigRead;

class CodeToolDbConnect extends MysqlDb {

	private static CodeToolDbConnect connect = null;
	private DbConfBean masterBean = null;
	private CodeToolDbConnect (){
		
	}
	public static CodeToolDbConnect instance(){
		if(connect == null)
			connect = new CodeToolDbConnect();
		return connect;
	}

	@Override
	protected String getEncode() {
		return "utf-8";
	}
	@Override
	public boolean printSql() {
 		return ConfigRead.readBooleanValue("showSql");
	}
	@Override
	protected DbConfBean getMasterDb() {
		if(masterBean == null){
			masterBean = new DbConfBean();
			masterBean.setDbName(ConfigRead.readValue("test_db_name"));
			masterBean.setIpAndPort(ConfigRead.readValue("test_db_ipandport"));
			masterBean.setUserName(ConfigRead.readValue("test_db_username"));
			masterBean.setPassword(ConfigRead.readValue("test_db_password"));
		}
		return masterBean;
	}
	@Override
	protected DbConfBean[] getSlaveDbArray() {
		// TODO Auto-generated method stub
		return null;
	}
}