package com.hz.test;

import com.hz.test.abs.BaseDao;

public class FlowDao extends BaseDao {
	public void test2(){
		System.out.println("test2");
		disableSecondLevelCache();
	}
}
