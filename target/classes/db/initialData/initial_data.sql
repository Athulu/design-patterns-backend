INSERT INTO task(task_id, name, design_pattern, description)
VALUES (1, 'singleton', 'Singleton', 'description1'),
       (2, 'fabrykamd', 'Fabryka Metoda wytwórcza', 'description2'),
       (3, 'fabrykaab', 'Fabryka Abstrakcyjna', 'description3'),
       (4, 'fasada', 'Fasada', 'description4'),
       (5, 'kompozyt', 'Kompozyt', 'description5'),
       (6, 'strategia', 'Strategia', 'description6'),
       (7, 'iterator', 'Iterator', 'description7'),
       (8, 'obserwator', 'Obserwator', 'description8'),
       (9, 'dekorator', 'Dekorator', 'description9'),
       (10, 'adapter', 'Adapter', 'description10');

INSERT INTO test(input_data, output_data, task_id)
VALUES ('1', 'Ta sama instancja obiektu', 1),
       ('2', 'Dodano z tego samego loggera', 1),
--        metoda wytwórcza
       ('1', 'class Car', 2),
       ('2', 'class Motorcycle', 2),
       ('3', 'class Airplane', 2),
       ('4', 'engine car ok', 2),
       ('5', 'engine motorcycle ok', 2),
       ('6', 'engine airplane ok', 2),
--        fabryka abstrakcyjna
       ('1', 'WindowsButton WindowsCheckbox', 3),
       ('2', 'MacOSButton MacOSCheckbox', 3),
       ('3', 'WindowsFactory implementuje GUIFactory', 3),
       ('4', 'MacOSFactory implementuje GUIFactory', 3),
       ('5', 'WindowsButton implementuje Button', 3),
       ('6', 'MacOSButton implementuje Button', 3),
       ('7', 'WindowsCheckbox implementuje Checkbox', 3),
       ('8', 'MacOSCheckbox implementuje Checkbox', 3),
--        Fasada
       ('1', 'Circle', 4),
       ('2', 'Rectangle', 4),
       ('3', 'Square', 4),
       ('4', 'zmienna circle jest typu Circle', 4),
       ('5', 'zmienna rectangle jest typu Rectangle', 4),
       ('6', 'zmienna square jest typu Square', 4),
       ('7', 'Klasa Circle implementuje interfejs Shape', 4),
       ('8', 'Klasa Rectangle implementuje interfejs Shape', 4),
       ('9', 'Klasa Square implementuje interfejs Shape', 4),
--        Kompozyt
       ('1', 'CompositeNode dziedziczy po klasie Composite', 5),
       ('2', 'Leaf dziedziczy po klasie Composite', 5),
       ('3', 'funkcja add() dziala poprawnie', 5),
       ('4', 'funkcja remove() dziala poprawnie', 5),
--        Strategia
       ('1', 'Context klasy OperationAdd dziala poprawnie', 6),
       ('2', 'Context klasy OperationSubstract dziala poprawnie', 6),
       ('3', 'Context klasy OperationMultiply dziala poprawnie', 6),
       ('4', 'OperationAdd implementuje interfejs Strategy', 6),
       ('5', 'OperationSubstract implementuje interfejs Strategy', 6),
       ('6', 'OperationMultiply implementuje interfejs Strategy', 6),
--        Iterator
       ('1', 'NamesRepository implementuje interfejs Container', 7),
       ('2', 'NewIterator implementuje interfejs Iterator', 7),
       ('3', 'MikolajNikodemAdrianArtur', 7),
--        Obserwator
       ('1', 'updateObserver dzidziczy po Observer', 8),
       ('2', 'Poprawnie przekazany obiekt klasy Subject', 8),
       ('3', 'state updated', 8),
--        Dekorator
       ('1', 'Car Sport', 9),
       ('2', 'Car Luxury', 9),
       ('3', 'Car Luxury Sport', 9),
       ('4', 'SportsCar dziedziczy po CarDecorator', 9),
       ('5', 'LuxuryCar dziedziczy po CarDecorator', 9),
       ('6', 'Car Luxury Sport Luxury Sport', 9),
--        Adapter
       ('1', 'Wizard fireballs', 10),
       ('2', 'Wizard shields', 10),
       ('3', 'WizardAdapter implementuje interfejs Figher', 10);

INSERT INTO result(is_correct, output_data, test_id, cookie)
VALUES (true, 'output data 1', 1, 'cookie');

