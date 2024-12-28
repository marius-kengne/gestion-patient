package com.example.hopital.controllers;

import com.example.hopital.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.hopital.services.PatientService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public String listPatients(Model model) {
        System.out.println("############## listPatients: d'affichage des patients");
        model.addAttribute("patients", patientService.getAllPatients());
        return "patients";
    }

    @GetMapping("/add-patient")
    public String addPatients(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @PostMapping("/add-patient")
    public String savePatients(@ModelAttribute("patient") Patient patient, RedirectAttributes redirectAttributes) {
        patientService.savePatient(patient);
        redirectAttributes.addFlashAttribute("message", "Patient ajouté avec succès !");
        return "redirect:/patients";
    }

}
