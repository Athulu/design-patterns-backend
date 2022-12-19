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
VALUES ('1', 'Ta sama instancja obiektu', 1),
       ('2', 'Dodano z tego samego loggera', 1),
       ('1', 'class Car', 2),
       ('2', 'class Motorcycle', 2),
       ('3', 'class Airplane', 2),
       ('4', 'engine car ok', 2),
       ('5', 'engine motorcycle ok', 2),
       ('6', 'engine airplane ok', 2),
       ('1', 'WindowsButton WindowsCheckbox', 3),
       ('2', 'MacOSButton MacOSCheckbox', 3),
       ('3', 'WindowsFactory implementuje GUIFactory', 3),
       ('4', 'MacOSFactory implementuje GUIFactory', 3),
       ('5', 'WindowsButton implementuje Button', 3),
       ('6', 'MacOSButton implementuje Button', 3),
       ('7', 'WindowsCheckbox implementuje Checkbox', 3),
       ('8', 'MacOSCheckbox implementuje Checkbox', 3);




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


-- INSERT INTO result(is_correct, output_data, solution_id, test_id, cookie)
-- VALUES (true, 'output data 1', 1, 1, 'cookie');
--        (true, 'output data 2', 2, 2),
--        (true, 'output data 3', 2, 3),
--        (true, 'output data 3', 3, 3);

