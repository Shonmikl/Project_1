package com.project._2023_01_26.mockito.code.stub;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

//todo связать репозиторий с getHighestPricedTrade
public class SimplePricingService implements PricingService {

	PricingRepository repository;

	public SimplePricingService(PricingRepository pricingRepository) {
		this.repository = pricingRepository;
	}

	@Override
	public Price getHighestPricedTrade(Collection<Trade> trades) {
		Trade[] tradesArr = trades.toArray(new Trade[0]);
		Comparator<Trade> comp =
				(t1, t2) -> Double.compare(t1.price.getAmount(), t2.price.getAmount()); 
		Arrays.sort(tradesArr, comp);
		return tradesArr[tradesArr.length - 1].price;
	}
	// [... other overridden methods from PricingService interface...]
}