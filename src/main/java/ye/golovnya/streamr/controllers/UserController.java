package ye.golovnya.streamr.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ye.golovnya.streamr.controllers.urls.UserUrlConstants;
import ye.golovnya.streamr.dtos.UserCreateDto;
import ye.golovnya.streamr.dtos.UserDto;
import ye.golovnya.streamr.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping(UserUrlConstants.ROOT)
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path =  UserUrlConstants.REGISTER)
    public String register(Model model) {
        model.addAttribute("userCreateDto", new UserCreateDto());
        return "/user/register";
    }

    @PostMapping(path =  UserUrlConstants.REGISTER)
    public ResponseEntity<Void> register(@RequestBody UserCreateDto userCreateDto) {
        userService.registerUser(userCreateDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping(path =  UserUrlConstants.CURRENT)
    public ResponseEntity<UserDto> getCurrentDetails(Principal principal) {
        return ResponseEntity.ok(userService.getUserInformation(principal.getName()));
    }
}
