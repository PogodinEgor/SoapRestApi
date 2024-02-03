package ru.pogodin.soap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.pogodin.soap.models.Ticket;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Long> {
    // 2.3.1 Получение свободных слотов времени к указанному врачу на указанную дату
    @Query("SELECT t FROM Ticket t WHERE t.doctor.id = :doctorId AND t.date = :date AND t.patient IS NULL")
    List<Ticket> findAvailableSlotsByDoctorAndDate(@Param("doctorId") Long doctorId, @Param("date") LocalDate date);


    // 2.3.3 Получение всех слотов времени, занятых одним пациентом по id
    @Query("SELECT t FROM Ticket t WHERE t.patient.id = :patientId")
    List<Ticket> findAllTicketsByPatientId(@Param("patientId") Long patientId);
}
