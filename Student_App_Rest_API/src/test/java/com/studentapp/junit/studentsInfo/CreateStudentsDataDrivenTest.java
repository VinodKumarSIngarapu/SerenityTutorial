package com.studentapp.junit.studentsInfo;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.testbase.TestInitialize;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

//C:\Users\Yashmit\IntelliJ_Projects\Student_App_Rest_API\src\test\resources\testdata\studentInfo.txt
@UseTestDataFrom("src/test/resources/testdata/studentInfo.txt")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentsDataDrivenTest extends TestInitialize {

    @Steps
    StudentSerenitySteps studentSerenitySteps;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String courses) {
        course = courses;
    }

    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private String course;

    @Title("Creating the multiple students info into students app")
    @Test
    public void createMultipleStudents(){
        ArrayList<String> courses = new ArrayList<String>();
        courses.add(course);
        studentSerenitySteps.createStudent(firstName,lastName,email,programme,courses)
        .statusCode(201);
    }
}
