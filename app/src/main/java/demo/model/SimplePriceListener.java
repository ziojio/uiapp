package demo.model;

import java.math.BigDecimal;

public interface SimplePriceListener {
    void onPriceChanged(BigDecimal price);
}