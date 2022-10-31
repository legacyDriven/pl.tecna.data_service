package pl_tecna_data_service.api;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl_tecna_data_service.infrastructure.GroovyScriptPage;
import pl_tecna_data_service.service.GroovyDto;
import pl_tecna_data_service.service.GroovyScriptService;

@RestController
@RequestMapping(value = "/groovy")
@AllArgsConstructor
public class DataServiceController {

    private final GroovyScriptService scriptService;

    @GetMapping("/{page}")
    @ResponseBody
    ResponseEntity<Page<GroovyDto>> getScripts(GroovyScriptPage page){
        return new ResponseEntity<>(scriptService.getGroovyScripts(page), HttpStatus.OK);
    }

    @PostMapping("/{groovyDto}")
    @ResponseBody
    public ResponseEntity<String> saveGroovyScript(@RequestBody GroovyDto groovyDto){
        if(scriptService.containsScript(groovyDto.getScriptName())){
            return new ResponseEntity<>("Script with name " + groovyDto.getScriptName() + " is already persisted", HttpStatus.OK);
        }
        scriptService.saveScript(groovyDto);
        return new ResponseEntity<>("Script persisted: " + groovyDto.getScriptName(), HttpStatus.OK);
    }

    @PutMapping("/{groovydto}")
    @ResponseBody
    public ResponseEntity<String> put(@RequestBody GroovyDto groovyDto){
        scriptService.updateScript(groovyDto);
        return new ResponseEntity<>(String.format("Groovy script: %s has been updated", groovyDto.getScriptName()), HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    @ResponseBody
    public ResponseEntity<String> deleteByName(@PathVariable String name){
        if(scriptService.getScriptByName(name)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        scriptService.deleteByName(name);
        return new ResponseEntity<>(String.format("Groovy script: %s has beed deleted.", name), HttpStatus.OK);
    }
}

