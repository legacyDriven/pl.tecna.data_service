package pl_tecna_data_service.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface GroovyScriptRepository extends JpaRepository<GroovyScript, Long> {

    Optional<GroovyScript> findByName(String name);

    @Transactional
    @Modifying
    @Query("delete from GROOVY_SCRIPT g where g.name = :name")
    int deleteByName(@Param("name") String name);

    boolean deleteByDescription(String description);

   // boolean deleteByName(String name);

    GroovyScript findGroovyScriptByName(String name);

}
