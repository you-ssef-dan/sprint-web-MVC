package net.danoun.patientsapp.web;


import net.danoun.patientsapp.entities.Patient;
import net.danoun.patientsapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model ,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        //Page<Patient> pagePatients = patientRepository.findByNomContainingIgnoreCase(keyword, PageRequest.of(page, size));
        Page<Patient> pagePatients = patientRepository.findByNomContainingIgnoreCaseOrPrenomContainsIgnoreCase(keyword, keyword, PageRequest.of(page, size));

        model.addAttribute("listPatients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "patients";
    }

    @GetMapping("deletePatient")
    public String delete(@RequestParam(name = "id") Long id, int page, String keyword) {
        patientRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }
}
