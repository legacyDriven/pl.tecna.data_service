package pl_tecna_data_service.service;

import org.springframework.stereotype.Component;

@Component
public class GroovyExecutor {

    public String execute(String script){
        return "Script executed" + script;
    }
}
