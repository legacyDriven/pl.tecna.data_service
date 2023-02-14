package pl_tecna_data_service.dao.groovy_script.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@Entity(name = "GROOVY_SCRIPT")
public class GroovyScript {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = true)
    private String description;

    @Column(name="GROOVY_SOURCE_CODE", length = 3000, nullable = true)
    private String groovySourceCode;

}
