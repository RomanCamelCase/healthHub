ALTER TABLE users RENAME COLUMN sex TO gender;
ALTER TABLE users ALTER COLUMN gender TYPE smallint;