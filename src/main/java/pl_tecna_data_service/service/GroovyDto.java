package pl_tecna_data_service.service;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class GroovyDto {

    private String scriptName;
    private String description;
    private String groovySourceCode;

}

