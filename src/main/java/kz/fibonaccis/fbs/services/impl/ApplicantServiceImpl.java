package kz.fibonaccis.fbs.services.impl;

import kz.fibonaccis.fbs.entities.Applicant;
import kz.fibonaccis.fbs.repositories.ApplicantRepository;
import kz.fibonaccis.fbs.services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public List<Applicant> findAll() {
        return applicantRepository.findAll();
    }

    @Override
    public Applicant save(String name, String num, String courseName) {

        Applicant applicant = new Applicant(null, name, num, courseName, new Date());

        Applicant createdApplicant = applicantRepository.save(applicant);

        return createdApplicant;
    }

    @Override
    public void sendEmail(Applicant applicant) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("galymsatt@gmail.com");

        msg.setSubject("Fibonacci School: Новая заявка №" + applicant.getId());
        msg.setText("Registration date: " + applicant.getRegDate() +"\nID: " + applicant.getId() + "\nName: "
                + applicant.getName() + "\nNumber: " + applicant.getNumber() + "\nCourse name: " + applicant.getCourseName());

        javaMailSender.send(msg);
    }

    @Override
    public void sendEmail(List<Applicant> applicants) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("galymsatt@gmail.com");

        msg.setSubject("Fibonacci School: Все заявки");

        String text = "Registration date:   \t\t   ID\t Name: \t\t\tNumber: \t\t\t Course name:\n";

        for(Applicant a : applicants){
            text += a.getRegDate() + "\t\t" + a.getId() + "\t" + a.getName() + "\t\t\t" + a.getNumber() + "\t\t\t" + a.getCourseName() + "\n";
        }

        msg.setText(text);

        javaMailSender.send(msg);

    }
}
