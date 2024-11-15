INSERT INTO user_info(user_id, password, name) values ( 'test', 'test', 'test' );

INSERT INTO resume (resume_id, user_id, career, applicant_name, education_level) VALUES
                                                                                     ('00000000-0000-0000-0000-000000000001', 'test', 5, 'Applicant 1', 3),
                                                                                     ('00000000-0000-0000-0000-000000000002', 'test', 10, 'Applicant 2', 4),
                                                                                     ('00000000-0000-0000-0000-000000000003', 'test', 7, 'Applicant 3', 2),
                                                                                     ('00000000-0000-0000-0000-000000000004', 'test', 12, 'Applicant 4', 1),
                                                                                     ('00000000-0000-0000-0000-000000000005', 'test', 3, 'Applicant 5', 5),
                                                                                     ('00000000-0000-0000-0000-000000000006', 'test', 8, 'Applicant 6', 2),
                                                                                     ('00000000-0000-0000-0000-000000000007', 'test', 15, 'Applicant 7', 4),
                                                                                     ('00000000-0000-0000-0000-000000000008', 'test', 6, 'Applicant 8', 3),
                                                                                     ('00000000-0000-0000-0000-000000000009', 'test', 9, 'Applicant 9', 2),
                                                                                     ('00000000-0000-0000-0000-000000000010', 'test', 11, 'Applicant 10', 5),
                                                                                     ('00000000-0000-0000-0000-000000000011', 'test', 4, 'Applicant 11', 1),
                                                                                     ('00000000-0000-0000-0000-000000000012', 'test', 13, 'Applicant 12', 4),
                                                                                     ('00000000-0000-0000-0000-000000000013', 'test', 2, 'Applicant 13', 3),
                                                                                     ('00000000-0000-0000-0000-000000000014', 'test', 16, 'Applicant 14', 2),
                                                                                     ('00000000-0000-0000-0000-000000000015', 'test', 7, 'Applicant 15', 5),
                                                                                     ('00000000-0000-0000-0000-000000000016', 'test', 14, 'Applicant 16', 1),
                                                                                     ('00000000-0000-0000-0000-000000000017', 'test', 5, 'Applicant 17', 4),
                                                                                     ('00000000-0000-0000-0000-000000000018', 'test', 9, 'Applicant 18', 3),
                                                                                     ('00000000-0000-0000-0000-000000000019', 'test', 6, 'Applicant 19', 2),
                                                                                     ('00000000-0000-0000-0000-000000000020', 'test', 11, 'Applicant 20', 5),
                                                                                     ('00000000-0000-0000-0000-000000000021', 'test', 3, 'Applicant 21', 1),
                                                                                     ('00000000-0000-0000-0000-000000000022', 'test', 12, 'Applicant 22', 4),
                                                                                     ('00000000-0000-0000-0000-000000000023', 'test', 8, 'Applicant 23', 3),
                                                                                     ('00000000-0000-0000-0000-000000000024', 'test', 15, 'Applicant 24', 2),
                                                                                     ('00000000-0000-0000-0000-000000000025', 'test', 4, 'Applicant 25', 5),
                                                                                     ('00000000-0000-0000-0000-000000000026', 'test', 13, 'Applicant 26', 1),
                                                                                     ('00000000-0000-0000-0000-000000000027', 'test', 7, 'Applicant 27', 4),
                                                                                     ('00000000-0000-0000-0000-000000000028', 'test', 10, 'Applicant 28', 3),
                                                                                     ('00000000-0000-0000-0000-000000000029', 'test', 9, 'Applicant 29', 2),
                                                                                     ('00000000-0000-0000-0000-000000000030', 'test', 14, 'Applicant 30', 5);


INSERT INTO job_category (id, resume_id, category) VALUES
                                                       (1, '00000000-0000-0000-0000-000000000001', 'Category A'),
                                                       (2, '00000000-0000-0000-0000-000000000001', 'Category B'),

                                                       (3, '00000000-0000-0000-0000-000000000002', 'Category C'),

                                                       (4, '00000000-0000-0000-0000-000000000003', 'Category D'),
                                                       (5, '00000000-0000-0000-0000-000000000003', 'Category E'),

                                                       (6, '00000000-0000-0000-0000-000000000004', 'Category F'),

                                                       (7, '00000000-0000-0000-0000-000000000005', 'Category G'),
                                                       (8, '00000000-0000-0000-0000-000000000005', 'Category H'),

                                                       (9, '00000000-0000-0000-0000-000000000006', 'Category I'),

                                                       (10, '00000000-0000-0000-0000-000000000007', 'Category J'),
                                                       (11, '00000000-0000-0000-0000-000000000007', 'Category K'),

                                                       (12, '00000000-0000-0000-0000-000000000008', 'Category L'),

                                                       (13, '00000000-0000-0000-0000-000000000009', 'Category M'),
                                                       (14, '00000000-0000-0000-0000-000000000009', 'Category N'),

                                                       (15, '00000000-0000-0000-0000-000000000010', 'Category O'),

                                                       (16, '00000000-0000-0000-0000-000000000011', 'Category P'),
                                                       (17, '00000000-0000-0000-0000-000000000011', 'Category Q'),

                                                       (18, '00000000-0000-0000-0000-000000000012', 'Category R'),

                                                       (19, '00000000-0000-0000-0000-000000000013', 'Category S'),
                                                       (20, '00000000-0000-0000-0000-000000000013', 'Category T'),

                                                       (21, '00000000-0000-0000-0000-000000000014', 'Category U'),

                                                       (22, '00000000-0000-0000-0000-000000000015', 'Category V'),
                                                       (23, '00000000-0000-0000-0000-000000000015', 'Category W'),

                                                       (24, '00000000-0000-0000-0000-000000000016', 'Category X'),

                                                       (25, '00000000-0000-0000-0000-000000000017', 'Category Y'),
                                                       (26, '00000000-0000-0000-0000-000000000017', 'Category Z'),

                                                       (27, '00000000-0000-0000-0000-000000000018', 'Category AA'),

                                                       (28, '00000000-0000-0000-0000-000000000019', 'Category AB'),
                                                       (29, '00000000-0000-0000-0000-000000000019', 'Category AC'),

                                                       (30, '00000000-0000-0000-0000-000000000020', 'Category AD'),

                                                       (31, '00000000-0000-0000-0000-000000000021', 'Category AE'),
                                                       (32, '00000000-0000-0000-0000-000000000021', 'Category AF'),

                                                       (33, '00000000-0000-0000-0000-000000000022', 'Category AG'),

                                                       (34, '00000000-0000-0000-0000-000000000023', 'Category AH'),
                                                       (35, '00000000-0000-0000-0000-000000000023', 'Category AI'),

                                                       (36, '00000000-0000-0000-0000-000000000024', 'Category AJ'),

                                                       (37, '00000000-0000-0000-0000-000000000025', 'Category AK'),
                                                       (38, '00000000-0000-0000-0000-000000000025', 'Category AL'),

                                                       (39, '00000000-0000-0000-0000-000000000026', 'Category AM'),

                                                       (40, '00000000-0000-0000-0000-000000000027', 'Category AN'),
                                                       (41, '00000000-0000-0000-0000-000000000027', 'Category AO'),

                                                       (42, '00000000-0000-0000-0000-000000000028', 'Category AP'),

                                                       (43, '00000000-0000-0000-0000-000000000029', 'Category AQ'),
                                                       (44, '00000000-0000-0000-0000-000000000029', 'Category AR'),

                                                       (45, '00000000-0000-0000-0000-000000000030', 'Category AS'),
                                                       (46, '00000000-0000-0000-0000-000000000030', 'Category AT');


INSERT INTO language (id, resume_id, language) VALUES
                                                   (1, '00000000-0000-0000-0000-000000000001', 'English'),
                                                   (2, '00000000-0000-0000-0000-000000000001', 'Spanish'),
                                                   (3, '00000000-0000-0000-0000-000000000001', 'French'),

                                                   (4, '00000000-0000-0000-0000-000000000002', 'English'),
                                                   (5, '00000000-0000-0000-0000-000000000002', 'German'),

                                                   (6, '00000000-0000-0000-0000-000000000003', 'English'),
                                                   (7, '00000000-0000-0000-0000-000000000003', 'Japanese'),
                                                   (8, '00000000-0000-0000-0000-000000000003', 'Chinese'),

                                                   (9, '00000000-0000-0000-0000-000000000004', 'Spanish'),

                                                   (10, '00000000-0000-0000-0000-000000000005', 'French'),
                                                   (11, '00000000-0000-0000-0000-000000000005', 'Italian'),
                                                   (12, '00000000-0000-0000-0000-000000000005', 'Portuguese'),

                                                   (13, '00000000-0000-0000-0000-000000000006', 'English'),
                                                   (14, '00000000-0000-0000-0000-000000000006', 'Russian'),

                                                   (15, '00000000-0000-0000-0000-000000000007', 'English'),
                                                   (16, '00000000-0000-0000-0000-000000000007', 'Spanish'),
                                                   (17, '00000000-0000-0000-0000-000000000007', 'German'),

                                                   (18, '00000000-0000-0000-0000-000000000008', 'Chinese'),

                                                   (19, '00000000-0000-0000-0000-000000000009', 'Japanese'),
                                                   (20, '00000000-0000-0000-0000-000000000009', 'Korean'),

                                                   (21, '00000000-0000-0000-0000-000000000010', 'English'),
                                                   (22, '00000000-0000-0000-0000-000000000010', 'French'),

                                                   (23, '00000000-0000-0000-0000-000000000011', 'Spanish'),
                                                   (24, '00000000-0000-0000-0000-000000000011', 'Portuguese'),

                                                   (25, '00000000-0000-0000-0000-000000000012', 'German'),
                                                   (26, '00000000-0000-0000-0000-000000000012', 'Russian'),
                                                   (27, '00000000-0000-0000-0000-000000000012', 'English'),

                                                   (28, '00000000-0000-0000-0000-000000000013', 'Chinese'),

                                                   (29, '00000000-0000-0000-0000-000000000014', 'Japanese'),
                                                   (30, '00000000-0000-0000-0000-000000000014', 'English'),

                                                   (31, '00000000-0000-0000-0000-000000000015', 'French'),
                                                   (32, '00000000-0000-0000-0000-000000000015', 'German'),
                                                   (33, '00000000-0000-0000-0000-000000000015', 'Spanish'),

                                                   (34, '00000000-0000-0000-0000-000000000016', 'Italian'),

                                                   (35, '00000000-0000-0000-0000-000000000017', 'English'),
                                                   (36, '00000000-0000-0000-0000-000000000017', 'Russian'),

                                                   (37, '00000000-0000-0000-0000-000000000018', 'Portuguese'),
                                                   (38, '00000000-0000-0000-0000-000000000018', 'French'),
                                                   (39, '00000000-0000-0000-0000-000000000018', 'Spanish'),

                                                   (40, '00000000-0000-0000-0000-000000000019', 'English'),

                                                   (41, '00000000-0000-0000-0000-000000000020', 'Japanese'),
                                                   (42, '00000000-0000-0000-0000-000000000020', 'Korean'),
                                                   (43, '00000000-0000-0000-0000-000000000020', 'Chinese'),

                                                   (44, '00000000-0000-0000-0000-000000000021', 'English'),
                                                   (45, '00000000-0000-0000-0000-000000000021', 'Spanish'),

                                                   (46, '00000000-0000-0000-0000-000000000022', 'French'),
                                                   (47, '00000000-0000-0000-0000-000000000022', 'Italian'),

                                                   (48, '00000000-0000-0000-0000-000000000023', 'German'),
                                                   (49, '00000000-0000-0000-0000-000000000023', 'Russian'),
                                                   (50, '00000000-0000-0000-0000-000000000023', 'English'),

                                                   (51, '00000000-0000-0000-0000-000000000024', 'Chinese'),

                                                   (52, '00000000-0000-0000-0000-000000000025', 'Japanese'),
                                                   (53, '00000000-0000-0000-0000-000000000025', 'English'),

                                                   (54, '00000000-0000-0000-0000-000000000026', 'French'),
                                                   (55, '00000000-0000-0000-0000-000000000026', 'German'),

                                                   (56, '00000000-0000-0000-0000-000000000027', 'Spanish'),
                                                   (57, '00000000-0000-0000-0000-000000000027', 'Italian'),
                                                   (58, '00000000-0000-0000-0000-000000000027', 'Portuguese'),

                                                   (59, '00000000-0000-0000-0000-000000000028', 'English'),

                                                   (60, '00000000-0000-0000-0000-000000000029', 'Russian'),
                                                   (61, '00000000-0000-0000-0000-000000000029', 'Spanish'),

                                                   (62, '00000000-0000-0000-0000-000000000030', 'Portuguese'),
                                                   (63, '00000000-0000-0000-0000-000000000030', 'French'),
                                                   (64, '00000000-0000-0000-0000-000000000030', 'English');
