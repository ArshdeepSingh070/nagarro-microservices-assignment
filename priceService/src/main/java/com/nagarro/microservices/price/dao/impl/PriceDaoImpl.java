package com.nagarro.microservices.price.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nagarro.microservice.price.model.Price;

@Component
public class PriceDaoImpl implements com.nagarro.microservices.price.dao.PriceDao {

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
		prices.add(new Price(1000.0, "003"));

		return prices;
	}
}
