package com.doggy.Comments;

import com.doggy.DatabaseCon.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public ComsResponse resWithCom(@RequestBody Comments comments) throws IOException {
        return comsService.addNewComment(comments);
    }
    @PostMapping(path = "del")
    public ComsResponse delOneCom(@RequestBody Comments comments){
        return comsService.delNewComment(comments);
    }
    @PostMapping(path = "change")
    public ComsResponse updateMyComs(@RequestBody Comments comments){
        return comsService.updateComs(comments);
    }

}
