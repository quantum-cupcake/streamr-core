package ye.golovnya.streamr.dtos;

import lombok.Data;

@Data
public class UserCreateDto {

    String firstName;
    String lastName;
    String email;
    String password;
}
