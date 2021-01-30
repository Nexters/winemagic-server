insert into wine (nm_kor, nm_eng, country, price, ingredient, category, usage, degree, store, suit_temper, sweetness, acidity, body, tannin,suit_food)
values ('쁘띠폴리', 'Petites Folies', '프랑스', 18000, '멜롯 60%, 까베네 소비뇽 40%', '레드와인', '테이블 와인', 13.5, '이마트 24', '16-18', 1, 3, 3, 3, '찹스테이크, 양고기');
insert into wine (nm_kor, nm_eng, country, price, ingredient, category, usage, degree, store, suit_temper, sweetness, acidity, body, tannin,suit_food)
values ('쁘띠폴리', 'Petites Folies', '프랑스', 18000, '멜롯 60%, 까베네 소비뇽 40%', '레드와인', '테이블 와인', 13.5, '이마트 24', '16-18', 1, 3, 3, 3, '찹스테이크, 양고기');


insert into user (email, age_range, gender) values ('6230nana', 20, 'FEMALE');
insert into user (email, age_range, gender) values ('eunhwan', 20, 'MALE');


insert into likes(user_id, wine_id, use_yn) values (1, 1, 'Y');
insert into likes(user_id, wine_id, use_yn) values (1, 2, 'N');

insert into likes(user_id, wine_id, use_yn) values (2, 1, 'Y');