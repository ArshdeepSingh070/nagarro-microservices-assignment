package com.nagarro.microservices.price.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nagarro.microservices.price.dao.PriceDao;
import com.nagarro.microservices.price.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	@Resource
	PriceDao priceDao;

	@Override
	public double getPrice(String id) {
		return priceDao.getPrice(id);
	}
}
