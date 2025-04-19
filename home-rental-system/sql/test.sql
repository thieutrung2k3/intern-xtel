-- DELETE TEST ACCOUNT
DELETE
FROM account
WHERE email = 't.hieutrung2k3@gmail.com';

DELETE
FROM account
WHERE email = 'whyiam200@gmail.com';

CREATE TABLE invalidated_token
(
    id          VARCHAR(255) PRIMARY KEY,
    expiry_time TIMESTAMP
);