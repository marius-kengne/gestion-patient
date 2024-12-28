package com.example.hopital.services;

import com.example.hopital.models.Patient;
import com.example.hopital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }
}
