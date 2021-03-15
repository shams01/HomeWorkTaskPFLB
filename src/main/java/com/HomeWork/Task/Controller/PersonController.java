package com.HomeWork.Task.Controller;

import com.HomeWork.Task.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonController {
    //--------------------------------------1 вариант GET-запроса-----------------------------------
//    @GetMapping("/getParameter")
//    public String getParameter(@RequestParam String name, int age){
//        return name + " " + age;
//    }

    //--------------------------------------2 вариант GET-запроса-----------------------------------
    @GetMapping("/getParameter/{name}/{age}")
    public String getParameter(@PathVariable String name, @PathVariable int age){
        return "Hello, my name is " + name + ", and I'am " + age + " years old!";
    }

    // Вставить в PostMan: localhost:8080/api/getParameter/Aragorn/224



    /*
    - Типа Post внутри которого будет создаваться новый объект типа Person ,
    с любыми данными , и сериализовался в json формат и отправлялся в теле ответа к клиенту.
    (проверить , правильные ли данные приходят клиенту)
     */
    @PostMapping("/postParameter")
    @ResponseBody
    public Person postParameter(){
        return new Person("Elrond", 6000);
    }


    /*
    - Типа Post , который будет принимать запрос json формата
    и десериализовывать данные в объект Person.
    (Проверить с помощью вывода в консоль правильные
    ли данные принимает метод и правильно ли он их десериализует)
     */
    @PostMapping("/postParameterDE")
    public Person postParameterDE(@RequestBody Person person){
        return person;
    }

}