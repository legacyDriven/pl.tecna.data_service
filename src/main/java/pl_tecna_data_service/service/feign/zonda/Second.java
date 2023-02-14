package pl_tecna_data_service.service.feign.zonda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.math.BigDecimal;

@JsonIgnoreProperties
@Value
public class Second {

    String currency;
    BigDecimal minOffer;
    int scale;

}
