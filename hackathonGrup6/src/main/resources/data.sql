INSERT INTO users (id,name,first_surname,second_surname,email,gender,username)
VALUES ( '44e128a5ac7a4c9abe4c224b6bf81b30','albert','de corte','muñoz','adecorte@edu.tecnocampus.cat','male','adecorte' );
INSERT INTO users (id,name,first_surname,second_surname,email,gender,username)
VALUES ( '44e128a5ac7a4c9abe4c224b6bf81b31','shara','shar','bonet','ss@edu.tecnocampus.cat','female','sshar' );
INSERT INTO users (id,name,first_surname,second_surname,email,gender,username)
VALUES ( '44e128a5ac7a4c9abe4c224b6bf81b32','gonzalo','querol','garcia','gquerol@edu.tecnocampus.cat','male','gquerol' );
INSERT INTO users (id,name,first_surname,second_surname,email,gender,username)
VALUES ( '44e128a5ac7a4c9abe4c224b6bf81b33','nil','casane','torras','ncasane@tecnocampus.cat','male','ncasane' );
INSERT INTO users (id,name,first_surname,second_surname,email,gender,username)
VALUES ( '44e128a5ac7a4c9abe4c224b6bf81b34','jan','rubio','montes','jrubio@edu.tecnocampus.cat','male','jrubio' );


INSERT INTO events (id,title,description,imageURL, publication_date, last_update_date,
                     current_price, available, user_id, total_Duration)
VALUES ('44e128a5ac7a4c9abe4c224b6bf81b20','Yoga','Yoga acuatico', 'https://www.turismemaresme.cat/es/que-hacer/actividades/?categoria%5B%5D=N%C3%A0utic&subcategoria%5B%5D=Paddle+surf&subcategoria%5B%5D=Surf&subcategoria%5B%5D=Windsurf',
        current_date(),current_date(), 35, false,
        '44e128a5ac7a4c9abe4c224b6bf81b31' , 1);
INSERT INTO events (id,title,description,imageURL, publication_date, last_update_date,
                     current_price, available, user_id, total_Duration)
VALUES ('44e128a5ac7a4c9abe4c224b6bf81b21','Cayac','Cayac', 'https://www.turismemaresme.cat/es/que-hacer/actividades/?categoria%5B%5D=N%C3%A0utic&subcategoria%5B%5D=Caiac&subcategoria%5B%5D=Rem',
        current_date(),current_date(), 40, false,
        '44e128a5ac7a4c9abe4c224b6bf81b34',2);
INSERT INTO events (id,title,description,imageURL, publication_date, last_update_date,
                     current_price, available,  user_id, total_Duration)
VALUES ('44e128a5ac7a4c9abe4c224b6bf81b22','Surf','Surf', 'https://www.turismemaresme.cat/es/que-hacer/actividades/?categoria%5B%5D=N%C3%A0utic&subcategoria%5B%5D=Paddle+surf&subcategoria%5B%5D=Surf&subcategoria%5B%5D=Windsurf',
        current_date(),current_date(), 60, true,
        '44e128a5ac7a4c9abe4c224b6bf81b33',1);
INSERT INTO events (id,title,description,imageURL, publication_date, last_update_date,
                     current_price, available, user_id, total_Duration)
VALUES ('44e128a5ac7a4c9abe4c224b6bf81b23','NV','Navegació a vela', 'HTTPS:/google.com.image/1976',
        current_date(),current_date(), 120, true,
        '44e128a5ac7a4c9abe4c224b6bf81b32',3);
INSERT INTO events (id,title,description,imageURL, publication_date, last_update_date,
                     current_price, available, user_id, total_Duration)
VALUES ('44e128a5ac7a4c9abe4c224b6bf81b24','Subm','Submarinisme', 'HTTPS:/google.com.image/',
        current_date(),current_date(), 3000, false,
        '44e128a5ac7a4c9abe4c224b6bf81b33', 2);

INSERT INTO role(name) VALUES ('ROLE_USER');
INSERT INTO role(name) VALUES ('ROLE_ORGANIZER');
INSERT INTO role(name) VALUES ('ROLE_ADMIN');

INSERT INTO user_security (id,email, username, password) VALUES
    ('44e128a5ac7a4c9abe4c224b6bf81b34','josep@tecnocampus.cat', 'josep',
     '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2');
INSERT INTO user_security (id,email, username, password) VALUES
    ('44e128a5ac7a4c9abe4c224b6bf81b30','adecorte@edu.tecnocampus.cat', 'Albert',
     '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2');
INSERT INTO user_security (id,email, username, password) VALUES
    ('44e128a5ac7a4c9abe4c224b6bf81b31','ssanchiz@edu.tecnocampus.cat', 'Silvia',
     '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2');
INSERT INTO user_security (id,email, username, password) VALUES
    ('44e128a5ac7a4c9abe4c224b6bf81b33','admin@tecnocampus.cat', 'admin',
     '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2');
INSERT INTO user_security (id,email, username, password) VALUES
    ('44e128a5ac7a4c9abe4c224b6bf81b35','def@edu.tecnocampus.cat', 'D',
     '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2');
INSERT INTO user_security (id,email, username, password) VALUES
    ('44e128a5ac7a4c9abe4c224b6bf81b36','ghi@edu.tecnocampus.cat', 'G',
     '$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2');

INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES ('44e128a5ac7a4c9abe4c224b6bf81b34', 3);
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES ('44e128a5ac7a4c9abe4c224b6bf81b30', 1);
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES ('44e128a5ac7a4c9abe4c224b6bf81b31', 2);
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES ('44e128a5ac7a4c9abe4c224b6bf81b33', 2);

INSERT INTO reviews (id, events_id, user_id, title, content, satisfaction, review_date)
VALUES ('1', '44e128a5ac7a4c9abe4c224b6bf81b20', '44e128a5ac7a4c9abe4c224b6bf81b30',
        'Diseño de base de datos', 'Hola', 4, '2023-12-01');
INSERT INTO reviews (id, events_id, user_id, title, content, satisfaction, review_date)
VALUES ('2', '44e128a5ac7a4c9abe4c224b6bf81b21', '44e128a5ac7a4c9abe4c224b6bf81b30',
        'Sistema gestor de base de datos', 'Que', 5, '2023-12-02');
INSERT INTO reviews (id, events_id, user_id, title, content, satisfaction, review_date)
VALUES ('3', '44e128a5ac7a4c9abe4c224b6bf81b22', '44e128a5ac7a4c9abe4c224b6bf81b30',
        'Matemàtica discreta', 'tal', 3, '2023-12-03');
INSERT INTO reviews (id, events_id, user_id, title, content, satisfaction, review_date)
VALUES ('4', '44e128a5ac7a4c9abe4c224b6bf81b23', '44e128a5ac7a4c9abe4c224b6bf81b31',
        'Enginyeria del software', '?', 2, '2023-12-04');
INSERT INTO reviews (id, events_id, user_id, title, content, satisfaction, review_date)
VALUES ('5', '44e128a5ac7a4c9abe4c224b6bf81b24', '44e128a5ac7a4c9abe4c224b6bf81b31',
        'Enginyeria del software 2', 'Molt Be', 5, '2023-12-05');

INSERT INTO location (id, name, street, email)
VALUES ( '44e128a5ac7a4c9abe4c224b6bf81b50','El Barco','carrer del port 6','elbarco@gmail.com');
INSERT INTO location (id,name,street,email)
VALUES ( '44e128a5ac7a4c9abe4c224b6bf81b53','El nen viatger','carrer del port 9','elnenviatger@gmail.com' );
INSERT INTO location (id,name,street,email)
VALUES ( '44e128a5ac7a4c9abe4c224b6bf81b54','El Bote','carrer del port 10','elbote@gmail.com' );



