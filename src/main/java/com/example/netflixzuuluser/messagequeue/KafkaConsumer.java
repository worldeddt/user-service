package com.example.netflixzuuluser.messagequeue;

import com.example.netflixzuuluser.entity.UserEntity;
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

    @KafkaListener(topics = "msa_user_topic")
    public void updateUser(String userMessage) {
        log.info("kafka user message" + userMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(userMessage, new TypeReference<Map<Object, Object>>() {});

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        UserEntity user = userRepository.findByUserId((String)map.get("productId"));

        if (user != null) {
            log.info("user find : "+user.getName());
        }
    }
}
