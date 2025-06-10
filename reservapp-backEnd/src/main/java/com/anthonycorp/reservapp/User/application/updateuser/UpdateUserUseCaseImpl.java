package com.anthonycorp.reservapp.User.application.updateuser;

import com.anthonycorp.reservapp.User.domain.request.UpdateUserDto;
import com.anthonycorp.reservapp.User.domain.response.UserResponseDto;
import com.anthonycorp.reservapp.User.infrastructure.mapper.UserMapper;
import com.anthonycorp.reservapp.User.infrastructure.model.User;
import com.anthonycorp.reservapp.User.infrastructure.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto execute(Long userId, UpdateUserDto updateUserDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with id "+ userId + " not found"));

        Optional.ofNullable(updateUserDto.getName()).ifPresent(user::setName); // Update name
        return userMapper.toDto(userRepository.save(user));
    }
}
