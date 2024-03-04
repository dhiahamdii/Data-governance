package com.coderdot.entities;

import com.coderdot.dto.EtatUser;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="user_table")

public class User {
    public User() {}
    public User(String fname, String lname, String email, long salary, String department, String designation,
                    LocalDate joiningDate, EtatUser etat) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.designation = designation;
        this.joiningDate = joiningDate;
        this.etat = etat;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="f_name")
    private String fname;

    @Column(name="l_name")
    private String lname;

    @Column(name="mail")
    private String email;

    @Column(name="sal")
    private long salary;

    @Column(name="dep")
    private String department;

    @Column(name="des")
    private String designation;

    @Column(name="jd")
    private LocalDate joiningDate;
    @Column(name="etat")

    private EtatUser etat;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public EtatUser getEtat() {
        return etat;
    }

    public void setEtat(EtatUser etat) {
        this.etat = etat;
    }
}