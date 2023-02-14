package pl_tecna_data_service.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl_tecna_data_service.service.ZondaService;
import pl_tecna_data_service.service.feign.zonda.Ticker;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/zonda")
@RequiredArgsConstructor
@Slf4j
public class ZondaController {

    private final ZondaService zondaService;

    @GetMapping("/ticker/{marketCode}")
    @ResponseStatus(OK)
    Ticker getTicker(@PathVariable("marketCode") String marketCode) {
            return zondaService.getTicker(marketCode);
    }
}

