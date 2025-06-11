package com.anthonycorp.reservapp.User.application.createuser;

import com.anthonycorp.reservapp.User.domain.request.CreateUserDto;
import com.anthonycorp.reservapp.User.domain.response.UserResponseDto;
import com.anthonycorp.reservapp.User.infrastructure.exception.EmailAlreadyInUse;
import com.anthonycorp.reservapp.User.infrastructure.exception.RoleNotFound;
import com.anthonycorp.reservapp.User.infrastructure.mapper.UserMapper;
import com.anthonycorp.reservapp.User.infrastructure.model.Role;
import com.anthonycorp.reservapp.User.infrastructure.model.User;
import com.anthonycorp.reservapp.User.infrastructure.repository.RoleRepository;
import com.anthonycorp.reservapp.User.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

<<<<<<< HEAD
=======

>>>>>>> 8335205 (Module User Updated)
    @Override
    public UserResponseDto execute(CreateUserDto createUserDto) {
        userRepository.findUserByEmail(createUserDto.getEmail())
                .ifPresent(user -> {throw new EmailAlreadyInUse("Email already in user: " + user.getEmail());});
        User user = userMapper.toEntity(createUserDto);
        Role role = roleRepository.findById(createUserDto.getRolId())
                .orElseThrow(() -> new RoleNotFound("Rol with id: "+ createUserDto.getRolId() + " Not found"));
<<<<<<< HEAD
        user.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
=======
        user.setPassword(passwordEncoder.encode(user.getPassword()));
>>>>>>> 8335205 (Module User Updated)
        user.setRole(role);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }
}
