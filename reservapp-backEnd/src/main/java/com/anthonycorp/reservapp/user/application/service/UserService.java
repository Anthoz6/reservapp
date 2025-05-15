package com.anthonycorp.reservapp.user.application.service;

import com.anthonycorp.reservapp.user.application.ports.input.UserServicePort;
import com.anthonycorp.reservapp.user.application.ports.output.UserPersistencePort;
import com.anthonycorp.reservapp.user.domain.exception.UserNotFoundException;
import com.anthonycorp.reservapp.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserServicePort {

    private final UserPersistencePort persistencePort;

    @Override
    public User findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public User save(User user) {
        return persistencePort.save(user);
    }

    @Override
    public User update(Long id, User user) {
        return persistencePort.findById(id)
                .map(savedUser -> {
                    savedUser.setName(user.getName());
                    savedUser.setEmail(user.getEmail());
                    savedUser.setPassword(user.getPassword());
                    savedUser.setRole(user.getRole());
                    return persistencePort.save(savedUser);
                })
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (persistencePort.findById(id).isPresent()) {
            throw new UserNotFoundException();
        }
        persistencePort.deleteById(id);
    }
}
