package com.example.netflixzuuluser.service;


import com.example.netflixzuuluser.dto.UserDto;
import com.example.netflixzuuluser.entity.UserEntity;
import com.example.netflixzuuluser.infra.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final Environment env;
    private final RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(username);

        if (userEntity == null)
            throw new UsernameNotFoundException(username + ": not found");

        return new User(userEntity.getEmail(), userEntity.getEncryptedPwd(),
                true, true, true, true,
                new ArrayList<>());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
        userEntity.setEncryptedPwd(passwordEncoder.encode(userDto.getPwd()));

        userRepository.save(userEntity);

        return mapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);

        if (userEntity == null)
            throw new UsernameNotFoundException("User not found");

        UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);

//        List<ResponseBooker> bookers = new ArrayList<>();
        /* Using as rest template */
//        String bookerUrl = String.format(env.getProperty("booker_service.url"), userId);
//        ResponseEntity<List<ResponseBooker>> bookerListResponse =
//                restTemplate.exchange(bookerUrl, HttpMethod.GET, null,
//                                            new ParameterizedTypeReference<List<ResponseBooker>>() {
//                });
//        List<ResponseBooker> bookersList = bookerListResponse.getBody();

        /* Using a feign client */
        /* Feign exception handling */
//        List<ResponseBooker> bookersList = null;
//        try {
//            bookersList = bookerServiceClient.getBookers(userId);
//        } catch (FeignException ex) {
//            log.error(ex.getMessage());
//        }

        /* ErrorDecoder */
//        List<ResponseBooker> bookersList = bookerServiceClient.getBookers(userId);
//        log.info("Before call bookers microservice");
//        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
//        List<ResponseBooker> bookersList = circuitBreaker.run(() -> bookerServiceClient.getBookers(userId),
//                throwable -> new ArrayList<>());
//        log.info("After called bookers microservice");

//        userDto.setBookers(bookersList);

        return userDto;
    }

    @Override
    public Iterable<UserEntity> getUserByAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDto getUserDetailsByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null)
            throw new UsernameNotFoundException(email);

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return mapper.map(userEntity, UserDto.class);
    }
}
