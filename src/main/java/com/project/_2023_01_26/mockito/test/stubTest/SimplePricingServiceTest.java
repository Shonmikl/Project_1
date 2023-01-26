package com.project._2023_01_26.mockito.test.stubTest;

import com.project._2023_01_26.mockito.code.stub.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;

public class SimplePricingServiceTest {

    @Test
    public void testGetHighestPriceTest() {
        Price price1 = new Price(11);
        Price price2 = new Price(111);
        Price price3 = new Price(1111);

        Collection<Trade> trades = new ArrayList<>();
        trades.add(new Trade(price1));
        trades.add(new Trade(price2));
        trades.add(new Trade(price3));

        PricingRepository pricingRepository = Mockito.mock(PricingRepository.class);
        Mockito.when(pricingRepository.getPriceForTrade(Mockito.any(Trade.class)))
                .thenReturn(price1, price2, price3);

        PricingService service = new SimplePricingService(pricingRepository);
        Price highest = service.getHighestPricedTrade(trades);

        Assertions.assertEquals(price3.getAmount(), highest.getAmount());
    }
}