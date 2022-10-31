package pl_tecna_data_service.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl_tecna_data_service.infrastructure.GroovyScript;
import pl_tecna_data_service.infrastructure.GroovyScriptRepository;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class GroovyScriptServiceImpl implements GroovyScriptService {

    private final GroovyScriptRepository groovyScriptRepository;

    private final ModelMapper modelMapper;

    @Override
    public GroovyDto getScriptByName(String name){
          return modelMapper.map(groovyScriptRepository.findByName(name).orElseThrow(NoSuchElementException::new), GroovyDto.class);
    }

    public boolean containsScript(String scriptName){
        return groovyScriptRepository.findByName(scriptName).isPresent();
    }

    @Override
    public void deleteByName(String name) {
        groovyScriptRepository.deleteByName(name);
    }

    @Override
    public void saveScript(GroovyDto groovyDto) {
        if(groovyScriptRepository.findByName(groovyDto.getScriptName()).isPresent()) return;

        groovyScriptRepository.save(modelMapper.map(groovyDto, GroovyScript.class));
    }

    @Override
    public void updateScript(GroovyDto groovyDto) {
        if(this.containsScript(groovyDto.getScriptName())){
            GroovyScript toUpdate = groovyScriptRepository.findByName(groovyDto.getScriptName()).get();
            toUpdate.setDescription(groovyDto.getDescription());
            toUpdate.setGroovySourceCode(groovyDto.getGroovySourceCode());
            groovyScriptRepository.save(toUpdate);
        }else{
            this.saveScript(groovyDto);
        }
    }


}