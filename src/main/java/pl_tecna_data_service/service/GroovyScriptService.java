package pl_tecna_data_service.service;

import org.springframework.data.domain.Page;
import pl_tecna_data_service.dao.groovy_script.GroovyScriptPage;
import pl_tecna_data_service.model.GroovyScriptDTO;

public interface GroovyScriptService {

    int deleteByName(String name);

    void saveScript(GroovyDto groovyDto);

    void updateScript(GroovyDto groovyDto);

    boolean containsScript(String name);

    Page<GroovyDto> getGroovyScripts(GroovyScriptPage page);

    GroovyScriptDTO findById(Long id);
}
