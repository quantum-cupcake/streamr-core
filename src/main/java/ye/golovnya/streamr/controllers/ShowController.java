package ye.golovnya.streamr.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ye.golovnya.streamr.controllers.urls.ShowUrlConstants;
import ye.golovnya.streamr.dtos.TopServiceDto;
import ye.golovnya.streamr.services.ShowService;
import ye.golovnya.streamr.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping(ShowUrlConstants.ROOT)
public class ShowController {

    private final ShowService showService;
    private final UserService userService;

    public ShowController(ShowService showService, UserService userService) {
        this.showService = showService;
        this.userService = userService;
    }

    @GetMapping(path =  ShowUrlConstants.TOP_SERVICES)
    public ResponseEntity<TopServiceDto> getCurrentUsersShows(Principal principal) {
        var showIds = userService.getUserInformation(principal.getName()).getShows();

        return ResponseEntity.ok(showService.getTopServiceForUser(showIds));
    }

}
