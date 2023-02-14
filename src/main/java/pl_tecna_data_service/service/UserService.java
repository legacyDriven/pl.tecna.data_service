package pl_tecna_data_service.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl_tecna_data_service.dao.user.UserRepository;
import pl_tecna_data_service.model.user.UserDTO;
import pl_tecna_data_service.model.user.mapper.UserMapper;

@Slf4j
@Service
@RequiredArgsConstructor(access = AccessLevel.MODULE)
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public Page<UserDTO> getAll(Pageable pageable) {
        log.info("Get all users");
        return userRepository.findAll(pageable)
                .map(userMapper::mapToDto);
    }
}
