package ye.golovnya.streamr.services.impl;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ye.golovnya.streamr.dtos.ShowDetails;
import ye.golovnya.streamr.dtos.ShowSearchTermDto;
import ye.golovnya.streamr.dtos.UserCreateDto;
import ye.golovnya.streamr.dtos.UserDto;
import ye.golovnya.streamr.entities.User;
import ye.golovnya.streamr.mappers.UserMapper;
import ye.golovnya.streamr.repositories.UserRepository;
import ye.golovnya.streamr.services.SearchService;
import ye.golovnya.streamr.services.ShowService;
import ye.golovnya.streamr.services.UserService;

import java.util.List;

@Service
public class JpaUserService implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final SearchService searchService;
    private final ShowService showService;

    public JpaUserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, SearchService searchService, ShowService showService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.searchService = searchService;
        this.showService = showService;
    }

    @Override
    @Transactional
    public void registerUser(UserCreateDto userCreateDto) {
        var user = userMapper.userCreateDtoToModel(userCreateDto);
        user.setPasswordHash(passwordEncoder.encode(userCreateDto.getPassword()));
        userRepository.saveAndFlush(user);
    }

    @Override
    public UserDto getUserInformation(String email) {
        var user = getUserOrThrow(email);

        return userMapper.modelToDto(user);
    }

    @Override
    @Transactional
    public void addShow(String email, ShowSearchTermDto showSearchTermDto) {
        var user = getUserOrThrow(email);
        var searchResponseDto = searchService.search(showSearchTermDto);
        var show = showService.getOrCreateShow(searchResponseDto.getSearchResults().get(0));
        if (user.getShows().contains(show)) {
            return;
        }
        user.getShows().add(show);
        show.getUsers().add(user);
        showService.updateShow(show);
        userRepository.saveAndFlush(user);
    }

    private User getUserOrThrow(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(email)
        );
    }
}
