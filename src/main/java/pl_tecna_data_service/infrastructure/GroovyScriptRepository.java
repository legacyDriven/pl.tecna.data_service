package pl_tecna_data_service.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface GroovyScriptRepository extends JpaRepository<GroovyScript, Long> {

    Optional<GroovyScript> findByName(String name);

    boolean deleteByName(String name);

    GroovyScript findGroovyScriptByName(String name);

}
