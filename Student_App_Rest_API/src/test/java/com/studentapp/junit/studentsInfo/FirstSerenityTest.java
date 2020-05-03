package com.studentapp.junit.studentsInfo;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://localhost:8080/student";
    }

    @Test
    public void getAllStudentsInfo(){
//        RestAssured.given()
//                .when()
//                .get("/list")
//                .then()
//                .log()
//                .all()
//                .statusCode(200);
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @Test
    public void thisTestFailing(){
//        Failed scenario not working here because maven-failsafe-plugin getting error
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .statusCode(500);
    }

    @Pending
    @Test
    public void pendingTest(){

    }

    @Ignore
    @Test
    public void thisIsSkipTest(){

    }

    @Test
    public void thisIsTestWithError(){
        System.out.println("This is an error:::"+(5/0));
    }

    @Test
    public void fileDoesNOtExist() throws FileNotFoundException {
        File file=new File("C://opent.txt");
        FileReader fileReader=new FileReader(file);
    }

    @Manual
    @Test
    public void thisIsManualTest() {

    }

    @Title("This is adding title below method to get all students info")
    @Test
    public void test01(){

        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }
}
