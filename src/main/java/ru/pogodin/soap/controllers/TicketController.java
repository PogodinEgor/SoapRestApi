package ru.pogodin.soap.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pogodin.soap.exception.DoctorNotFoundException;
import ru.pogodin.soap.exception.PatientNotFoundException;
import ru.pogodin.soap.exception.TicketNotFountException;
import ru.pogodin.soap.models.Ticket;
import ru.pogodin.soap.services.DoctorService;
import ru.pogodin.soap.services.PatientService;
import ru.pogodin.soap.services.TicketService;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/ticket")
@Tag(name = "Контролер получения и бронирования свободных талонов к врачам.",
description = "Получение свободных талонов, занятие талона к врачу")
public class TicketController {

    private final TicketService ticketService;
    private final DoctorService doctorService;
    private final PatientService patienService;

    @Autowired
    public TicketController(TicketService ticketService, DoctorService doctorService, PatientService patienService) {
        this.ticketService = ticketService;
        this.doctorService = doctorService;
        this.patienService = patienService;
    }

    // Получение свободных слотов по ID врача и дате
    @Operation(summary = "Получение свободных слотов по ID врача и дате.",
    description = "Метод принимает в себя id-доктора и  дату. Возвращает список свободных талонов.")
    @GetMapping("/available")
    public ResponseEntity<List<Ticket>> findAvailableSlotsByDoctorAndDate(
            @RequestParam Long doctorId,
            @RequestParam LocalDate date) {
        if (doctorService.findById(doctorId).isEmpty()) {
            try {
                throw new DoctorNotFoundException("Doctor with ID: " + doctorId + " not found");
            } catch (DoctorNotFoundException e) {
                log.info(e.getMessage());
                throw new RuntimeException(e);
            }
        }
        List<Ticket> tickets = ticketService.findAvailableSlotsByDoctorAndDate(doctorId, date);
        if (tickets.isEmpty()) {
            try {
                throw new TicketNotFountException("No tickets available, please check the correctness of the input data.");
            } catch (TicketNotFountException e) {
                log.info(e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return ResponseEntity.ok(tickets);
    }

    @Operation(summary = "Регистрация пациента.",
            description = "Метод принимает в себя id-талона и  id-пациента. Возвращает зарегистрированный талон к врачу.")
    @PatchMapping("/register/{ticketId}")
    public Ticket registerPatientTicket(@PathVariable Long ticketId, @RequestParam Long patientId) {
        return ticketService.registerPatientTicket(ticketId, patientId);
    }

    // Получение всех талонов по ID пациента
    @Operation(summary = "Получение всех талонов по ID пациента.",
            description = "Метод принимает в себя id-пациента. Возвращает список занятых им талонов.")
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Ticket>> findAllTicketsByPatientId(@PathVariable Long patientId) {
        if (patienService.findById(patientId).isEmpty()) {
            try {
                throw new PatientNotFoundException("Patient with ID: " + patientId + " not found");
            } catch (PatientNotFoundException e) {
                log.info(e.getMessage());
                throw new RuntimeException(e);
            }
        }

        List<Ticket> tickets = ticketService.findAllTicketsByPatientId(patientId);
        if (tickets.isEmpty()) {
            try {
                throw new TicketNotFountException("Ticket not found");
            } catch (TicketNotFountException e) {
                log.info(e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return ResponseEntity.ok(tickets);
    }

}
