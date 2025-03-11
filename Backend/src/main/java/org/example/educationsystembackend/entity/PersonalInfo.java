package org.example.educationsystembackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfo {
    private Integer userId;
    private String profession;
    private String otherProfession;
    private String knowledgeLevel;
    private LocalDateTime createdTime;
}
