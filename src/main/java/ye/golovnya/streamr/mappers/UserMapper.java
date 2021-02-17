package ye.golovnya.streamr.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ye.golovnya.streamr.dtos.UserCreateDto;
import ye.golovnya.streamr.dtos.UserDto;
import ye.golovnya.streamr.entities.Show;
import ye.golovnya.streamr.entities.User;

import java.util.stream.Collectors;

@Mapper(componentModel= "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User userCreateDtoToModel(UserCreateDto userCreateDto);

    default UserDto modelToDto(User user) {
        return new UserDto(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getShows().stream().map(Show::getId).collect(Collectors.toList())
        );
    }
}
