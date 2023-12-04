CREATE TABLE "doctors_specialisations" (
                                           "doctor_id" int REFERENCES doctors(user_id) ON DELETE CASCADE,
                                           "specialization_id" int REFERENCES specializations(id) ON DELETE CASCADE,
                                           PRIMARY KEY ("doctor_id", "specialization_id")
);