CREATE TABLE "specializations" (
                                   "id" int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                                   "title" varchar UNIQUE NOT NULL,
                                   "description" varchar
);
