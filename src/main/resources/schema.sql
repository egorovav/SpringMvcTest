create table genre (
id int auto_increment
, name varchar(20)
, primary key (id)
);

create table author (
id int auto_increment
, first_name varchar(20)
, last_name varchar(20)
, primary key (id)
);

create table book (
id int auto_increment
, title varchar(40)
, author_id int not null
, genre_id int not null
, primary key (id)
, constraint fk_book_author foreign key (author_id) references author (id)
, constraint fk_book_genre foreign key (genre_id) references genre (id)
);
