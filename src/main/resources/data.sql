INSERT INTO intake(report_date)
VALUES ('2023-09-20'),
       ('2023-09-21'),
       ('2023-09-22');

INSERT INTO drink(volume_in_ml, type, intake_id)
VALUES (250, 'coffee', 1),
       (250, 'water', 1),
       (250, 'tea', 1),
       (150, 'wine', 1),
       (250, 'water', 1),
       (250, 'water', 1),
       (250, 'coffee', 2),
       (500, 'water', 2),
       (500, 'beer', 2),
       (500, 'beer', 2);