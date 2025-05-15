package com.anthonycorp.reservapp.user.infrastructure.adapters.output.persistence;

import com.anthonycorp.reservapp.user.application.ports.output.UserPersistencePort;
import com.anthonycorp.reservapp.user.domain.model.User;
import com.anthonycorp.reservapp.user.infrastructure.adapters.output.persistence.mapper.UserPersistenceMapper;
import com.anthonycorp.reservapp.user.infrastructure.adapters.output.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository repository;
    private final UserPersistenceMapper mapper;

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toUser);
    }

    @Override
    public List<User> findAll() {
        return mapper.toUserList(repository.findAll());
    }

    @Override
    public User save(User user) {
        return mapper.toUser(repository.save(mapper.toUserEntity(user)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
