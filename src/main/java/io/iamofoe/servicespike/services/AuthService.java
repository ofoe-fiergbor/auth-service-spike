package io.iamofoe.servicespike.services;

import io.iamofoe.servicespike.domain.UserAuthDto;
import io.iamofoe.servicespike.domain.model.User;
import io.iamofoe.servicespike.domain.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public AuthService(UserRepository userRepository, RestTemplateBuilder restTemplateBuilder) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplateBuilder.build();
    }

    public User verifyToken(String idTokenString)  {
        UserAuthDto user = null;

        try {
            user = restTemplate.getForObject("https://oauth2.googleapis.com/tokeninfo?id_token="+ idTokenString, UserAuthDto.class);
        } catch (RestClientException e) {
            log.error("Exception getting user from Google API", e);
        }

        assert user != null;
        return new User(user.getGivenName(), user.getFamilyName(), user.getEmail(), user.getPicture());
    }

}
