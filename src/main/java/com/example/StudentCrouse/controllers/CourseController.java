// package com.example.StudentCrouse.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.example.StudentCrouse.models.Course;
// import com.example.StudentCrouse.repositories.CourseRepository;

// @Controller
// @RequestMapping("/courses")
// public class CourseController {

//     @Autowired
//     private CourseRepository courseRepo;

// //     @GetMapping("/courses")
// //     public String listCourses(Model model) {
// //         model.addAttribute("courses", courseRepo.findAll());
// //         return "courses";
// //     }

//     // @PostMapping("/courses")
//     // public String addCourse(@ModelAttribute Course course) {
//     //     courseRepo.save(course);
//     //     return "redirect:/courses";
//     // }
//     // @PostMapping("/courses")
//     // public String saveCourse(@ModelAttribute Course course) {
//     //     courseRepo.save(course);
//     //     return "redirect:/courses";
//     // }
// //     @GetMapping("/courses")
// //     public String viewCourses(Model model) {
// //         List<Course> courses = courseRepo.findAll();
// //         model.addAttribute("courses", courses);
// //         return "courses"; // Name of your Thymeleaf template (courses.html)
// // }
    // @GetMapping("/courses")
    // public String viewCourses(Model model) {
    //     List<Course> courses = courseRepo.findAll();
    //     model.addAttribute("courses", courses);
    //     return "courses"; // should match courses.html
    // }

// }


package com.example.StudentCrouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.StudentCrouse.models.Course;
import com.example.StudentCrouse.repositories.CourseRepository;

@Controller
public class CourseController {

    @Autowired private CourseRepository courseRepo;

    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("course", new Course());
        return "courses";
    }

    @PostMapping("/courses")
    public String saveCourse(@ModelAttribute Course course) {
        courseRepo.save(course);
        return "redirect:/courses";
    }
}
