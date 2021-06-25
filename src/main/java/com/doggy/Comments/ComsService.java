package com.doggy.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

import java.util.List;

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
        List<Comments> data;
        data = comRepository.findAll();
        if(data.get(data.size() - 1).getUsername().equals(comments.getUsername())){
            comRepository.deleteById(data.get(data.size()-1).getId());
        }
        return new ComsResponse(comRepository.findAll());
    }


    @Transactional
    public ComsResponse updateComs(Comments comments) {
        List<Comments> data;
        data = comRepository.findAll();
        if(data.get(data.size() - 1).getUsername().equals(comments.getUsername())){
            comRepository.findCommentByid(data.get(data.size()-1).getId()).get().setComment(comments.getComment());
        }
        return new ComsResponse(comRepository.findAll());
    }

}
