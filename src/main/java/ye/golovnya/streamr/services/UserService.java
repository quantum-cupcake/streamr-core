package ye.golovnya.streamr.services;

import ye.golovnya.streamr.dtos.ShowDetails;
import ye.golovnya.streamr.dtos.ShowSearchTermDto;
import ye.golovnya.streamr.dtos.UserCreateDto;
import ye.golovnya.streamr.dtos.UserDto;

import java.util.List;

public interface UserService {

    void registerUser(UserCreateDto userCreateDto);

    void addShow(String email, ShowSearchTermDto showSearchTermDto);

    UserDto getUserInformation(String email);
}
