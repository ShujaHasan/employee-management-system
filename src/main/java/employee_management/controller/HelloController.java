package employee_management.controller;

import employee_management.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @GetMapping("/name")
        public String name(){
            return "My Name is Shuja!";
        }

    @GetMapping("/country")
        public String country(){
        return  "I am from Pakistan";
    }

    @GetMapping("age/{age}")
        public String ageInfo(@PathVariable int age){
        return "You are " + age + "years old!";
    }

    @GetMapping("/add/{a}/{b}")
        public String addNum(@PathVariable int a, @PathVariable int b){
        int sum = a + b;
        return "Sum = " + sum;
    }

    @GetMapping("/multiply/{a}/{b}")
        public String prodNum (@PathVariable int a, @PathVariable int b){
        int product = a * b;
        return "Result = " + product;
    }

    @GetMapping("/welcome")
        public String greetUser(@RequestParam String name){
        return "Welcome " + name;
    }

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1, "Shuja", "Computer Science");
        return student;
    }

}

