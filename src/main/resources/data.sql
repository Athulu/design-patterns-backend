INSERT INTO tests(input_data, output_data)
VALUES ('test1 in', 'test1 out'),
       ('test2 in', 'test2 out'),
       ('test3 in', 'test3 out'),
       ('test4 in', 'test4 out'),
       ('test5 in', 'test5 out');

INSERT INTO tasks(name, design_pattern, description)
VALUES ('name1', 'design pattern 1', 'description1'),
       ('name2', 'design pattern 2', 'description2'),
       ('name3', 'design pattern 3', 'description3'),
       ('name4', 'design pattern 4', 'description4'),
       ('name5', 'design pattern 5', 'description5');

INSERT INTO results(is_correct, output_data)
VALUES (true, 'output data 1'),
       (true, 'output data 2'),
       (true, 'output data 3'),
       (false, 'output data 4'),
       (false, 'output data 5');

INSERT INTO solutions(results_points)
VALUES (11),
       (12),
       (13),
       (14),
       (15);