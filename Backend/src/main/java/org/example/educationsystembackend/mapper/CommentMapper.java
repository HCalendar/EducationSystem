package org.example.educationsystembackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.example.educationsystembackend.entity.Comment;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    @Insert("INSERT INTO comment (comment_text) VALUES (#{commentText})")
    @Options(useGeneratedKeys = true, keyProperty = "commentId")
    void insertComment(Comment comment);

    @Select("select * from comment")
    List<Comment> getAllComment();
}
