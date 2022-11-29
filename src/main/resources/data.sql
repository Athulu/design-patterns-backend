INSERT INTO task(name, design_pattern, description)
VALUES ('name1', 'design pattern 1', 'description1'),
       ('name2', 'design pattern 2', 'description2'),
       ('name3', 'design pattern 3', 'description3'),
       ('name4', 'design pattern 4', 'description4'),
       ('name5', 'design pattern 5', 'description5');

INSERT INTO test(input_data, output_data, task_id)
VALUES ('test1 in', 'test1 out', 1),
       ('test2 in', 'test2 out', 2),
       ('test3 in', 'test3 out', 3),
       ('test4 in', 'test4 out', 4),
       ('2', '1', 5),
       ('3', '3', 5),
       ('10', '55', 5);

INSERT INTO solution(results_points, task_id)
VALUES (11, 1),
       (12, 2),
       (13, 3),
       (14, 4),
       (15, 5);

INSERT INTO result(is_correct, output_data, solution_id, test_id)
VALUES (true, 'output data 1', 1, 1),
       (true, 'output data 2', 2, 2),
       (true, 'output data 3', 2, 3),
       (true, 'output data 3', 3, 3);

