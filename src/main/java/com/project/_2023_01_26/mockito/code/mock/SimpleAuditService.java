package com.project._2023_01_26.mockito.code.mock;

public class SimpleAuditService implements AuditService {
	@Override
	public void logNewTrade(Trade trade) {
		throw new RuntimeException
				("implement logNewTrade() in SimpleAuditService");
	}
}