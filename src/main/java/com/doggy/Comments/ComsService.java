package com.doggy.Comments;

import com.doggy.DatabaseCon.Response;
import com.doggy.DatabaseCon.User;
import com.doggy.DatabaseCon.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComsService {
    private final ComRepository comRepository;
    @Autowired
    public ComsService(ComRepository comRepository) {
        this.comRepository = comRepository;
    }

    public ComsResponse addNewComment(Comments comments) {

            comRepository.save(comments);
            return new ComsResponse(comRepository.findAll());
    }

}
