package ye.golovnya.streamr.dtos;

import lombok.Value;

import java.util.List;

@Value
public class UserDto {

    String firstName;
    String lastName;
    String email;
    List<Long> shows;
}
