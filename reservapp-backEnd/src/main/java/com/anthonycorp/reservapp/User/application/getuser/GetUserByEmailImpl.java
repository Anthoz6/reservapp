package com.anthonycorp.reservapp.User.application.getuser;

import com.anthonycorp.reservapp.User.infrastructure.model.UserEntity;
import com.anthonycorp.reservapp.User.infrastructure.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserByEmailImpl implements GetUserByEmail {

    private final UserRepository userRepository;

    @Override
    public UserEntity execute(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("UserEntity with email " + email+ " found"));

    }
}
