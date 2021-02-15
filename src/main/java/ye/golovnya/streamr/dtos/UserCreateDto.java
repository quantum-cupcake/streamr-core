package ye.golovnya.streamr.dtos;

import lombok.Value;

@Value
public class UserCreateDto {

    String firstName;
    String lastName;
    String email;
    String password;
}
