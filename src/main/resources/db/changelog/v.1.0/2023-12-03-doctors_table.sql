CREATE TABLE "doctors" (
                           "user_id" int PRIMARY KEY NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                           "is_active" bool NOT NULL ,
                           "is_approved" bool NOT NULL,
                           "work_experience" date NOT NULL,
                           "work_with" int NOT NULL,
                           "description" varchar,
                           "city" varchar NOT NULL,
                           "address" varchar NOT NULL,
                           "google_maps_link" varchar,
                           "contact_number" bigint NOT NULL UNIQUE
);