package com.example.StudentCrouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.StudentCrouse.models.Student;
import com.example.StudentCrouse.repositories.CourseRepository;
import com.example.StudentCrouse.repositories.StudentRepository;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;

     @Autowired
    private CourseRepository courseRepo;

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepo.findAll());
        return "students";
    }
    @GetMapping("/students/new")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courses", courseRepo.findAll()); // for dropdown
        return "add-student";
    }
    // @PostMapping("/students")
    // public String saveStudent(@ModelAttribute Student student) {
    //     studentRepo.save(student);
    //     return "redirect:/students";
    // }
    // @PostMapping("/students")
    // public String saveStudent(@ModelAttribute Student student) {
    //     Long courseId = student.getCourse().getId();
    //     student.setCourse(courseRepo.findById(courseId).orElse(null));
    //     studentRepo.save(student);
    //     return "redirect:/students";
    // }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute Student student) 
    {
    // Check if course ID is coming in
        if (student.getCourse() != null && student.getCourse().getId() != null)
        {
            Long courseId = student.getCourse().getId();
            student.setCourse(courseRepo.findById(courseId).orElse(null));
        }

    // Now save student (existing or new)
        studentRepo.save(student);
        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student student = studentRepo.findById(id).orElseThrow();
        model.addAttribute("student", student);
        model.addAttribute("courses", courseRepo.findAll());
        return "add-student"; // Same form used for edit
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepo.deleteById(id);
        return "redirect:/students";
    }
     @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
        Student existingStudent = studentRepo.findById(id).orElseThrow();

        // update basic fields
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setGroupName(student.getGroupName());

        // update course
        if (student.getCourse() != null && student.getCourse().getId() != null) {
            Long courseId = student.getCourse().getId();
            existingStudent.setCourse(courseRepo.findById(courseId).orElse(null));
        } else {
            existingStudent.setCourse(null);
        }

        studentRepo.save(existingStudent);
        return "redirect:/students";
    }

}
