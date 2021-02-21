package com.nagarro.microservices.priceService.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nagarro.microservices.priceService.dao.PriceDao;
import com.nagarro.microservices.priceService.models.Price;

public class PriceDaoImpl implements PriceDao {

	@Override
	public double getPrice(String id) {
		List<Price> pricesList = storedPrices();
		Optional<Price> price = pricesList.stream().filter(p -> id.equals(p.getProfessionId())).findFirst();
		return price.get().getAmount();
	}

	protected List<Price> storedPrices() {
		List<Price> prices = new ArrayList<>();
		prices.add(new Price(500.0, "001"));
		prices.add(new Price(500.0, "002"));
		prices.add(new Price(1000.0, "002"));

		return prices;
	}

}
