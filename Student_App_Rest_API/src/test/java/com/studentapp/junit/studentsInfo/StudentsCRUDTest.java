package com.studentapp.junit.studentsInfo;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestInitialize;
import com.studentapp.utils.ReuseableSpecifications;
import com.studentapp.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import org.jruby.RubyProcess;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentsCRUDTest extends TestInitialize {

    public static String firstName="SmokeUser"+TestUtils.getRandomValue();
    public static String lastName="SmokeUser"+TestUtils.getRandomValue();
    public static String programme="Computer Sceince";
    public static String email = TestUtils.getRandomValue()+"xyz@gmail.com";
    public static int studentId;

    @Steps
    StudentSerenitySteps studentSerenitySteps;



    @Title("Adding new student record into the StudentApp")
    @Test
    public void test01(){
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Java");
        courses.add(".net");
        courses.add("Automation");

        studentSerenitySteps.createStudent(firstName,lastName,email,programme,courses)
        .statusCode(201)
        .spec(ReuseableSpecifications.getGenericResponseSpec());
    }

    @Title("Verify the student value")
    @Test
    public void test02(){
        HashMap<String,Object> value = studentSerenitySteps.getStudentInfoByFirstName(firstName);

        System.out.println("firstname is::::"+firstName);
        System.out.println("The value is:::"+value);

        assertThat(value, hasValue(firstName));

        studentId = (int) value.get("id");

    }

    @Title("Updating the student first name based upon the id")
    @Test
    public void test03(){
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Java");
        courses.add(".net");
        courses.add("Automation");

        studentSerenitySteps.updateStudent(studentId,firstName,lastName,email,programme,courses);

        HashMap<String,Object> value = studentSerenitySteps.getStudentInfoByFirstName(firstName);
        assertThat(value,hasValue(firstName));
    }

    @Title("Deleting the student based upon the id")
    @Test
    public void test04() {
       studentSerenitySteps.deleteStudent(studentId);
       studentSerenitySteps.getStudentById(studentId).statusCode(404);
    }
}
