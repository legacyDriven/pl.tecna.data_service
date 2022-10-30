package pl_tecna_data_service.service;

public interface IGroovyScriptService {

    boolean deleteByName(String name);

    boolean saveScript(GroovyDto groovyDto);

}
