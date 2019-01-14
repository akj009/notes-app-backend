create table notes_app.notes (id bigint not null, content varchar(65535), time timestamp, title varchar(255), primary key (id));
INSERT INTO NOTES_APP.NOTES (id, title, content, time) VALUES(1, 'First note', 'this is my first note for the notes app', NOW());
INSERT INTO NOTES_APP.NOTES (id, title, content, time) VALUES(2, 'Another note', 'this is a test note', NOW());
INSERT INTO NOTES_APP.NOTES (id, title, content, time) VALUES(3, 'Yet another note', 'this is another test note', PARSEDATETIME('06-11-2018 03:05:06 GMT', 'dd-MM-yyyy HH:mm:ss z', 'en', 'GMT'));
insert into notes_app.notes (id, title, content, time) values (4, 'Gift Note', 'This gift is late in coming, but the excitement and the happiness for you both and Will has been there from day one.', NOW());