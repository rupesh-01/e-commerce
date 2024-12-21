package com.example.demo.commons;

import com.example.demo.dtos.UserDto;
import com.example.demo.exceptions.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class AuthUtil {
    private RestTemplate restTemplate;

    public AuthUtil(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String token){
        try {
            UserDto userDto = restTemplate.getForObject(
                    "http://localhost:8080/auth/validate/" + token,
                    UserDto.class
            );
            log.info("User: {}", userDto);
            return userDto;
        } catch (Exception ex){
            log.error("Error:", ex);
            throw new UnauthorizedException("Unauthorized access");
        }
    }
}
