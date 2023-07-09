package com.example.netflixzuuluser.messagequeue;

import com.example.netflixzuuluser.common.commonUtilities;
import com.example.netflixzuuluser.entity.BookerWithFolder;
import com.example.netflixzuuluser.entity.UserEntity;
import com.example.netflixzuuluser.infra.BookerWithFolderRepository;
import com.example.netflixzuuluser.infra.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaConsumer {

    private UserRepository userRepository;
    private BookerWithFolderRepository bookerWithFolderRepository;

    @KafkaListener(topics = "msa_user_topic")
    public void updateUser(String userMessage) {
        log.info("kafka user message" + userMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(userMessage, new TypeReference<Map<Object, Object>>() {});

            if (!map.containsKey("userId"))
                throw new IOException("userId is null");

            BookerWithFolder bookerWithFolder = new BookerWithFolder();
            bookerWithFolder.setBooker(Integer.parseInt(map.get("bookerIndex").toString()));
            bookerWithFolder.setFolder(Integer.parseInt(map.get("folderIndex").toString()));
            bookerWithFolder.setRegisterDatetime(commonUtilities.convertLocalDateNowTime());
            bookerWithFolderRepository.save(bookerWithFolder);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
