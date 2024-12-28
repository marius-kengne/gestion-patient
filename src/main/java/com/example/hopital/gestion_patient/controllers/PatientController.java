package com.example.hopital.gestion_patient.controllers;

import com.example.hopital.gestion_patient.models.Patient;
import com.example.hopital.gestion_patient.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        return "add-patients";
    }

    @PostMapping("/add-patient")
    public String savePatients(@ModelAttribute("patient") Patient patient, RedirectAttributes redirectAttributes) {
        patientService.savePatient(patient);
        redirectAttributes.addFlashAttribute("message", "Patient ajouté avec succès !");
        return "redirect:/patients";
    }

    @GetMapping("/edit-patient/{id}")
    public String editPatient(@ModelAttribute("id") Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) {
            return "redirect:/patients";
        }
        model.addAttribute("patient", patient);
        return "edit-patient";
    }

    @PostMapping("/edit-patient")
    public String updatePatient(@ModelAttribute("patient") Patient patient, RedirectAttributes redirectAttributes) {
        patientService.savePatient(patient);
        redirectAttributes.addFlashAttribute("message", "Patient modifié avec succès !");
        return "redirect:/patients";
    }

    @GetMapping("/delete-patient/{id}")
    public String deletePatient(@ModelAttribute("id") Long id, RedirectAttributes redirectAttributes) {
        patientService.deletePatient(id);
        redirectAttributes.addFlashAttribute("message", "Patient supprimé avec succès !");
        return "redirect:/patients";
    }

}
