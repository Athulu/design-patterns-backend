INSERT INTO task(name, design_pattern, description)
VALUES ('singleton', 'Singleton', 'description1'),
       ('fabrykamd', 'Fabryka Metoda wytwórcza', 'description2'),
       ('fabrykaab', 'Fabryka Abstrakcyjna', 'description3'),
       ('fasada', 'Fasada', 'description4'),
       ('kompozyt', 'Kompozyt', 'description5'),
       ('strategia', 'Strategia', 'description6'),
       ('iterator', 'Iterator', 'description7'),
       ('obserwator', 'Obserwator', 'description8'),
       ('dekorator', 'Dekorator', 'description9'),
       ('adapter', 'Adapter', 'description10');

INSERT INTO test(input_data, output_data, task_id)
VALUES ('', 'Ta sama instancja obiektu', 1),
       ('', 'Dodano z tego samego loggera', 1);

INSERT INTO solution(results_points, task_id)
VALUES (0, 1),
       (0, 2),
       (0, 3),
       (0, 4),
       (0, 5),
       (0, 6),
       (0, 7),
       (0, 8),
       (0, 9),
       (0, 10);


-- INSERT INTO result(is_correct, output_data, solution_id, test_id)
-- VALUES (true, 'output data 1', 1, 1),
--        (true, 'output data 2', 2, 2),
--        (true, 'output data 3', 2, 3),
--        (true, 'output data 3', 3, 3);

