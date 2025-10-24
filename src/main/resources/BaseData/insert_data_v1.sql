INSERT INTO user (email, password_hash, lastname, firstname, phone) VALUES
('ivan.petrenko@gmail.com', 'pass1234', 'Петренко', 'Іван', '+380671234567'),
('olena.shevchenko@yahoo.com', 'qwerty89', 'Шевченко', 'Олена', '+380981112233'),
('andriy.koval@ukr.net', 'andriy2024', 'Коваль', 'Андрій', '+380931234567'),
('maria.bondar@gmail.com', 'mariaPass!', 'Бондар', 'Марія', '+380661223344'),
('serhii.kravets@meta.ua', 'securePass1', 'Кравець', 'Сергій', '+380501234987'),
('iryna.romanova@gmail.com', 'iryna2023', 'Романова', 'Ірина', '+380671119988'),
('oleh.danchenko@icloud.com', 'olehCool9', 'Данченко', 'Олег', '+380991234123'),
('kateryna.melnyk@gmail.com', 'katyaLove', 'Мельник', 'Катерина', '+380631556677'),
('maksym.holub@ukr.net', 'holubPass2', 'Голуб', 'Максим', '+380671112255'),
('sofia.tkach@gmail.com', 'tkach2025', 'Ткач', 'Софія', '+380501118899');

INSERT INTO region (name) VALUES
('Вінницька область'),
('Волинська область'),
('Дніпропетровська область'),
('Донецька область'),
('Житомирська область'),
('Закарпатська область'),
('Запорізька область'),
('Івано-Франківська область'),
('Київська область'),
('Кіровоградська область'),
('Луганська область'),
('Львівська область'),
('Миколаївська область'),
('Одеська область'),
('Полтавська область'),
('Рівненська область'),
('Сумська область'),
('Тернопільська область'),
('Харківська область'),
('Херсонська область'),
('Хмельницька область'),
('Черкаська область'),
('Чернівецька область'),
('Чернігівська область'),
('Автономна Республіка Крим');

INSERT INTO city (name, region_id) VALUES
-- 1. Вінницька область
('Вінниця', 1), ('Жмеринка', 1), ('Могилів-Подільський', 1), ('Козятин', 1), ('Хмільник', 1),
-- 2. Волинська область
('Луцьк', 2), ('Ковель', 2), ('Нововолинськ', 2), ('Володимир', 2),
-- 3. Дніпропетровська область
('Дніпро', 3), ('Кривий Ріг', 3), ('Кам’янське', 3), ('Нікополь', 3), ('Павлоград', 3),
-- 4. Донецька область
('Донецьк', 4), ('Маріуполь', 4), ('Краматорськ', 4), ('Слов’янськ', 4), ('Макіївка', 4),
-- 5. Житомирська область
('Житомир', 5), ('Бердичів', 5), ('Коростень', 5), ('Новоград-Волинський', 5),
-- 6. Закарпатська область
('Ужгород', 6), ('Мукачево', 6), ('Берегове', 6), ('Хуст', 6), ('Виноградів', 6),
-- 7. Запорізька область
('Запоріжжя', 7), ('Мелітополь', 7), ('Бердянськ', 7), ('Енергодар', 7),
-- 8. Івано-Франківська область
('Івано-Франківськ', 8), ('Коломия', 8), ('Калуш', 8), ('Надвірна', 8),
-- 9. Київська область
('Біла Церква', 9), ('Бориспіль', 9), ('Бровари', 9), ('Ірпінь', 9), ('Фастів', 9),
-- 10. Кіровоградська область
('Кропивницький', 10), ('Олександрія', 10), ('Світловодськ', 10), ('Знам’янка', 10),
-- 11. Луганська область
('Луганськ', 11), ('Сєвєродонецьк', 11), ('Лисичанськ', 11), ('Рубіжне', 11),
-- 12. Львівська область
('Львів', 12), ('Дрогобич', 12), ('Червоноград', 12), ('Стрий', 12), ('Трускавець', 12),
-- 13. Миколаївська область
('Миколаїв', 13), ('Вознесенськ', 13), ('Первомайськ', 13), ('Очаків', 13),
-- 14. Одеська область
('Одеса', 14), ('Ізмаїл', 14), ('Білгород-Дністровський', 14), ('Чорноморськ', 14), ('Подільськ', 14),
-- 15. Полтавська область
('Полтава', 15), ('Кременчук', 15), ('Лубни', 15), ('Миргород', 15),
-- 16. Рівненська область
('Рівне', 16), ('Дубно', 16), ('Костопіль', 16), ('Сарни', 16),
-- 17. Сумська область
('Суми', 17), ('Конотоп', 17), ('Шостка', 17), ('Охтирка', 17), ('Ромни', 17),
-- 18. Тернопільська область
('Тернопіль', 18), ('Чортків', 18), ('Кременець', 18), ('Бережани', 18),
-- 19. Харківська область
('Харків', 19), ('Лозова', 19), ('Ізюм', 19), ('Куп’янськ', 19),
-- 20. Херсонська область
('Херсон', 20), ('Нова Каховка', 20), ('Каховка', 20), ('Генічеськ', 20),
-- 21. Хмельницька область
('Хмельницький', 21), ('Кам’янець-Подільський', 21), ('Шепетівка', 21), ('Старокостянтинів', 21),
-- 22. Черкаська область
('Черкаси', 22), ('Умань', 22), ('Сміла', 22), ('Золотоноша', 22),
-- 23. Чернівецька область
('Чернівці', 23), ('Новодністровськ', 23), ('Сторожинець', 23), ('Кіцмань', 23),
-- 24. Чернігівська область
('Чернігів', 24), ('Ніжин', 24), ('Прилуки', 24), ('Новгород-Сіверський', 24),
-- 25. Автономна Республіка Крим
('Сімферополь', 25), ('Севастополь', 25), ('Ялта', 25), ('Керч', 25),('Євпаторія', 25),
-- 26. Київ
('Київ', 9);

-- 1) Иван Петренко — Легкові автомобілі — Бровари
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'ivan.petrenko@gmail.com' LIMIT 1),
  ('TRANSPORT'),
  (SELECT id FROM city WHERE name = 'Бровари' LIMIT 1),
  'Volkswagen Golf 2016, 1.6 TDI',
  'Авто в хорошем состоянии, без ДТП, обслуживание по регламенту. Комплект зимней резины.',
  8500.00, NOW(), 'ACTIVE'
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 2) Олена Шевченко — Квартири — Львів
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'olena.shevchenko@yahoo.com' LIMIT 1),
  ('IMMOBILITY'),
  (SELECT id FROM city WHERE name = 'Львів' LIMIT 1),
  '1-кімнатна в новобудові, 42 м², ЖК «Ріверсайд»',
  'Світла квартира з ремонтом, індивідуальне опалення, закрита територія, поруч парк.',
  47000.00, NOW(), 'ACTIVE'
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 3) Андрій Коваль — Смартфони — Дніпро
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'andriy.koval@ukr.net' LIMIT 1),
  ('ELECTRONICS'),
  (SELECT id FROM city WHERE name = 'Дніпро' LIMIT 1),
  'iPhone 13, 128 ГБ, Midnight',
  'Стан відмінний, батарея 89%, повний комплект, один власник.',
  19500.00, NOW(), 'ACTIVE'
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 4) Марія Бондар — Меблі — Івано-Франківськ
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'maria.bondar@gmail.com' LIMIT 1),
  ('HOME'),
  (SELECT id FROM city WHERE name = 'Івано-Франківськ' LIMIT 1),
  'Диван кутовий, тканина мікрофібра',
  'Практично новий, без плям і потертостей, ніша для білизни, механізм розкладання дельфін.',
  8500.00, NOW(), 'ACTIVE'
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 5) Сергій Кравець — Собаки — Харків
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'serhii.kravets@meta.ua' LIMIT 1),
  ('ANIMALS'),
  (SELECT id FROM city WHERE name = 'Харків' LIMIT 1),
  'Щенки лабрадора, 2 місяці, документи ККУ',
  'Здорові, активні, привиті за віком. Батьки з хорошою родовідною.',
  7000.00, NOW(), 'ACTIVE'
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 6) Ірина Романова — Комп’ютери та ноутбуки — Київ
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'iryna.romanova@gmail.com' LIMIT 1),
  ('ELECTRONICS'),
  (SELECT id FROM city WHERE name = 'Київ' LIMIT 1),
  'Ноутбук ASUS VivoBook 15, i5, 16ГБ/512ГБ',
  'Легкий і швидкий, IPS-екран, стан відмінний, без подряпин.',
  21500.00, NOW(), 'ACTIVE'
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 7) Ірина Романова — Телевізори та аудіо — Біла Церква
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'iryna.romanova@gmail.com' LIMIT 1),
  ('ELECTRONICS'),
  (SELECT id FROM city WHERE name = 'Біла Церква' LIMIT 1),
  'Телевізор Samsung 50", 4K, Smart TV',
  'Пульт, коробка, підтримка AirPlay/YouTube/Netflix. Працює ідеально.',
  11500.00, NOW(), 'ACTIVE'
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 8) Олег Данченко — Будинки — Одеса
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'oleh.danchenko@icloud.com' LIMIT 1),
  ('IMMOBILITY'),
  (SELECT id FROM city WHERE name = 'Одеса' LIMIT 1),
  'Будинок 120 м², Таїрове, ділянка 4 сотки',
  'Сучасний ремонт, тепла підлога, гараж, тераса, зручний заїзд.',
  155000.00, NOW(), 'ACTIVE'
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 9) Олег Данченко — Інструменти — Запоріжжя
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'oleh.danchenko@icloud.com' LIMIT 1),
  ('HOME'),
  (SELECT id FROM city WHERE name = 'Запоріжжя' LIMIT 1),
  'Перфоратор DeWalt D25134K, 800 Вт',
  'Комплект: кейс, патрон, обмежувач, стан відмінний, мало працював.',
  3200.00, NOW(), 'ACTIVE'
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 10) Катерина Мельник — Одяг — Чернігів
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'kateryna.melnyk@gmail.com' LIMIT 1),
  ('FASHION'),
  (SELECT id FROM city WHERE name = 'Чернігів' LIMIT 1),
  'Пальто жіноче, шерсть 80%, розмір M',
  'Класичний крій, мінімалістичний дизайн, колір беж, стан ідеальний.',
  2800.00, NOW(), 'ACTIVE'
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 11) Катерина Мельник — Аксесуари — Рівне
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'kateryna.melnyk@gmail.com' LIMIT 1),
  ('FASHION'),
  (SELECT id FROM city WHERE name = 'Рівне' LIMIT 1),
  'Сумка крос-боді, натуральна шкіра',
  'Вироблено в Україні, щільна фурнітура, регульований ремінець.',
  1600.00, NOW(), 'ACTIVE'
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 12) Максим Голуб — Транспортні послуги — Полтава
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'maksym.holub@ukr.net' LIMIT 1),
  ('SERVICES'),
  (SELECT id FROM city WHERE name = 'Полтава' LIMIT 1),
  'Вантажні перевезення до 2 тонн по Україні',
  'Чистий фургон, допомога з навантаженням, працюємо 24/7, без передоплати.',
  20.00, NOW(), 'ACTIVE'  -- ціна за км
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 13) Максим Голуб — Мотоцикли — Кривий Ріг
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'maksym.holub@ukr.net' LIMIT 1),
  ('TRANSPORT'),
  (SELECT id FROM city WHERE name = 'Кривий Ріг' LIMIT 1),
  'Honda CB500F 2019, ABS',
  'Пробіг 12 тис. км, сервісна книжка, два ключі, не бита.',
  135000.00, NOW(), 'ACTIVE'
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 14) Максим Голуб — Оренда — Київ
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'maksym.holub@ukr.net' LIMIT 1),
  ('TRANSPORT'),
  (SELECT id FROM city WHERE name = 'Київ' LIMIT 1),
  'Оренда офісу 32 м², центр, метро Золоті ворота',
  'Світлий кабінет, меблі, кондиціонер, інтернет, цілодобовий доступ.',
  18000.00, NOW(), 'ACTIVE'  -- ціна за місяць
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 15) Софія Ткач — ІТ та комп’ютери — Черкаси (вакансія)
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'sofia.tkach@gmail.com' LIMIT 1),
  ('WORK'),
  (SELECT id FROM city WHERE name = 'Черкаси' LIMIT 1),
  'Junior QA Engineer (remote)',
  'Комерційний досвід 6+ міс., знання тест-процесу, Jira/Confluence, буде плюсом Cypress.',
  25000.00, NOW(), 'ACTIVE'  -- зарплата/міс.
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 16) Софія Ткач — Краса та здоров’я — Хмельницький
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'sofia.tkach@gmail.com' LIMIT 1),
  ('SERVICES'),
  (SELECT id FROM city WHERE name = 'Хмельницький' LIMIT 1),
  'Косметолог: чистка обличчя, пілінг, масаж',
  'Медична освіта, сертифікати, стерильність та одноразові матеріали, запис онлайн.',
  900.00, NOW(), 'ACTIVE'  -- ціна за процедуру
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);

-- 17) Софія Ткач — Взуття — Чернівці
INSERT INTO listings (user_id, category, city_id, title, description, price, created_at, status)
VALUES (
  (SELECT id FROM user WHERE email = 'sofia.tkach@gmail.com' LIMIT 1),
  ('FASHION'),
  (SELECT id FROM city WHERE name = 'Чернівці' LIMIT 1),
  'Черевики шкіряні, чоловічі, розмір 43',
  'Натуральна шкіра, тепла підкладка, антиковзка підошва, майже нові.',
  1900.00, NOW(), 'ACTIVE'
);
SET @listing_id := LAST_INSERT_ID();
INSERT INTO images (path, listing_id) VALUES
  (CONCAT('resources/images/listings/', @listing_id, '/image1'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image2'), @listing_id),
  (CONCAT('resources/images/listings/', @listing_id, '/image3'), @listing_id);


INSERT INTO favorite (user_id, listing_id) VALUES
-- 1) Ivan Petrenko favorites listings not his own (Olena + Andriy)
((SELECT id FROM user WHERE email = 'ivan.petrenko@gmail.com' LIMIT 1),
 (SELECT l.id FROM listings l JOIN user u ON l.user_id = u.id WHERE u.email = 'olena.shevchenko@yahoo.com' LIMIT 1)),
((SELECT id FROM user WHERE email = 'ivan.petrenko@gmail.com' LIMIT 1),
 (SELECT l.id FROM listings l JOIN user u ON l.user_id = u.id WHERE u.email = 'andriy.koval@ukr.net' LIMIT 1)),

-- 2) Olena Shevchenko favorites one listing (Serhii)
((SELECT id FROM user WHERE email = 'olena.shevchenko@yahoo.com' LIMIT 1),
 (SELECT l.id FROM listings l JOIN user u ON l.user_id = u.id WHERE u.email = 'serhii.kravets@meta.ua' LIMIT 1)),

-- 3) Andriy Koval favorites one listing (Maria)
((SELECT id FROM user WHERE email = 'andriy.koval@ukr.net' LIMIT 1),
 (SELECT l.id FROM listings l JOIN user u ON l.user_id = u.id WHERE u.email = 'maria.bondar@gmail.com' LIMIT 1)),

-- 4) Maria Bondar favorites one listing (Oleh)
((SELECT id FROM user WHERE email = 'maria.bondar@gmail.com' LIMIT 1),
 (SELECT l.id FROM listings l JOIN user u ON l.user_id = u.id WHERE u.email = 'oleh.danchenko@icloud.com' LIMIT 1)),

-- 5) Serhii Kravets favorites multiple (Iryna + Kateryna)
((SELECT id FROM user WHERE email = 'serhii.kravets@meta.ua' LIMIT 1),
 (SELECT l.id FROM listings l JOIN user u ON l.user_id = u.id WHERE u.email = 'iryna.romanova@gmail.com' LIMIT 1)),
((SELECT id FROM user WHERE email = 'serhii.kravets@meta.ua' LIMIT 1),
 (SELECT l.id FROM listings l JOIN user u ON l.user_id = u.id WHERE u.email = 'kateryna.melnyk@gmail.com' LIMIT 1)),

-- 6) Kateryna Melnyk favorites one listing (Sofiia)
((SELECT id FROM user WHERE email = 'kateryna.melnyk@gmail.com' LIMIT 1),
 (SELECT l.id FROM listings l JOIN user u ON l.user_id = u.id WHERE u.email = 'sofia.tkach@gmail.com' LIMIT 1)),

-- 7) Maksym Holub favorites one listing (Ivan)
((SELECT id FROM user WHERE email = 'maksym.holub@ukr.net' LIMIT 1),
 (SELECT l.id FROM listings l JOIN user u ON l.user_id = u.id WHERE u.email = 'ivan.petrenko@gmail.com' LIMIT 1)),

-- 8) Sofiia Tkach favorites one listing (Maria)
((SELECT id FROM user WHERE email = 'sofia.tkach@gmail.com' LIMIT 1),
 (SELECT l.id FROM listings l JOIN user u ON l.user_id = u.id WHERE u.email = 'maria.bondar@gmail.com' LIMIT 1));
