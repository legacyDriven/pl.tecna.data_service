package pl_tecna_data_service.api;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl_tecna_data_service.model.GroovyScriptDTO;
import pl_tecna_data_service.dao.groovy_script.GroovyScriptPage;
import pl_tecna_data_service.service.GroovyDto;
import pl_tecna_data_service.service.GroovyScriptService;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/groovy")
@AllArgsConstructor
@Slf4j
public class GroovyScriptController {

    private final GroovyScriptService scriptService;

    @Operation(summary = "Get script by id")
    @GetMapping("/{id}")
    public GroovyScriptDTO getById(@PathVariable Long id){
        return scriptService.findById(id);
    }

    @GetMapping("/{page}")
    @ResponseBody
    ResponseEntity<Page<GroovyDto>> getScripts(GroovyScriptPage page){
        return new ResponseEntity<>(scriptService.getGroovyScripts(page), HttpStatus.OK);
    }

    @PostMapping(value = "/{groovyDto}", consumes = "application/json")
    public ResponseEntity<GroovyDto> saveGroovyScript(@RequestBody GroovyDto groovyDto){
        return ResponseEntity.ok(GroovyDto.builder().scriptName("qqqq").description("ffff").groovySourceCode("qqqqq").build());
//        if(scriptService.containsScript(groovyDto.getScriptName())){
//            return new ResponseEntity<>(groovyDto, HttpStatus.OK);
//        }
//        scriptService.saveScript(groovyDto);
//
//        return new ResponseEntity<>(groovyDto, HttpStatus.CREATED);
    }

//    @PostMapping(value = "/{groovyDto}", consumes = "application/json")
//    public ResponseEntity<String> saveGroovyScript(@RequestBody @Valid GroovyDto groovyDto, Errors errors){
//        if(errors.hasErrors())
//            return new ResponseEntity<>("Improper data format:" + errors, HttpStatus.BAD_REQUEST);
//
//        if(scriptService.containsScript(groovyDto.getScriptName())){
//            return new ResponseEntity<>("Script with name " + groovyDto.getScriptName() + " is already persisted", HttpStatus.OK);
//        }
//        scriptService.saveScript(groovyDto);
//        return new ResponseEntity<>("Script persisted: " + groovyDto.getScriptName(), HttpStatus.CREATED);
//    }

    @PutMapping("/{groovydto}")
    @ResponseBody
    public ResponseEntity<String> put(@RequestBody @Valid GroovyDto groovyDto){
        scriptService.updateScript(groovyDto);
        return new ResponseEntity<>(String.format("Groovy script: %s has been updated", groovyDto.getScriptName()), HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable("name") String name){
        if(!scriptService.containsScript(name))
            return ResponseEntity.notFound().build();
            //return new ResponseEntity<>(String.format("Database does not contain script with name \"%s\".", name), HttpStatus.OK);//instead of 404
        scriptService.deleteByName(name);
        return new ResponseEntity<>(String.format("Entry \"%s\" has been successfully deleted", name), HttpStatus.OK);
    }

    @GetMapping(
            value = "/notfound"
    )
    public ResponseEntity<Mono<String>> unathorized() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("X-Reason", "user-invalid")
                .body(Mono.just("unauthorized"));
    }

//    @GetMapping("/name/get/{name}")
//    public ResponseEntity<GroovyDto> getByName(@PathVariable String name){
//        return new ResponseEntity<>(scriptService.getScriptByName(name), HttpStatus.OK);
//        return ResponseEntity.status().header().body()
//    }
}

