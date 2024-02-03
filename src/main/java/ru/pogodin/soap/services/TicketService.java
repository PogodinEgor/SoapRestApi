package ru.pogodin.soap.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.pogodin.soap.models.Doctor;
import ru.pogodin.soap.models.Patient;
import ru.pogodin.soap.models.Ticket;
import ru.pogodin.soap.repositories.DoctorsRepository;
import ru.pogodin.soap.repositories.PatientsRepository;
import ru.pogodin.soap.repositories.TicketsRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
public class TicketService {
    private final TicketsRepository ticketsRepository;
    private final DoctorsRepository doctorsRepository;
    private final PatientsRepository patientsRepository;


    @Autowired
    public TicketService(TicketsRepository ticketsRepository, DoctorsRepository doctorRepository, PatientsRepository patientsRepository) {
        this.ticketsRepository = ticketsRepository;
        this.doctorsRepository = doctorRepository;

        this.patientsRepository = patientsRepository;
    }

    public List<Ticket> findAvailableSlotsByDoctorAndDate(Long doctorId, LocalDate localDate) {
        return ticketsRepository.findAvailableSlotsByDoctorAndDate(doctorId, localDate);

    }

    @Transactional
    public Ticket registerPatientTicket(Long ticketId, Long patientId) {
        Ticket ticket = ticketsRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found with id: " + ticketId));

        if (ticket.getPatient() != null) {
            throw new IllegalStateException("Ticket is already occupied");
        }

        Patient patient = patientsRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        ticket.setPatient(patient);
        return ticketsRepository.save(ticket);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleIllegalStateException(IllegalStateException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


    public List<Ticket> findAllTicketsByPatientId(Long patientId) {
        return ticketsRepository.findAllTicketsByPatientId(patientId);
    }

    @Transactional
    public void createScheduleRequest(Long doctorId, LocalDate date, LocalTime startTime, int duration, int quantity) {
        Doctor doctor = doctorsRepository.findById(doctorId).get();
        LocalTime time = startTime;
        for (int i = 0; i < quantity; i++) {
            Ticket ticket = new Ticket();
            ticket.setDoctor(doctor);
            ticket.setDate(date);
            ticket.setStartTime(time);
            ticket.setEndTime(time.plusMinutes(duration));

            ticketsRepository.save(ticket);
            time = time.plusMinutes(duration);
        }
    }

}