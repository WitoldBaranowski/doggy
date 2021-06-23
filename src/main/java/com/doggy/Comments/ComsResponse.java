package com.doggy.Comments;

import java.util.ArrayList;
import java.util.List;

public class ComsResponse {
    List<Comments> data = new ArrayList<Comments>();

    public ComsResponse() {
    }

    public ComsResponse(List<Comments> data) {
        this.data = data;
    }

    public List<Comments> getData() {
        return data;
    }

    public void setData(List<Comments> data) {
        this.data = data;
    }
}
