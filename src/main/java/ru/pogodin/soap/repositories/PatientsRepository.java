package ru.pogodin.soap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pogodin.soap.models.Patient;


@Repository
public interface PatientsRepository extends JpaRepository<Patient, Long> {
}
