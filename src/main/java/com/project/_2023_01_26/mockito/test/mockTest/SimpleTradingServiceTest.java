package com.project._2023_01_26.mockito.test.mockTest;

import com.project._2023_01_26.mockito.code.mock.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class SimpleTradingServiceTest {
    @Mock
    TradeRepository tradeRepository;

    @Mock
    Trade trade;

    @Mock
    AuditService auditService;

    @Test
    public void testAuditLogEntryMadeForNewTrade() {
        Mockito.when(tradeRepository.createTrade(trade)).thenReturn(anyLong());
        TradingService tradingService = new SimpleTradingService(tradeRepository, auditService);
        tradingService.createTrade(trade);

        Mockito.verify(auditService).logNewTrade(trade);
    }
}