package com.capitalized.service;

import com.capitalized.model.Account;
import com.capitalized.model.User;
import com.capitalized.model.request.AccountRequest;
import com.capitalized.model.request.UserRequest;
import com.capitalized.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequest userRequest){
        User user = new User(userRequest);
        userRepository.save(user);
        return user;
    }


    public Optional<User> getUser(UUID id) {
        return userRepository.findById(id);
    }

    public Optional<User> addAccount(String id, AccountRequest accountRequest) {
        Optional<User> optionalUser = getUser(UUID.fromString(id));
        if(optionalUser.isPresent()){
           User user = optionalUser.get();

         user.getAccounts().add(new Account(accountRequest));
           return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }
}
