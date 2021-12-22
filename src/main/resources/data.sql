-- Authorities

-- Authority Authorities
insert into authority(authority_id, permission) values ('67cdcff0-f180-421a-bd5f-69cbc62f3cfe', 'authority.create');
insert into authority(authority_id, permission) values ('f06cc9be-0c37-4dac-8d36-941e7dd03e95', 'authority.read');
insert into authority(authority_id, permission) values ('1fba12c8-da0d-4d15-be62-5cdcc0d40240', 'authority.update');
insert into authority(authority_id, permission) values ('4a12573c-288f-4218-9a1f-8effcd2b8637', 'authority.delete');

-- Role Authorities
insert into authority(authority_id, permission) values ('866d7126-8281-42c6-a02d-3087b0bb1cab', 'role.create');
insert into authority(authority_id, permission) values ('14e8773c-6649-4c21-9c3c-39a94017ee15', 'role.read');
insert into authority(authority_id, permission) values ('4cf0bfda-d703-4ce0-a3ab-298d5d0fd5be', 'role.update');
insert into authority(authority_id, permission) values ('baf01a6a-de78-4c2d-8ee8-28401cb5225b', 'role.delete');

-- User Authorities
insert into authority(authority_id, permission) values ('598ea376-0c17-474a-a0a7-cd26ce2c5754', 'user.create');
insert into authority(authority_id, permission) values ('9be33d52-605e-4d29-92e2-3209c1b8b79d', 'user.read');
insert into authority(authority_id, permission) values ('a0f3679a-ef3d-4175-a792-bc2376e11d08', 'user.update');
insert into authority(authority_id, permission) values ('dd14ff93-294a-469e-86e0-97289df45bb6', 'user.delete');

-- Customer Authorities
insert into authority(authority_id, permission) values ('13b929e6-4bb6-4c8f-91a9-87d95147e535', 'customer.create');
insert into authority(authority_id, permission) values ('724bb09a-d245-43d8-935a-4254486ccbe4', 'customer.read');
insert into authority(authority_id, permission) values ('638c291d-defd-4624-b2ed-a1fdddf88934', 'customer.update');
insert into authority(authority_id, permission) values ('256cdc38-c673-42bb-90e4-7ef3e3078da1', 'customer.delete');

-- Profile Authorities
insert into authority(authority_id, permission) values ('058eeba5-05c6-40fd-9b3f-7903444e88ff', 'profile.create');
insert into authority(authority_id, permission) values ('4d22c02e-2a3a-475f-b704-e0d050bf6b3f', 'profile.read');
insert into authority(authority_id, permission) values ('9daae2e3-7df5-4227-ba04-9e8019d7d72e', 'profile.update');
insert into authority(authority_id, permission) values ('e3ff971e-d0dc-4578-9b87-5e060eb97e0e', 'profile.delete');

-- Product Authorities
insert into authority(authority_id, permission) values ('5bcf68ef-c644-4ab6-90d1-018d2b2d1a14', 'product.create');
insert into authority(authority_id, permission) values ('0e4fa0be-0121-41fa-8a3b-70092588a25e', 'product.read');
insert into authority(authority_id, permission) values ('25d73f01-1fa6-45d7-8aa2-d04339beaaa0', 'product.update');
insert into authority(authority_id, permission) values ('a0dc98c1-113c-47e1-aad8-08577e7fc544', 'product.delete');

-------------------------------------------------------------------------------------------------------------------

-- Roles
insert into role(role_id, role_name) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', 'ADMIN');
insert into role(role_id, role_name) values ('d1167316-e298-4d72-8dfe-8e7e2eab5d77', 'CUSTOMER_SERVICE_AGENT');
insert into role(role_id, role_name) values ('e2cdda23-16ae-4dac-a3c8-6f34feb370ca', 'CUSTOMER');

-- Role Authority Relationship
----------------------------Authority entity------------------------
-- Admin Role
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '67cdcff0-f180-421a-bd5f-69cbc62f3cfe');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', 'f06cc9be-0c37-4dac-8d36-941e7dd03e95');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '1fba12c8-da0d-4d15-be62-5cdcc0d40240');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '4a12573c-288f-4218-9a1f-8effcd2b8637');

----------------------------Role entity-----------------------------
-- Admin Role
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '866d7126-8281-42c6-a02d-3087b0bb1cab');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '14e8773c-6649-4c21-9c3c-39a94017ee15');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '4cf0bfda-d703-4ce0-a3ab-298d5d0fd5be');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', 'baf01a6a-de78-4c2d-8ee8-28401cb5225b');

-----------------------------User Entity----------------------------
-- Admin Role
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '598ea376-0c17-474a-a0a7-cd26ce2c5754');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '9be33d52-605e-4d29-92e2-3209c1b8b79d');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', 'a0f3679a-ef3d-4175-a792-bc2376e11d08');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', 'dd14ff93-294a-469e-86e0-97289df45bb6');

------------------------------Customer Entity-----------------------
-- Admin Role
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '13b929e6-4bb6-4c8f-91a9-87d95147e535');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '724bb09a-d245-43d8-935a-4254486ccbe4');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '638c291d-defd-4624-b2ed-a1fdddf88934');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '256cdc38-c673-42bb-90e4-7ef3e3078da1');

-- Customer Role
insert into role_authority(role_id, authority_id) values ('e2cdda23-16ae-4dac-a3c8-6f34feb370ca', '13b929e6-4bb6-4c8f-91a9-87d95147e535');
insert into role_authority(role_id, authority_id) values ('e2cdda23-16ae-4dac-a3c8-6f34feb370ca', '724bb09a-d245-43d8-935a-4254486ccbe4');
insert into role_authority(role_id, authority_id) values ('e2cdda23-16ae-4dac-a3c8-6f34feb370ca', '638c291d-defd-4624-b2ed-a1fdddf88934');
insert into role_authority(role_id, authority_id) values ('e2cdda23-16ae-4dac-a3c8-6f34feb370ca', '256cdc38-c673-42bb-90e4-7ef3e3078da1');

-- Customer Service Agent Role
insert into role_authority(role_id, authority_id) values ('d1167316-e298-4d72-8dfe-8e7e2eab5d77', '724bb09a-d245-43d8-935a-4254486ccbe4');
insert into role_authority(role_id, authority_id) values ('d1167316-e298-4d72-8dfe-8e7e2eab5d77', '638c291d-defd-4624-b2ed-a1fdddf88934');

------------------------------Profile Entity-----------------------
-- Admin Role
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '058eeba5-05c6-40fd-9b3f-7903444e88ff');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '4d22c02e-2a3a-475f-b704-e0d050bf6b3f');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '9daae2e3-7df5-4227-ba04-9e8019d7d72e');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', 'e3ff971e-d0dc-4578-9b87-5e060eb97e0e');

-- Customer Role
insert into role_authority(role_id, authority_id) values ('e2cdda23-16ae-4dac-a3c8-6f34feb370ca', '058eeba5-05c6-40fd-9b3f-7903444e88ff');
insert into role_authority(role_id, authority_id) values ('e2cdda23-16ae-4dac-a3c8-6f34feb370ca', '4d22c02e-2a3a-475f-b704-e0d050bf6b3f');
insert into role_authority(role_id, authority_id) values ('e2cdda23-16ae-4dac-a3c8-6f34feb370ca', '9daae2e3-7df5-4227-ba04-9e8019d7d72e');
insert into role_authority(role_id, authority_id) values ('e2cdda23-16ae-4dac-a3c8-6f34feb370ca', 'e3ff971e-d0dc-4578-9b87-5e060eb97e0e');

-- Customer Service Agent Role
insert into role_authority(role_id, authority_id) values ('d1167316-e298-4d72-8dfe-8e7e2eab5d77', '4d22c02e-2a3a-475f-b704-e0d050bf6b3f');


------------------------------Product Entity-----------------------
-- Admin Role
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '5bcf68ef-c644-4ab6-90d1-018d2b2d1a14');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '0e4fa0be-0121-41fa-8a3b-70092588a25e');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', '25d73f01-1fa6-45d7-8aa2-d04339beaaa0');
insert into role_authority(role_id, authority_id) values ('adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94', 'a0dc98c1-113c-47e1-aad8-08577e7fc544');

-- Customer Role
insert into role_authority(role_id, authority_id) values ('e2cdda23-16ae-4dac-a3c8-6f34feb370ca', '0e4fa0be-0121-41fa-8a3b-70092588a25e');

-- Customer Service Agent Role
insert into role_authority(role_id, authority_id) values ('d1167316-e298-4d72-8dfe-8e7e2eab5d77', '0e4fa0be-0121-41fa-8a3b-70092588a25e');
insert into role_authority(role_id, authority_id) values ('d1167316-e298-4d72-8dfe-8e7e2eab5d77', '25d73f01-1fa6-45d7-8aa2-d04339beaaa0');

-----------------------------------------------------------------------------------------------------------------------
-- Users
insert into security_user(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled) values ('f45baba7-a5c8-4578-84ef-82091dc93761', 'john','{bcrypt}$2a$10$ARBKYjDx6CZF/mbr9.Yi.OYNzhj64vovplcuthbS5CuinOw6sMiG.', true, true, true, true);
insert into security_user(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled) values ('511f1667-5b0f-4cee-9581-ee1a19b01ef1', 'mary','{bcrypt}$2a$10$dTBDKWJ47D2d/2EczMxbo.VYQJyVbPTblsrbObSAqtGjCqIN9W1Om', true, true, true, true);
insert into security_user(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled) values ('adcc0e68-b371-467e-904e-d66f06c00db4', 'balaji','{bcrypt}$2a$10$JJxhO7zQV9Htf7ycXvIx9uLvN1H/Piav5KHcbAU7mTTjHDSzNep6q', true, true, true, true);

--- User Role Relationship
insert into user_role (user_id, role_id) values ('f45baba7-a5c8-4578-84ef-82091dc93761', 'adb309a8-6a2b-49fd-9ef0-9ae6f04c6a94');
insert into user_role (user_id, role_id) values ('511f1667-5b0f-4cee-9581-ee1a19b01ef1', 'd1167316-e298-4d72-8dfe-8e7e2eab5d77');
insert into user_role (user_id, role_id) values ('adcc0e68-b371-467e-904e-d66f06c00db4', 'e2cdda23-16ae-4dac-a3c8-6f34feb370ca');

-----------------------------------------------------------------------------------------------------------------------
-- Customers
insert into customer(customer_id, first_name, last_name, date_of_birth, gender, marital_status user_id) values ('a7b4e7dc-15a6-4738-864e-8de92f4acd4f', 'balaji', 'varadharajan', '1983-05-21', 'MALE', 'MARRIED' 'adcc0e68-b371-467e-904e-d66f06c00db4');

-- Profiles
insert into profile(profile_id, payment_method, favorite_vacation, customer_id) values ('5bb93f24-c7c7-43c3-ad05-7892c3a7a357', 'PayPal', 'California', 'a7b4e7dc-15a6-4738-864e-8de92f4acd4f');

