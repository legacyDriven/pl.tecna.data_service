package pl_tecna_data_service.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl_tecna_data_service.dao.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
