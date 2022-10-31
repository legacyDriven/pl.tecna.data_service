package pl_tecna_data_service.service;

import org.springframework.data.domain.Page;
import pl_tecna_data_service.infrastructure.GroovyScriptPage;

public interface GroovyScriptService {

    void deleteByName(String name);

    void saveScript(GroovyDto groovyDto);

    void updateScript(GroovyDto groovyDto);

    GroovyDto getScriptByName(String scriptName);

    boolean containsScript(String name);

    Page<GroovyDto> getGroovyScripts(GroovyScriptPage page);

}
