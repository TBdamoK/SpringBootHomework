package kz.bitlab.springboot.homeworkweek13.controller;

import kz.bitlab.springboot.homeworkweek13.models.Student;
import kz.bitlab.springboot.homeworkweek13.services.Database;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public String homePage(Model model) {
        model.addAttribute("students", Database.getStudentList());
        return "home";
    }

    @GetMapping(value = "/addstudent")
    public String addStudentPage(Model model){
        model.addAttribute("students", Database.getStudentList());
        return "addstudent";
    }

    @PostMapping(value = "/addstudent")
    public String addStudent(@RequestParam (name = "student_name") String studentName,
                                 @RequestParam (name = "student_surname") String studentSurname,
                                 @RequestParam (name = "exam_score") int examScore){

        Database.addStudent(studentName, studentSurname, examScore);

        return "redirect:/addstudent";
    }

    @PostMapping("/add-student")
    public String addStudent(Student student){
        Database.addStudent(student);
        return "redirect:/addstudent";
    }

}
