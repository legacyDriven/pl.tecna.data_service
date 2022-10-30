package pl_tecna_data_service.service;

import org.springframework.stereotype.Service;
import pl_tecna_data_service.infrastructure.GroovyScript;
import pl_tecna_data_service.infrastructure.GroovyScriptRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service

public class GroovyScriptService implements IGroovyScriptService {

    private final GroovyScriptRepository groovyScriptRepository;

//    public GroovyDto findByName(String name){
//            return groovyScriptRepository.findByName(name).orElseThrow(NoSuchElementException::new);
//    }

    public GroovyScriptService(GroovyScriptRepository groovyScriptRepository) {
        this.groovyScriptRepository = groovyScriptRepository;
    }

    public boolean containsScript(String scriptName){
        return groovyScriptRepository.findByName(scriptName).isPresent();
    }

    void persistGroovyScript(GroovyScript script){
        if(!containsScript(script.getName()))
            groovyScriptRepository.save(script);
    }


    @Override
    public boolean deleteByName(String name) {
        return groovyScriptRepository.deleteByName(name);
    }

    @Override
    public boolean saveScript(GroovyDto groovyDto) {
        if(groovyScriptRepository.findByName(groovyDto.getScriptName()).isPresent())
            return false;
        GroovyScript script = GroovyScript.builder()
                .name(groovyDto.getScriptName())
                .description(groovyDto.getDescription())
                .groovySourceCode(groovyDto.getGroovySourceCode()).build();

        groovyScriptRepository.save(script);
        return true;
    }
}
