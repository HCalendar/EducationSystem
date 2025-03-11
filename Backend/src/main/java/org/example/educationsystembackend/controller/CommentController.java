package org.example.educationsystembackend.controller;

import org.example.educationsystembackend.entity.Comment;
import org.example.educationsystembackend.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    CommentMapper commentMapper;

    @PostMapping("/insert")
    public String insert(@RequestBody Comment comment){
        commentMapper.insertComment(comment);
        return "success";
    }

    @GetMapping("/getAll")
    public List<Comment> getAllComment(){
        return commentMapper.getAllComment();
    }
}
