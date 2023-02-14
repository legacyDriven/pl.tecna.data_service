package pl_tecna_data_service.model;

import lombok.Value;

@Value
public class GroovyScriptDTO {

    String name;

    String description;

    String groovySourceCode;

}
