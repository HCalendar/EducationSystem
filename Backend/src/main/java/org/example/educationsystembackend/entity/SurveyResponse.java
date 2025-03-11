package org.example.educationsystembackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyResponse {
    private Integer responseId;
    private Integer userId;
    private String section;
    private Integer questionId;
    private Integer answer;
}
