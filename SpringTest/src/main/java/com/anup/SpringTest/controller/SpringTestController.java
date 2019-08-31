package com.anup.SpringTest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/employees")
public class SpringTestController {

    @GetMapping(path="/",produces= {APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) //produces is eqvivalent to content-type
    public @ResponseBody
    ResponseEntity<Employee> getEmployee(){
        return new ResponseEntity<Employee>(new Employee(1,"Anup"), HttpStatus.ACCEPTED);
    }
    /*
    Hit with http://localhost:8080/employees/
    and header
    Accept = "application/json"
    output-
    {
    "id": 1,
    "name": "Anup"
    }
    if you dont mention @Response Body it would throw error stating HttpMediaTypeNotAcceptableException
    also ensure Employee object should have getter and setters required for jackson

    header - accept ="application/xml"
    output -
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <employee>
        <id>1</id>
        <name>Anup</name>
    </employee>
    if you dont mention @XmlRootELement and default constructor it would fail
       */

    @PostMapping(path="/{id}",produces= {APPLICATION_JSON_VALUE},consumes = {APPLICATION_JSON_VALUE}) //produces is eqvivalent to content-type
    public @ResponseBody Employee addEmployee(@PathVariable("id") int id,@RequestBody Employee input,@RequestParam("abc")  String name){
        return new Employee(id,name);
    }
    /*
    input -
    hit http://localhost:8080/employees/222?abc=Anoop
    output -
    {
        "id": 222,
        "name": "Anoop"
     }
     output response header -
     content-type →application/json;charset=UTF-8
     date →Sat, 31 Aug 2019 06:34:44 GMT
     transfer-encoding →chunked
     */


}
@XmlRootElement
class Employee{

    int id;
    String name;

    public Employee() {//necessary for xml
    }

    public Employee(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

