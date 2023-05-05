use zing_play;
CREATE table author(
	id_author int not null auto_increment,
    name text ,
    information text,
    PRIMARY KEY(id_author)
);
CREATE table user(
	id_user int not null auto_increment,
    name text,
    age int,
    sex text,
    id_category int,
    username text,
    password text,
    avatar text,
    primary key(id_user)
);
CREATE table category(
	id_category int not null auto_increment,
    name text,
    description text,
    primary key(id_category)
);
CREATE table rank_music(
	id_music int not null auto_increment,
    primary key(id_music),
    amount_add int
);
CREATE table song_play(
	id_music int not null ,
    id_author int,
    id_category int ,
    name text,
    file_music text
);

ALTER TABLE song_play
ADD CONSTRAINT fk_songplay_author FOREIGN KEY (id_author)
REFERENCES author(id_author);

ALTER TABLE song_play
ADD CONSTRAINT fk_songplay_category FOREIGN KEY (id_category)
REFERENCES category(id_category);

ALTER TABLE song_play
ADD CONSTRAINT fk_songplay_rank FOREIGN KEY (id_music)
REFERENCES rank_music(id_music);

CREATE table vote_music(
	id_vote int not null auto_increment,
    primary key(id_vote),
    id_user int,
    id_music int,
    vote int,
    CONSTRAINT fk_votemusic_songplay FOREIGN KEY (id_music)
    REFERENCES song_play(id_music),
    CONSTRAINT fk_votemusic_user FOREIGN KEY (id_user)
    REFERENCES user(id_user)
);

