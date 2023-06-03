package com.codecharlan.booklibrary.model;

import com.codecharlan.booklibrary.enums.Gender;
import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.subclass.Date;
import com.codecharlan.booklibrary.subclass.LibraryCard;

public class Teacher {
    private LibraryCard teacherCard;
    private Date employeeHireDate;
    private Role staff;
    private Gender gender;

    public Teacher(LibraryCard teacherCard, Date employeeHireDate, Role staff, Gender gender) {
        this.teacherCard = teacherCard;
        this.employeeHireDate = employeeHireDate;
        this.staff = staff;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherCard=" + teacherCard +
                ", employeeHireDate=" + employeeHireDate +
                ", staff=" + staff +
                ", gender=" + gender +
                '}';
    }
}
