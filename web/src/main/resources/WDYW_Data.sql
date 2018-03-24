
alter table `Category` modify column `categoryAllegroLink` longtext CHARACTER SET utf8 COLLATE utf8mb4_unicode_ci NULL;
alter table `Category` modify column `categoryName` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL;

alter table `Question` modify column `questionName` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL;

alter table `Answer` modify column `answerName` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL;

alter table `users` modify column `login` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL;
alter table `users` modify column `name` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL;
alter table `users` modify column `surname` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL;
alter table `users` modify column `email` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL;

alter table `roles` modify column `user_login` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL;

INSERT INTO `Category`(categoryId, categoryAllegroLink, categoryName) VALUES (9, 'https://allegro.pl/dzial/elektronika', 'Elektronika'), (10, 'https://allegro.pl/kategoria/sport-i-turystyka', 'Sport i turystyka'), (11, 'https://allegro.pl/dzial/dom-i-zdrowie', 'Dom i zdrowie'), (12, 'https://allegro.pl/kategoria/tv-i-video-telewizory-5120?order=m', 'Telewizory'), (13, 'https://allegro.pl/kategoria/komputery?order=m', 'Komputery'), (14, 'https://allegro.pl/kategoria/sprzet-audio-dla-domu-11?order=m', 'Sprzęt audio'),  (15, 'https://allegro.pl/kategoria/bieganie-147262?order=m', 'Bieganie'),  (16, 'https://allegro.pl/kategoria/rowery-i-akcesoria-16414?order=m', 'Rowery'),(17, 'https://allegro.pl/kategoria/silownia-i-fitness-19626?order=m', 'Siłownia i fitness'),(18, 'https://allegro.pl/kategoria/ogrod-1532?order=m', 'Ogród'),(19, 'https://allegro.pl/kategoria/narzedzia-1536?order=m', 'Narzędzia'),(20, 'https://allegro.pl/kategoria/utrzymanie-czystosci-253343?order=m', 'Utrzymanie czystości'),(21, 'https://allegro.pl/kategoria/rowery-mtb-gorskie-16483?order=m', 'Rowery górskie'),(22, 'https://allegro.pl/kategoria/rowery-szosowe-16484?order=m', 'Rowery szosowe'),(23, 'https://allegro.pl/kategoria/rowery-crossowe-125055?order=m', 'Rowery crossowe'),(24, 'https://allegro.pl/kategoria/bieganie-obuwie-147264?order=m', 'Obuwie do biegania'),(25, 'https://allegro.pl/kategoria/bieganie-odziez-147265?order=m', 'Odzież do biegania'),(26, 'https://allegro.pl/kategoria/bieganie-odzywki-i-suplementy-147268?order=m','Odżywki i suplementy dla biegaczy'),(27, 'https://allegro.pl/kategoria/silownia-i-fitness-fitness-110132?order=m', 'Fitness'),(28, 'https://allegro.pl/kategoria/silownia-i-fitness-silownia-110145?order=m', 'Siłownia');

INSERT INTO `Question`(questionId, questionLevel, questionName) VALUES (1, 1, 'Jak lubisz spędzać wolny czas?'), (2, 2, 'Co najbardziej lubisz robić w domu?'), (3, 2, 'Jaki rodzaj aktywności jest dla ciebie najlepszy?'), (4, 2, 'Jakie prace domowe wykonujesz najczęściej?'), (5, 3, 'Jakie akcesoria/sprzęt do biegania jest dla Ciebie najważniejszy?'), (6, 3, 'Na jakim rowerze lubisz jeździć najbardziej?'), (7, 3, 'Jakie ćwiczenia  preferujesz?');

INSERT INTO `Answer`(answerId, answerName, relatedQuest_questionId, question_id, relatedCategory_categoryId) VALUES (4, 'W wolnym czasie chcę poprostu odpocząć i zostać w domu.', 2, 1, 9), (5, 'Lubię spędzać czas aktywnie.', 3, 1, 10), (6, 'Nie mam czasu wolnego, mam dużo obowiązków domowych.', 4, 1, 11), (10, 'Najbardziej lubię biegać.', 5, 3, 15), (11, 'Bardzo często jeżdżę na rowerze.', 6, 3, 16), (12, 'Lubię chodzić na siłownie.', 7, 3, 17), (80, 'Najbardziej lubię oglądać telewizję?', NULL, 2, 12), (81, 'Lubię grać w gry komputerowe.', NULL, 2, 13), (82, 'Lubię słuchać muzykę.', NULL, 2, 14), (100, 'Pracuję w ogrodzie.', NULL, 4, 18), (101, 'Naprawiam lub buduję coś nowego.', NULL, 4, 19),  (102, 'Sprzątam.', NULL, 4, 20), (103, 'Dobre buty.', NULL, 5, 24), (104, 'Odzież do biegania', NULL, 5, 25), (105, 'Odżywki/suplementy', NULL, 5, 26), (106, 'Na rowerze górskim.', NULL, 6, 21), (107, 'Na rowerze szosowym.', NULL, 6, 22), (108, 'Na rowerze turystycznym.', NULL, 6, 23), (109, 'Fitness', NULL, 7, 27), (110, 'Ćwiczenia siłowe', NULL, 7, 28);

INSERT INTO `roles`(id, user_login, user_role, role_group) VALUES (1, 'adminUser', 'admin', 'admin'), (2, 'monmar', 'admin', 'admin'), (3, 'guser', 'user', 'user');

INSERT INTO `users`(id, login, password, name, surname, email, userType) VALUES (1, 'adminUser', '0192023a7bbd73250516f069df18b500', NULL, NULL, 'admin@gmail.com', 'user'), (2, 'monmar', '82802dab4a1b2ef08bbc853ed484785e', NULL, NULL, 'monmar1104@gmail.com', 'user'),  (3, 'guser', 'f1ff8b071153bada470ad8511349011a', 'guser', 'guser', 'guser@email.pl', 'google');

INSERT INTO `DataPromo`(promoId, promotedCategory) VALUES (1, 2), (2, 10),  (3, 4);