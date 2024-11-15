CREATE TABLE IF NOT EXISTS user_info
(
    user_id       VARCHAR(255) NOT NULL,
    password      VARCHAR(255) NULL,
    name          VARCHAR(255) NULL,
    registered_at datetime     NULL,
    CONSTRAINT pk_user_info PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS resume
(
    resume_id       VARCHAR(255) NOT NULL,
    user_id         VARCHAR(255) NULL,
    career          INT          NULL,
    applicant_name  VARCHAR(255) NULL,
    education_level INT          NULL,
    CONSTRAINT pk_resume PRIMARY KEY (resume_id)
);

ALTER TABLE resume
    ADD CONSTRAINT FK_RESUME_ON_USER FOREIGN KEY (user_id) REFERENCES user_info (user_id);

CREATE TABLE IF NOT EXISTS language
(
    id        BIGINT       NOT NULL,
    resume_id VARCHAR(255) NULL,
    language  VARCHAR(255) NULL,
    CONSTRAINT pk_language PRIMARY KEY (id)
);

ALTER TABLE language
    ADD CONSTRAINT FK_LANGUAGE_ON_RESUME FOREIGN KEY (resume_id) REFERENCES resume (resume_id);

CREATE TABLE IF NOT EXISTS job_category
(
    id        BIGINT       NOT NULL,
    resume_id VARCHAR(255) NULL,
    category  VARCHAR(255) NULL,
    CONSTRAINT pk_job_category PRIMARY KEY (id)
);

ALTER TABLE job_category
    ADD CONSTRAINT FK_JOB_CATEGORY_ON_RESUME FOREIGN KEY (resume_id) REFERENCES resume (resume_id);