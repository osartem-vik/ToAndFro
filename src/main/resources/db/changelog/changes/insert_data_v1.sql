-- liquibase formatted sql
-- changeset raw:init_data_V1
-- splitStatements:true
-- endDelimiter:;


INSERT INTO user (email, password_hash, lastname, firstname, phone)
VALUES ('ivan.petrenko@gmail.com', 'pass1234', 'Petrenko', 'Ivan', '+380671234567'),
       ('olena.shevchenko@yahoo.com', 'qwerty89', 'Shevchenko', 'Olena', '+380981112233'),
       ('andriy.koval@ukr.net', 'andriy2024', 'Koval', 'Andriy', '+380931234567'),
       ('maria.bondar@gmail.com', 'mariaPass!', 'Bondar', 'Maria', '+380661223344'),
       ('serhii.kravets@meta.ua', 'securePass1', 'Kravets', 'Serhii', '+380501234987'),
       ('iryna.romanova@gmail.com', 'iryna2023', 'Romanova', 'Iryna', '+380671119988'),
       ('oleh.danchenko@icloud.com', 'olehCool9', 'Danchenko', 'Oleg', '+380991234123'),
       ('kateryna.melnyk@gmail.com', 'katyaLove', 'Melnyk', 'Kateryna', '+380631556677'),
       ('maksym.holub@ukr.net', 'holubPass2', 'Holub', 'Maksym', '+380671112255'),
       ('sofia.tkach@gmail.com', 'tkach2025', 'Tkach', 'Sofia', '+380501118899');

INSERT INTO region (name)
VALUES ('Vinnytsia Region'),
       ('Volyn Region'),
       ('Dnipropetrovsk Region'),
       ('Donetsk Region'),
       ('Zhytomyr Region'),
       ('Zakarpattia Region'),
       ('Zaporizhzhia Region'),
       ('Ivano-Frankivsk Region'),
       ('Kyiv Region'),
       ('Kirovohrad Region'),
       ('Luhansk Region'),
       ('Lviv Region'),
       ('Mykolaiv Region'),
       ('Odesa Region'),
       ('Poltava Region'),
       ('Rivne Region'),
       ('Sumy Region'),
       ('Ternopil Region'),
       ('Kharkiv Region'),
       ('Kherson Region'),
       ('Khmelnytskyi Region'),
       ('Cherkasy Region'),
       ('Chernivtsi Region'),
       ('Chernihiv Region'),
       ('Autonomous Republic of Crimea');

INSERT INTO city (name, region_id)
VALUES
-- 1. Vinnytsia Region
('Vinnytsia', 1),
('Zhmerynka', 1),
('Mohyliv-Podilskyi', 1),
('Koziatyn', 1),
('Khmilnyk', 1),
-- 2. Volyn Region
('Lutsk', 2),
('Kovel', 2),
('Novovolynsk', 2),
('Volodymyr', 2),
-- 3. Dnipropetrovsk Region
('Dnipro', 3),
('Kryvyi Rih', 3),
('Kamianske', 3),
('Nikopol', 3),
('Pavlohrad', 3),
-- 4. Donetsk Region
('Donetsk', 4),
('Mariupol', 4),
('Kramatorsk', 4),
('Sloviansk', 4),
('Makiivka', 4),
-- 5. Zhytomyr Region
('Zhytomyr', 5),
('Berdychiv', 5),
('Korosten', 5),
('Novohrad-Volynskyi', 5),
-- 6. Zakarpattia Region
('Uzhhorod', 6),
('Mukachevo', 6),
('Berehove', 6),
('Khust', 6),
('Vynohradiv', 6),
-- 7. Zaporizhzhia Region
('Zaporizhzhia', 7),
('Melitopol', 7),
('Berdiansk', 7),
('Enerhodar', 7),
-- 8. Ivano-Frankivsk Region
('Ivano-Frankivsk', 8),
('Kolomyia', 8),
('Kalush', 8),
('Nadvirna', 8),
-- 9. Kyiv Region
('Bila Tserkva', 9),
('Boryspil', 9),
('Brovary', 9),
('Irpin', 9),
('Fastiv', 9),
-- 10. Kirovohrad Region
('Kropyvnytskyi', 10),
('Oleksandriia', 10),
('Svitlovodsk', 10),
('Znamianka', 10),
-- 11. Luhansk Region
('Luhansk', 11),
('Sievierodonetsk', 11),
('Lysychansk', 11),
('Rubizhne', 11),
-- 12. Lviv Region
('Lviv', 12),
('Drohobych', 12),
('Chervonohrad', 12),
('Stryi', 12),
('Truskavets', 12),
-- 13. Mykolaiv Region
('Mykolaiv', 13),
('Voznesensk', 13),
('Pervomaisk', 13),
('Ochakiv', 13),
-- 14. Odesa Region
('Odesa', 14),
('Izmail', 14),
('Bilhorod-Dnistrovskyi', 14),
('Chornomorsk', 14),
('Podilsk', 14),
-- 15. Poltava Region
('Poltava', 15),
('Kremenchuk', 15),
('Lubny', 15),
('Myrhorod', 15),
-- 16. Rivne Region
('Rivne', 16),
('Dubno', 16),
('Kostopil', 16),
('Sarny', 16),
-- 17. Sumy Region
('Sumy', 17),
('Konotop', 17),
('Shostka', 17),
('Okhtyrka', 17),
('Romny', 17),
-- 18. Ternopil Region
('Ternopil', 18),
('Chortkiv', 18),
('Kremenets', 18),
('Berezhany', 18),
-- 19. Kharkiv Region
('Kharkiv', 19),
('Lozova', 19),
('Izium', 19),
('Kupiansk', 19),
-- 20. Kherson Region
('Kherson', 20),
('Nova Kakhovka', 20),
('Kakhovka', 20),
('Henichesk', 20),
-- 21. Khmelnytskyi Region
('Khmelnytskyi', 21),
('Kamianets-Podilskyi', 21),
('Shepetivka', 21),
('Starokostiantyniv', 21),
-- 22. Cherkasy Region
('Cherkasy', 22),
('Uman', 22),
('Smila', 22),
('Zolotonosha', 22),
-- 23. Chernivtsi Region
('Chernivtsi', 23),
('Novodnistrovsk', 23),
('Storozhynets', 23),
('Kitsman', 23),
-- 24. Chernihiv Region
('Chernihiv', 24),
('Nizhyn', 24),
('Pryluky', 24),
('Novhorod-Siverskyi', 24),
-- 25. Autonomous Republic of Crimea
('Simferopol', 25),
('Sevastopol', 25),
('Yalta', 25),
('Kerch', 25),
('Yevpatoria', 25),
-- 26. Kyiv
('Kyiv', 9);

-- 1) Ivan Petrenko — Passenger cars — Brovary
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'ivan.petrenko@gmail.com' LIMIT 1),
        ('TRANSPORT'),
        (SELECT id FROM city WHERE name = 'Brovary' LIMIT 1),
        'Volkswagen Golf 2016, 1.6 TDI',
        'Car in good condition, no accidents, serviced regularly. Includes winter tires set.',
        8500.00, NOW(), 'ACTIVE');
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 2) Olena Shevchenko — Apartments — Lviv
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'olena.shevchenko@yahoo.com' LIMIT 1),
        ('IMMOBILITY'),
        (SELECT id FROM city WHERE name = 'Lviv' LIMIT 1),
        '1-room apartment in new building, 42 sq.m., RC “Riverside”',
        'Bright apartment with renovation, individual heating, secured area, park nearby.',
        47000.00, NOW(), 'ACTIVE');
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 3) Andriy Koval — Smartphones — Dnipro
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'andriy.koval@ukr.net' LIMIT 1),
        ('ELECTRONICS'),
        (SELECT id FROM city WHERE name = 'Dnipro' LIMIT 1),
        'iPhone 13, 128 GB, Midnight',
        'Excellent condition, battery 89%, complete set, one owner.',
        19500.00, NOW(), 'ACTIVE');
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 4) Maria Bondar — Furniture — Ivano-Frankivsk
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'maria.bondar@gmail.com' LIMIT 1),
        ('HOME'),
        (SELECT id FROM city WHERE name = 'Ivano-Frankivsk' LIMIT 1),
        'Corner sofa, microfiber fabric',
        'Almost new, no stains or scuffs, linen storage compartment, dolphin type unfolding mechanism.',
        8500.00, NOW(), 'ACTIVE');
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 5) Serhiy Kravets — Dogs — Kharkiv
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'serhii.kravets@meta.ua' LIMIT 1),
        ('ANIMALS'),
        (SELECT id FROM city WHERE name = 'Kharkiv' LIMIT 1),
        'Labrador puppies, 2 months old, UKU (Ukrainian Kennel Union) documents',
        'Healthy, active, and vaccinated for their age. Parents have good pedigrees.',
        7000.00, NOW(), 'ACTIVE');
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 6) Iryna Romanova — Computers and laptops — Kyiv
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'iryna.romanova@gmail.com' LIMIT 1),
        ('ELECTRONICS'),
        (SELECT id FROM city WHERE name = 'Kyiv' LIMIT 1),
        'ASUS VivoBook 15 laptop, i5, 16GB/512GB',
        'Lightweight and fast, IPS screen, excellent condition, no scratches.',
        21500.00, NOW(), 'ACTIVE');
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 7) Iryna Romanova — Televisions and audio — Bila Tserkva
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'iryna.romanova@gmail.com' LIMIT 1),
        ('ELECTRONICS'),
        (SELECT id FROM city WHERE name = 'Bila Tserkva' LIMIT 1),
        'Samsung 50" TV, 4K, Smart TV',
        'Remote control, box, AirPlay/YouTube/Netflix support. Works perfectly.',
        11500.00, NOW(), 'ACTIVE');
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 8) Oleg Danchenko — Houses — Odesa
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'oleh.danchenko@icloud.com' LIMIT 1),
        ('IMMOBILITY'),
        (SELECT id FROM city WHERE name = 'Odesa' LIMIT 1),
        'House 120 sq.m., Tairove, 4 ares of land',
        'Modern renovation, heated floors, garage, terrace, convenient access.',
        155000.00, NOW(), 'ACTIVE');
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 9) Oleg Danchenko — Instruments — Zaporizhzhia
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'oleh.danchenko@icloud.com' LIMIT 1),
        ('HOME'),
        (SELECT id FROM city WHERE name = 'Zaporizhzhia' LIMIT 1),
        'DeWalt D25134K Rotary Hammer, 800 W',
        'Set: case, chuck, depth stop, excellent condition, used very little.',
        3200.00, NOW(), 'ACTIVE');
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 10) Kateryna Melnyk — Clothing — Chernihiv
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'kateryna.melnyk@gmail.com' LIMIT 1),
        ('FASHION'),
        (SELECT id FROM city WHERE name = 'Chernihiv' LIMIT 1),
        'Women''s coat, 80% wool, size M',
        'Classic cut, minimalist design, beige color, perfect condition.',
        2800.00, NOW(), 'ACTIVE');
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 11) Kateryna Melnyk — Accessories — Rivne
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'kateryna.melnyk@gmail.com' LIMIT 1),
        ('FASHION'),
        (SELECT id FROM city WHERE name = 'Rivne' LIMIT 1),
        'Cross-body bag, genuine leather',
        'Made in Ukraine, durable hardware, adjustable strap.',
        1600.00, NOW(), 'ACTIVE');
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 12) Maksym Holub — Transport services — Poltava
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'maksym.holub@ukr.net' LIMIT 1),
        ('SERVICES'),
        (SELECT id FROM city WHERE name = 'Poltava' LIMIT 1),
        'Freight transportation up to 2 tons across Ukraine',
        'Clean van, loading assistance, we work 24/7, no prepayment.',
        20.00, NOW(), 'ACTIVE' -- ціна за км
       );
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 13) Maksym Holub — Motorcycles — Kryvyi Rih
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'maksym.holub@ukr.net' LIMIT 1),
        ('TRANSPORT'),
        (SELECT id FROM city WHERE name = 'Kryvyi Rih' LIMIT 1),
        'Honda CB500F 2019, ABS',
        'Mileage 12 thousand km, service book, two keys, not damaged/accident-free.',
        135000.00, NOW(), 'ACTIVE');
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 14) Maksym Holub — Rent — Kyiv
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'maksym.holub@ukr.net' LIMIT 1),
        ('TRANSPORT'),
        (SELECT id FROM city WHERE name = 'Kyiv' LIMIT 1),
        'Office for rent 32 sq.m., center, Zoloti Vorota metro station',
        'Bright office, furniture, air conditioning, internet, 24/7 access.',
        18000.00, NOW(), 'ACTIVE' -- ціна за місяць
       );
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 15) Sofia Tkach — IT and computers — Cherkasy (vacancy)
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'sofia.tkach@gmail.com' LIMIT 1),
        ('WORK'),
        (SELECT id FROM city WHERE name = 'Cherkasy' LIMIT 1),
        'Junior QA Engineer (remote)',
        'Commercial experience 6+ months, knowledge of test process, Jira/Confluence; Cypress will be a plus.',
        25000.00, NOW(), 'ACTIVE' -- зарплата/міс.
       );
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 16) Sofia Tkach — Beauty and Health — Khmelnytskyi
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'sofia.tkach@gmail.com' LIMIT 1),
        ('SERVICES'),
        (SELECT id FROM city WHERE name = 'Khmelnytskyi' LIMIT 1),
        'Cosmetologist: facial cleansing, peeling, massage',
        'Medical education, certificates, sterility and disposable materials, online booking.',
        900.00, NOW(), 'ACTIVE' -- ціна за процедуру
       );
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 17) Sofia Tkach — Shoes — Chernivtsi
INSERT INTO listing (user_id, category, city_id, title, description, price, created_at, status)
VALUES ((SELECT id FROM user WHERE email = 'sofia.tkach@gmail.com' LIMIT 1),
        ('FASHION'),
        (SELECT id FROM city WHERE name = 'Chernivtsi' LIMIT 1),
        'Leather boots, men''s, size 43',
        'Genuine leather, warm lining, anti-slip sole, almost new.',
        1900.00, NOW(), 'ACTIVE');
SET @listing_id := LAST_INSERT_ID();
INSERT INTO image (path, listing_id)
VALUES (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
       (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);


INSERT INTO favorite (user_id, listing_id)
VALUES
-- 1) Ivan Petrenko favorites listings not his own (Olena + Andriy)
((SELECT id FROM user WHERE email = 'ivan.petrenko@gmail.com' LIMIT 1),
 (SELECT l.id
  FROM listing l
           JOIN user u ON l.user_id = u.id
  WHERE u.email = 'olena.shevchenko@yahoo.com'
  LIMIT 1)),
((SELECT id FROM user WHERE email = 'ivan.petrenko@gmail.com' LIMIT 1),
 (SELECT l.id
  FROM listing l
           JOIN user u ON l.user_id = u.id
  WHERE u.email = 'andriy.koval@ukr.net'
  LIMIT 1)),

-- 2) Olena Shevchenko favorites one listing (Serhii)
((SELECT id FROM user WHERE email = 'olena.shevchenko@yahoo.com' LIMIT 1),
 (SELECT l.id
  FROM listing l
           JOIN user u ON l.user_id = u.id
  WHERE u.email = 'serhii.kravets@meta.ua'
  LIMIT 1)),

-- 3) Andriy Koval favorites one listing (Maria)
((SELECT id FROM user WHERE email = 'andriy.koval@ukr.net' LIMIT 1),
 (SELECT l.id
  FROM listing l
           JOIN user u ON l.user_id = u.id
  WHERE u.email = 'maria.bondar@gmail.com'
  LIMIT 1)),

-- 4) Maria Bondar favorites one listing (Oleh)
((SELECT id FROM user WHERE email = 'maria.bondar@gmail.com' LIMIT 1),
 (SELECT l.id
  FROM listing l
           JOIN user u ON l.user_id = u.id
  WHERE u.email = 'oleh.danchenko@icloud.com'
  LIMIT 1)),

-- 5) Serhii Kravets favorites multiple (Iryna + Kateryna)
((SELECT id FROM user WHERE email = 'serhii.kravets@meta.ua' LIMIT 1),
 (SELECT l.id
  FROM listing l
           JOIN user u ON l.user_id = u.id
  WHERE u.email = 'iryna.romanova@gmail.com'
  LIMIT 1)),
((SELECT id FROM user WHERE email = 'serhii.kravets@meta.ua' LIMIT 1),
 (SELECT l.id
  FROM listing l
           JOIN user u ON l.user_id = u.id
  WHERE u.email = 'kateryna.melnyk@gmail.com'
  LIMIT 1)),

-- 6) Kateryna Melnyk favorites one listing (Sofiia)
((SELECT id FROM user WHERE email = 'kateryna.melnyk@gmail.com' LIMIT 1),
 (SELECT l.id
  FROM listing l
           JOIN user u ON l.user_id = u.id
  WHERE u.email = 'sofia.tkach@gmail.com'
  LIMIT 1)),

-- 7) Maksym Holub favorites one listing (Ivan)
((SELECT id FROM user WHERE email = 'maksym.holub@ukr.net' LIMIT 1),
 (SELECT l.id
  FROM listing l
           JOIN user u ON l.user_id = u.id
  WHERE u.email = 'ivan.petrenko@gmail.com'
  LIMIT 1)),

-- 8) Sofiia Tkach favorites one listing (Maria)
((SELECT id FROM user WHERE email = 'sofia.tkach@gmail.com' LIMIT 1),
 (SELECT l.id
  FROM listing l
           JOIN user u ON l.user_id = u.id
  WHERE u.email = 'maria.bondar@gmail.com'
  LIMIT 1));
