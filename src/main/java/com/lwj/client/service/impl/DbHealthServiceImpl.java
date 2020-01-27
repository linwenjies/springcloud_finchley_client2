package com.lwj.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwj.client.dao.DbDao;
import com.lwj.client.service.DbHealthService;

@Service
public class DbHealthServiceImpl implements DbHealthService {

	@Autowired
	private DbDao dbDao;
	
	@Override
	public boolean dbCheck() {
		return dbDao.check();
	}

}
