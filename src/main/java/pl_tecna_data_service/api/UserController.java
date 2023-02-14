package pl_tecna_data_service.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl_tecna_data_service.model.PageResponse;
import pl_tecna_data_service.model.user.UserDTO;
import pl_tecna_data_service.service.UserService;

import static org.springframework.http.HttpStatus.OK;

@Validated
@Tag(name = "User API")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class UserController {

    private final UserService userService;

    @Operation(summary = "Retrieves all users")
    @GetMapping
    @ResponseStatus(OK)
    PageResponse<UserDTO> getAll(Pageable pageable){
        return new PageResponse(userService.getAll(pageable));
    }
}
