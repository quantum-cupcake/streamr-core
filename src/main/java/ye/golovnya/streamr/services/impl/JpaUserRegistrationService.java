package ye.golovnya.streamr.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ye.golovnya.streamr.dtos.UserCreateDto;
import ye.golovnya.streamr.mappers.UserMapper;
import ye.golovnya.streamr.repositories.UserRepository;
import ye.golovnya.streamr.services.UserRegistrationService;

@Service
public class JpaUserRegistrationService implements UserRegistrationService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public JpaUserRegistrationService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void registerUser(UserCreateDto userCreateDto) {
        var user = userMapper.userCreateDtoToModel(userCreateDto);
        user.setPasswordHash(passwordEncoder.encode(userCreateDto.getPassword()));
        userRepository.saveAndFlush(user);
    }
}
