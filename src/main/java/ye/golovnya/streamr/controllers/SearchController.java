package ye.golovnya.streamr.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ye.golovnya.streamr.controllers.urls.SearchUrlConstants;
import ye.golovnya.streamr.dtos.ShowSearchTermDto;
import ye.golovnya.streamr.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping(SearchUrlConstants.ROOT)
public class SearchController {

    private final UserService userService;

    public SearchController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> searchShow(Principal principal, @RequestBody ShowSearchTermDto showSearchTermDto) {
        userService.addShow(principal.getName(), showSearchTermDto);

        return ResponseEntity.ok().build();
    }
}
