package pl_tecna_data_service.service;

import lombok.*;
import pl_tecna_data_service.infrastructure.GroovyScript;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class GroovyDto {

    @NotNull
    @Size(min=3, max = 100, message = "Script name cannot be null, accepted size is 3-100." )
    private String scriptName;
    @Size(max=500, message = "Max accepted description size is 500 characters.")
    private String description;
    @Size(max=3000, message = "Application accepts Groovy scripts with length up to 3000 characters.")
    private String groovySourceCode;

    public static GroovyDto fromEntity(GroovyScript script){
        return GroovyDto.builder()
                .scriptName(script.getName())
                .description(script.getDescription())
                .groovySourceCode(script.getGroovySourceCode())
                .build();
    }
}

