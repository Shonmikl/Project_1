package com.project._2023_01_26.mockito.code.stub;

public class PricingRepository {

	// [... other methods ...]

	public Price getPriceForTrade(Trade trade) {
		return trade.price;
	}
}