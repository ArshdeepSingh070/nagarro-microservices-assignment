package com.nagarro.microservices.priceService.services.impl;

import javax.annotation.Resource;

import com.nagarro.microservices.priceService.dao.PriceDao;
import com.nagarro.microservices.priceService.services.PriceService;

public class PriceServiceImpl implements PriceService {

	@Resource
	PriceDao priceDao;

	@Override
	public double getPrice(String id) {
		return priceDao.getPrice(id);
	}

}
