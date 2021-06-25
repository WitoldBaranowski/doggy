package com.doggy.DatabaseCon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUser(String username, String password) {
        Optional<User> isUser=userRepository.findUserByEmail(username);
        String a = password;
        String b = isUser.get().getPassword();
        if(a.equals(b))
        {
           return isUser;
        }
        return userRepository.findUserByEmail("error");
    }

    public Response logUser(User user){
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        System.out.println(user.getEmail());
        if(userOptional.get().getEmail().equals(user.getEmail()) && userOptional.get().getPassword().equals(user.getPassword()))
        {
            return new Response(userOptional.get().getUsername());
        }
        else
        {
            return new Response();
        }
    }

    public Response addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent())
        {
            return new Response();
        }
        else
        {
            userRepository.save(user);
            return new Response(user.getUsername());
        }

    }

    public void deleteUser(String userUsername, String password) {
        Optional<User> isUser=userRepository.findUserByEmail(userUsername);
        if(!isUser.isPresent())
        {
            throw new IllegalStateException("user with that username does not exist");
        }
        String a = password;
        String b = isUser.get().getPassword();
        if(a.equals(b))
        {
            userRepository.deleteById(isUser.get().getId());
        }

    }



}
