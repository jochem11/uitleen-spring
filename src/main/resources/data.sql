INSERT INTO category (id, name) VALUES (1, 'Fruit');
INSERT INTO category (id, name) VALUES (2, 'Groente');
INSERT INTO category (id, name) VALUES (3, 'Vlees');
INSERT INTO category (id, name) VALUES (4, 'Vis');

INSERT INTO item_status (id, name) VALUES (1, 'AVAILABLE');
INSERT INTO item_status (id, name) VALUES (2, 'SOLD');
INSERT INTO item_status (id, name) VALUES (3, 'RESERVED');

INSERT INTO item (id, name, description, category_id, item_status_id) VALUES (1, 'Appel', 'hoi', 1, 1);
INSERT INTO item (id, name, description, category_id, item_status_id) VALUES (2, 'Banaan', 'hoi2', 1, 2);
INSERT INTO item (id, name, description, category_id, item_status_id) VALUES (3, 'Komkommer', 'hoi3', 2, 1);
INSERT INTO item (id, name, description, category_id, item_status_id) VALUES (4, 'Wortel', 'hoi4', 2, 1);
INSERT INTO item (id, name, description, category_id, item_status_id) VALUES (5, 'Kip', 'hoi5', 3, 3);
INSERT INTO item (id, name, description, category_id, item_status_id) VALUES (6, 'Rund', 'hoi6', 3, 1);
INSERT INTO item (id, name, description, category_id, item_status_id) VALUES (7, 'Zalm', 'hoi7', 4, 2);
INSERT INTO item (id, name, description, category_id, item_status_id) VALUES (8, 'Tonijn', 'hoi8', 4, 1);
