package org.example.educationsystembackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.educationsystembackend.entity.SurveyRequest;
import org.example.educationsystembackend.entity.SurveyResponse;

import java.util.List;

@Mapper
public interface SurveyRequestMapper extends BaseMapper<SurveyRequest> {
    @Select("SELECT * FROM personal_info")
    @Results({
            @Result(property = "personalInfo.userId", column = "user_id"),
            @Result(property = "personalInfo.profession", column = "profession"),
            @Result(property = "personalInfo.otherProfession", column = "other_profession"),
            @Result(property = "personalInfo.knowledgeLevel", column = "knowledge_level"),
            @Result(property = "personalInfo.createdTime", column = "created_time"),
            @Result(property = "surveyResponses", column = "user_id",
                    many = @Many(select = "org.example.educationsystembackend.mapper.SurveyResponseMapper.getSurveyResponsesByUserId"))
    })
    List<SurveyRequest> findAllSurveyRequests();

}
