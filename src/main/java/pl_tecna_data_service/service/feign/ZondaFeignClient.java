package pl_tecna_data_service.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl_tecna_data_service.service.feign.zonda.Ticker;

@FeignClient(name = "tickerClient", url = "https://api.zonda.exchange/rest/trading/ticker")
public interface ZondaFeignClient {

    @GetMapping("/{marketCode}")
    Ticker getTicker(@PathVariable("marketCode") String marketCode);

}
