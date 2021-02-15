package ye.golovnya.streamr.services;

import ye.golovnya.streamr.dtos.UserCreateDto;

public interface UserRegistrationService {

    void registerUser(UserCreateDto userCreateDto);
}
