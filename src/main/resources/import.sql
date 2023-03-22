INSERT INTO models (model_id, model_name) VALUES ('1', 'Limousine');
INSERT INTO models (model_id, model_name) VALUES ('2', 'Jeep/SUV');

INSERT INTO roles (role_id, role_name) VALUES ('1', 'Admin');
INSERT INTO roles (role_id, role_name) VALUES ('2', 'User');

INSERT INTO users (user_id, user_contact_number, user_name) VALUES ('1', '0612233621', 'John');
INSERT INTO users (user_id, user_contact_number, user_name) VALUES ('2', '0612233622', 'Steve');

INSERT INTO user_roles (user_id, role_id) VALUES ('1', '2');
INSERT INTO user_roles (user_id, role_id) VALUES ('2', '1');


INSERT INTO vehicles (vehicle_id, vehicle_brand_name, vehicle_rent_amount, model_id) VALUES ('1', 'Mercedes', '300', '1');
INSERT INTO vehicles (vehicle_id, vehicle_brand_name, vehicle_rent_amount, model_id) VALUES ('2', 'Peugeot', '200', '1');

INSERT INTO contracts (contract_id, amount, contract_user_id, contract_vehicle_id) VALUES ('1', '300', '1', '1');


