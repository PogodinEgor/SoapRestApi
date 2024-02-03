package ru.pogodin.soap.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid = UUID.randomUUID();

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "specialization")
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

}