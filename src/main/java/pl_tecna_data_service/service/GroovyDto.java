package pl_tecna_data_service.service;

import lombok.*;
import pl_tecna_data_service.dao.groovy_script.model.GroovyScript;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class GroovyDto {


    private String scriptName;

    private String description;

    private String groovySourceCode;

    public static GroovyDto fromEntity(GroovyScript script){
        return GroovyDto.builder()
                .scriptName(script.getName())
                .description(script.getDescription())
                .groovySourceCode(script.getGroovySourceCode())
                .build();
    }
}

