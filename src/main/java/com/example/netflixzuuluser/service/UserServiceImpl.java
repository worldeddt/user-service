package com.example.netflixzuuluser.service;


import com.example.netflixzuuluser.dto.UserDto;
import com.example.netflixzuuluser.entity.UserEntity;
import com.example.netflixzuuluser.infra.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl {
    private UserRepository userRepository;

    public UserDto loadUserByUsername(String username) {
        UserEntity userEntity = userRepository.findUserEntityByName(username);

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return mapper.map(userEntity, UserDto.class);
    }

    
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
        userEntity.setEncryptedPwd(userDto.getPwd());

        userRepository.save(userEntity);

        return mapper.map(userEntity, UserDto.class);
    }

    
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findUserEntityByUserId(userId);

        return new ModelMapper().map(userEntity, UserDto.class);
    }

    
    public Iterable<UserEntity> getUserByAll() {
        return userRepository.findAll();
    }

    
    public UserDto getUserDetailsByEmail(String email) {
        UserEntity userEntity = userRepository.findUserEntityByEmail(email);

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return mapper.map(userEntity, UserDto.class);
    }
}
