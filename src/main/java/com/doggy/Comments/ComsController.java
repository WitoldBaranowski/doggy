package com.doggy.Comments;

import com.doggy.DatabaseCon.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "comment")


public class ComsController {
    private final ComsService comsService;
    @Autowired
    public ComsController(ComsService comsService){
        this.comsService = comsService;
    }

    @PostMapping()
    public ComsResponse resWithCom(@RequestBody Comments comments){
        return comsService.addNewComment(comments);
    }

}
