package pl_tecna_data_service.model.user.mapper;

import org.mapstruct.Mapper;
import pl_tecna_data_service.dao.user.model.User;

@Mapper
public interface UserMapper {
    <U> U mapToDto(User user);
}
