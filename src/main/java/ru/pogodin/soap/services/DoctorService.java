package ru.pogodin.soap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pogodin.soap.models.Doctor;
import ru.pogodin.soap.repositories.DoctorsRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DoctorService {
    private final DoctorsRepository doctorsRepository;

    @Autowired
    public DoctorService(DoctorsRepository doctorsRepository) {
        this.doctorsRepository = doctorsRepository;
    }

    public Optional<Doctor> findById(Long id){
        return doctorsRepository.findById(id);
    }
}
