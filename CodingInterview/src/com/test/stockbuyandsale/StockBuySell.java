package com.test.stockbuyandsale;

import java.util.ArrayList;
import java.util.List;

class BuyAndSaleDay {
    int buyDay;
    int saleDay;
}

public class StockBuySell {

    public List<BuyAndSaleDay> getBestProfitDays(int[] priceList) {

        assert priceList.length > 1 : "Invalid price array";

        List<BuyAndSaleDay> days = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < priceList.length - 1; i++) {
            if (priceList[i] > priceList[i + 1]) {
                count++;
                continue;
            }
        }
        if (count == priceList.length-1) {
            return null;
        }
        int i = 0;
        while(i< priceList.length-1){
            BuyAndSaleDay buyAndSaleDay = new BuyAndSaleDay();
            buyAndSaleDay.buyDay = i++;
            while(i < priceList.length){
                if(priceList[i] >= priceList[i-1]){
                    i++;
                }else{
                    break;
                }
            }
            buyAndSaleDay.saleDay = i-1;
            days.add(buyAndSaleDay);
        }
        return days;

    }

    public static void main(String[] args) {
        int[] priceList = {100, 180, 260, 310, 40, 535, 695};
        List<BuyAndSaleDay> days = new StockBuySell().getBestProfitDays(priceList);
        for(BuyAndSaleDay day: days){
            System.out.println("Buy On:" + day.buyDay + "   Sale On: "+day.saleDay);
        }
        
    }
}
