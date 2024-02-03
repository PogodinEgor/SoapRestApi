package ru.pogodin.soap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pogodin.soap.models.Doctor;


@Repository
public interface DoctorsRepository extends JpaRepository<Doctor,Long> {
}
