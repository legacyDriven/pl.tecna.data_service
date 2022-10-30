package pl_tecna_data_service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl_tecna_data_service.infrastructure.GroovyScriptRepository;

@Service
@AllArgsConstructor
public class GroovyRunnerService {

     private final GroovyScriptRepository scriptRepository;

     private final GroovyExecutor executor;

     public String runScriptByName(String scriptName){
          String scriptToRun;

          if(scriptRepository.findByName(scriptName).isPresent()) {
               scriptToRun = scriptRepository.findByName(scriptName).get().getGroovySourceCode();
               return executor.execute(scriptToRun);
          } else {
               return String.format("No valid scripts scripts in %s entry", scriptName);
          }
     }
}
