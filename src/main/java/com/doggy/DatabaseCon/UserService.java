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

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent())
        {
            throw new IllegalStateException("username taken");
        }
        userRepository.save(user);
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


    @Transactional
    public void updateUser(Long userId, String username, String password) {
        User user =userRepository.findById(userId).orElseThrow(()-> new IllegalStateException("student with that id does not exist"));
        if(username != null && username.length() > 0 &&!Objects.equals(user.getUsername(),username)){
            user.setUsername(username);
        }
        if(password != null && password.length() > 0 ){
            user.setPassword(password);
        }

    }
}
