package com.example.thisisprice;

import java.util.List;

public class Exchange {

    List<ExchangeData> exchangeDatas;

    public List<ExchangeData> getExchangeDatas() {
        return exchangeDatas;
    }

    public double getUSD() {
        for (ExchangeData data : exchangeDatas) {
            if(data.getName().equals("USDKRW=X")) {
                return data.getRate();
            }
        }
        return 0;
    }
}
