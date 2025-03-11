package org.example.educationsystembackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.example.educationsystembackend.entity.Comment;
import org.example.educationsystembackend.entity.PersonalInfo;

@Mapper
public interface PersonalInfoMapper extends BaseMapper<PersonalInfo> {
    @Insert("INSERT INTO personal_info (profession, other_profession, knowledge_level) VALUES (#{profession},#{otherProfession},#{knowledgeLevel})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insertPersonalInfo(PersonalInfo personalInfo);

    @Select("SELECT * FROM personal_info WHERE user_id = #{userId}")
    PersonalInfo getPersonalInfoById(Integer userId);
}
