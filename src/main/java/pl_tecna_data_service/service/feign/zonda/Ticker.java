package pl_tecna_data_service.service.feign.zonda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticker {
    String code;
    int amountPrecision;
    int pricePrecision;
    int ratePrecision;
    First first;
    Second second;
    long time;
    BigDecimal highestBid;
    BigDecimal lowestAsk;
    BigDecimal rate;
    BigDecimal previousRate;
}