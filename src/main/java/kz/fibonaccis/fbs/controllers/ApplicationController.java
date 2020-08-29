package kz.fibonaccis.fbs.controllers;

import kz.fibonaccis.fbs.entities.Applicant;
import kz.fibonaccis.fbs.services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicantService applicantService;

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/leaveApplication")
    public String leaveApplication(@RequestParam(name = "name") String name,
                                   @RequestParam(name = "num") String num,
                                   @RequestParam(name = "courseName") String courseName){

        System.out.println("Data from ajax - name: "+name+", num: "+num+", course name: "+courseName);

        Applicant createdApplicant = applicantService.save(name, num, courseName);
        System.out.println("createdApplicant: "+createdApplicant);

        try {
            applicantService.sendEmail(createdApplicant);
        }catch (Exception e){
            e.printStackTrace();
        }


        return "success";
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getAllApplicants(){

        try {
            applicantService.sendEmail(applicantService.findAll());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("Something went wrong...");
        }

        return ResponseEntity.ok("Data has been send!");
    }

}
