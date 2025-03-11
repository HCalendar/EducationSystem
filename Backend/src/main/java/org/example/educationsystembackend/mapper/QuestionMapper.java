package org.example.educationsystembackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.educationsystembackend.entity.Question;

@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
}
