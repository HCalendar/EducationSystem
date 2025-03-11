package org.example.educationsystembackend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.example.educationsystembackend.entity.Comment;
import org.example.educationsystembackend.entity.SurveyResponse;

import java.util.List;

@Mapper
public interface SurveyResponseMapper {
    @Insert("INSERT INTO survey_responses (user_id,section,question_id,answer) VALUES (#{userId},#{section},#{questionId},#{answer})")
    @Options(useGeneratedKeys = true, keyProperty = "responseId")
    void insertSurveyResponse(SurveyResponse surveyResponse);

    @Select("SELECT * FROM survey_responses WHERE user_id = #{userId}")
    List<SurveyResponse> getSurveyResponsesByUserId(Integer userId);
}
