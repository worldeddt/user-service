package com.example.netflixzuuluser.service;


import com.example.netflixzuuluser.dto.UserDto;
import com.example.netflixzuuluser.entity.FolderEntity;
import com.example.netflixzuuluser.entity.GroupEntity;
import com.example.netflixzuuluser.entity.UserEntity;
import com.example.netflixzuuluser.infra.FolderRepository;
import com.example.netflixzuuluser.infra.GroupRepository;
import com.example.netflixzuuluser.infra.UserRepository;
import jakarta.transaction.Transactional;
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
    private GroupRepository groupRepository;
    private FolderRepository folderRepository;

    public UserDto loadUserByUsername(String username) {
        UserEntity userEntity = userRepository.findUserEntityByName(username);

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return mapper.map(userEntity, UserDto.class);
    }



    @Transactional(rollbackOn=Exception.class)
    public UserDto createUser(UserDto userDto) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
        userEntity.setEncryptedPwd(userDto.getEncryptedPwd());

        GroupEntity group = new GroupEntity();
        group.setUser(userEntity);

        FolderEntity folder = new FolderEntity();
        folder.setName("our memory");
        folder.setGroup(group);

        userRepository.save(userEntity);
        groupRepository.save(group);
        folderRepository.save(folder);

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
