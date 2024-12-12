INSERT INTO category (name) VALUES ('Fruit');
INSERT INTO category (name) VALUES ('Groente');
INSERT INTO category (name) VALUES ('Vlees');
INSERT INTO category (name) VALUES ('Vis');

INSERT INTO item_status (name) VALUES ( 'AVAILABLE');
INSERT INTO item_status (name) VALUES ( 'SOLD');
INSERT INTO item_status (name) VALUES ('RESERVED');

INSERT INTO item (name, description, category_id, item_status_id) VALUES ('Appel', 'hoi', 1, 1);
INSERT INTO item (name, description, category_id, item_status_id) VALUES ('Banaan', 'hoi2', 1, 2);
INSERT INTO item (name, description, category_id, item_status_id) VALUES ('Komkommer', 'hoi3', 2, 1);
INSERT INTO item (name, description, category_id, item_status_id) VALUES ('Wortel', 'hoi4', 2, 1);
INSERT INTO item (name, description, category_id, item_status_id) VALUES ('Kip', 'hoi5', 3, 3);
INSERT INTO item (name, description, category_id, item_status_id) VALUES ('Rund', 'hoi6', 3, 1);
INSERT INTO item (name, description, category_id, item_status_id) VALUES ('Zalm', 'hoi7', 4, 2);
INSERT INTO item (name, description, category_id, item_status_id) VALUES ('Tonijn', 'hoi8', 4, 1);

