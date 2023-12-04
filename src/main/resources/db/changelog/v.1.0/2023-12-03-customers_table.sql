CREATE TABLE "customers" (
                             "user_id" int PRIMARY KEY NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                             "profile_picture" varchar
);