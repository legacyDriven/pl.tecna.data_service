package pl_tecna_data_service.infrastructure;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);
    private final GroovyScriptRepository scriptRepository;
    private final Faker faker;

    public SampleDataLoader(GroovyScriptRepository scriptRepository, Faker faker) {
        this.scriptRepository = scriptRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) {
        logger.info("Loading sample data..");
        List<GroovyScript> groovyScripts = IntStream.rangeClosed(1, 100)
                        .mapToObj(x -> GroovyScript.builder()
                                .name(faker.name().username())
                                .description(faker.yoda().quote())
                                .groovySourceCode(faker.internet().emailAddress())
                                .build()
                        ).collect(Collectors.toList());
        scriptRepository.saveAll(groovyScripts);
    }
}
