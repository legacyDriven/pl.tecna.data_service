package pl_tecna_data_service.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl_tecna_data_service.dao.groovy_script.model.GroovyScript;
import pl_tecna_data_service.dao.groovy_script.GroovyScriptPage;
import pl_tecna_data_service.dao.groovy_script.GroovyScriptRepository;
import pl_tecna_data_service.model.GroovyScriptDTO;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class GroovyScriptServiceImpl implements GroovyScriptService {

    private final GroovyScriptRepository groovyScriptRepository;

    private final ModelMapper modelMapper;

    @Override
    public boolean containsScript(String scriptName){
        return groovyScriptRepository.findByName(scriptName).isPresent();
    }

    @Override
    public Page<GroovyDto> getGroovyScripts(GroovyScriptPage page) {
        Sort sort = Sort.by(page.getSortDirection(), page.getSortBy());
        Pageable pageable = PageRequest.of(page.getPageNumber(), page.getPageSize(), sort);
        return groovyScriptRepository.findAll(pageable).map(GroovyDto::fromEntity);
    }

    @Override
    public GroovyScriptDTO findById(Long id) {
        return null;
    }

    @Override
    public int deleteByName(String name) {
        return groovyScriptRepository.deleteByName(name);
    }

    @Override
    public void saveScript(GroovyDto groovyDto) {
        if(groovyScriptRepository.findByName(groovyDto.getScriptName()).isPresent()) return;

        groovyScriptRepository.save(modelMapper.map(groovyDto, GroovyScript.class));
    }

    @Override
    public void updateScript(GroovyDto groovyDto) {
        if(this.containsScript(groovyDto.getScriptName())){
            GroovyScript toUpdate = groovyScriptRepository.findByName(groovyDto.getScriptName()).orElseThrow(NoSuchElementException::new);
            toUpdate.setDescription(groovyDto.getDescription());
            toUpdate.setGroovySourceCode(groovyDto.getGroovySourceCode());
            groovyScriptRepository.save(toUpdate);
        } else {
            this.saveScript(groovyDto);
        }
    }
}
