package ye.golovnya.streamr.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ye.golovnya.streamr.dtos.UserCreateDto;
import ye.golovnya.streamr.entities.User;

@Mapper(componentModel= "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User userCreateDtoToModel(UserCreateDto userCreateDto);
    UserCreateDto modelToDto(User user);
}
