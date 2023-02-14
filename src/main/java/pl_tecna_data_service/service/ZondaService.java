package pl_tecna_data_service.service;

import org.springframework.stereotype.Service;
import pl_tecna_data_service.service.feign.ZondaFeignClient;
import pl_tecna_data_service.service.feign.zonda.Ticker;

@Service
public class ZondaService {

    private ZondaFeignClient zondaFeignClient;

    public Ticker getTicker(String marketCode) {
        return zondaFeignClient.getTicker(marketCode);
    }
}
