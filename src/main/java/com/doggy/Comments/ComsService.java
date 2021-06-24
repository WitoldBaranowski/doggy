package com.doggy.Comments;

import com.doggy.DatabaseCon.Response;
import com.doggy.DatabaseCon.User;
import com.doggy.DatabaseCon.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComsService {
    private final ComRepository comRepository;
    @Autowired
    public ComsService(ComRepository comRepository) {
        this.comRepository = comRepository;
    }

    public ComsResponse addNewComment(Comments comments) throws IOException {
            if(comments.getUsername()!=null)
            {
                GetPicture getPicture = new GetPicture();
                comments.setDoggolink(getPicture.returnPics());
                comRepository.save(comments);
            }
            return new ComsResponse(comRepository.findAll());
    }
    public ComsResponse delNewComment(Comments comments) {
        List<Comments> data = new ArrayList<Comments>();
        data = comRepository.findAll();
        if(data.get(data.size() - 1).getUsername().equals(comments.getUsername())){
            comRepository.deleteById(data.get(data.size()-1).getId());
        }
        return new ComsResponse(comRepository.findAll());
    }

}
