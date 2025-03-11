create database education_system;
use education_system;
CREATE TABLE personal_info (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    profession VARCHAR(50) NOT NULL,
    other_profession VARCHAR(100),
    knowledge_level VARCHAR(20) NOT NULL,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE survey_responses (
    response_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    section ENUM('phishing', 'system', 'learning') NOT NULL,
    question_id INT NOT NULL,
    answer INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES personal_info(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE questions (
    question_id INT AUTO_INCREMENT PRIMARY KEY,
    section ENUM('phishing', 'system', 'learning') NOT NULL,
    question_text TEXT NOT NULL,
    options JSON NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE comment (
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    comment_text TEXT NOT NULL,
    comment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 钓鱼邮件认知部分
INSERT INTO questions (section, question_text, options) VALUES
                                                            ('phishing', '我能快速识别钓鱼邮件的可疑特征（如异常链接、拼写错误）。', '[1, 2, 3, 4, 5]'),
                                                            ('phishing', '我认为钓鱼邮件攻击是当前网络安全的主要威胁之一。', '[1, 2, 3, 4, 5]'),
                                                            ('phishing', '我收到可疑邮件时会立即删除，而不点击任何链接。', '[1, 2, 3, 4, 5]'),
                                                            ('phishing', '我知道如何举报钓鱼邮件（如使用企业邮箱的“上报垃圾邮件”功能）。', '[1, 2, 3, 4, 5]'),
                                                            ('phishing', '我定期学习网络安全知识以应对新型钓鱼攻击。', '[1, 2, 3, 4, 5]');

-- 系统使用体验部分
INSERT INTO questions (section, question_text, options) VALUES
                                                            ('system', '钓鱼邮件的识别技巧模块内容清晰，钓鱼邮件特征明显。', '[1, 2, 3, 4, 5]'),
                                                            ('system', '防范策略模块呈现方式易于阅读和操作。', '[1, 2, 3, 4, 5]'),
                                                            ('system', '案例分析模块帮助我更好地理解攻击链过程。', '[1, 2, 3, 4, 5]'),
                                                            ('system', '互动模拟模块（找漏洞）提高了我的实际辨别能力。', '[1, 2, 3, 4, 5]'),
                                                            ('system', '我会向他人推荐使用本系统进行网络安全学习。', '[1, 2, 3, 4, 5]');

-- 学习效果评估部分
INSERT INTO questions (section, question_text, options) VALUES
                                                            ('learning', '通过本系统的学习，我对钓鱼邮件的危险性有了更清晰的认识。', '[1, 2, 3, 4, 5]'),
                                                            ('learning', '本系统的内容和案例有助于我在实际工作、生活中识别钓鱼邮件。', '[1, 2, 3, 4, 5]'),
                                                            ('learning', '本系统的学习内容适合我的知识水平。', '[1, 2, 3, 4, 5]'),
                                                            ('learning', '我认为本系统的互动模块能有效提升安全意识。', '[1, 2, 3, 4, 5]'),
                                                            ('learning', '我计划在日常工作中应用本系统教授的防范技巧。', '[1, 2, 3, 4, 5]');
