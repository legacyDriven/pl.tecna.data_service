package pl_tecna_data_service.service;

public interface GroovyScriptService {

    void deleteByName(String name);

    void saveScript(GroovyDto groovyDto);

    void updateScript(GroovyDto groovyDto);

    GroovyDto getScriptByName(String scriptName);

    boolean containsScript(String name);

}
