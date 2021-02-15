package ye.golovnya.streamr.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ye.golovnya.streamr.controllers.urls.UserUrlConstants;
import ye.golovnya.streamr.dtos.UserCreateDto;
import ye.golovnya.streamr.services.UserRegistrationService;

import java.security.Principal;

@RestController
@RequestMapping(UserUrlConstants.ROOT)
public class UserController {

    private final UserRegistrationService userRegistrationService;


    public UserController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping(path =  UserUrlConstants.REGISTER)
    public ResponseEntity<Void> register(@RequestBody UserCreateDto userCreateDto) {
        userRegistrationService.registerUser(userCreateDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping(path =  UserUrlConstants.CURRENT)
    public ResponseEntity<String> getCurrentDetails(Principal principal) {

        return ResponseEntity.ok(principal.getName());
    }
}
