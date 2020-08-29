package kz.fibonaccis.fbs.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Applicant - тот кто оставил заявку
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_applicants")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "courseName")
    private String courseName;

    @Column(name = "regDate")
    private Date regDate;

}
