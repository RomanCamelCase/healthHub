CREATE TABLE "users" (
                         "id" integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                         "email" varchar(100) UNIQUE NOT NULL,
                         "password" varchar(128) NOT NULL,
                         "is_banned" bool NOT NULL DEFAULT false,
                         "sex" int NOT NULL,
                         "first_name" varchar(30) NOT NULL,
                         "last_name" varchar(30) NOT NULL,
                         "birth_day" date NOT NULL,
                         "registration_date" date NOT NULL,
                         "last_time_online" timestamp NOT NULL
);
--rollback DROP TABLE users;