package kz.fibonaccis.fbs.services;

import kz.fibonaccis.fbs.entities.Applicant;

import java.util.List;

public interface ApplicantService {

    List<Applicant> findAll();
    Applicant save(String name, String num, String courseName);
    void sendEmail(Applicant applicant);
    void sendEmail(List<Applicant> applicants);

}
