package com.deutschland.springconceptreplay.service;

import static java.util.Optional.ofNullable;

import com.deutschland.springconceptreplay.Entity.User;
import com.deutschland.springconceptreplay.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return ofNullable(user).map(userRepository::save)
                               .orElseThrow(() -> {
                                   log.error("cannot create user " + user);
                                   return new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create "
                                           + "User!");
                               });

    }

    public void deleteUser(UUID id) throws Exception {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Something happened when deleting user with id= " + id);
        }
    }

    @Transactional
    public List<Optional<User>> modifyCertainUserAges(List<UUID> userIds) {
        List<User> usersToUpdate = userRepository.findAllById(userIds);
        return usersToUpdate.stream().map(this::IncrementAgeAndUpdate).collect(Collectors.toList());

    }

    private Optional<User> IncrementAgeAndUpdate(User user) {
        int newAge = user.getAge() + 1;
        userRepository.updateUserWithNewAge(newAge, user.getId());
        return userRepository.findById(user.getId());

    }

}
