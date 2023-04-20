package dev.dex.one_to_one.service;

import dev.dex.one_to_one.entity.*;
import dev.dex.one_to_one.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
public class CourseService {
    private CourseRepository courseRepository;
    private InstructorRepository instructorRepository;
    private ReviewRepository reviewRepository;
    private StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, InstructorRepository instructorRepository, ReviewRepository reviewRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.reviewRepository = reviewRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void saveCourse() {
        Instructor instructor = new Instructor("Dimitar", "Tanchev", "dexter@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("youtube/dexter", "Cars");
        instructor.setInstructorDetail(instructorDetail);

        Course course = new Course("Spring");
        Course course2 = new Course("Spring-React");
        Course course3 = new Course("Spring-Angular");
        instructor.add(course);
        instructor.add(course2);
        instructor.add(course3);

        course.add(new Review("React And Spring"));
        course.add(new Review("Spring is the Best"));
        course.add(new Review("Nice Course"));

        instructorRepository.save(instructor);
    }

    @Transactional
    public void saveCourse2() {
        Instructor instructor = instructorRepository.findById(1).get();

        Course course = new Course("Spring");
        Course course2 = new Course("Spring-React");
        instructor.add(course);
        instructor.add(course2);

        courseRepository.save(course);
        courseRepository.save(course2);
    }

    @Transactional
    public void saveReviews() {
        Instructor instructor = instructorRepository.findById(1).get();

        Course course = new Course("Spring");
        Course course2 = new Course("Spring-React");
        Course course3 = new Course("Spring-Angular");

        course.add(new Review("Great Course"));

        instructor.add(course);
        instructor.add(course2);
        instructor.add(course3);

        courseRepository.save(course);
        courseRepository.save(course2);
    }

    @Transactional
    public void saveReview2() {
        Course course = courseRepository.findById(1).get();
        course.add(new Review("I love Spring"));

    }

    @Transactional
    public void findReview() {
        Course course = courseRepository.findById(1).get();
        System.out.println(course);
        System.out.println(course.getReviews());
    }

    @Transactional
    public void deleteCourse() {
        Course course = courseRepository.findById(3).get();
        courseRepository.delete(course);
    }

    @Transactional
    public void saveStudent() {
        Course course = courseRepository.findById(1).get();
        course.addStudent(new Student("John", "Doe", "john@email.com"));
        course.addStudent(new Student("Gopeto", "Vee", "gope@email.com"));
        course.addStudent(new Student("Gope", "King", "gope_king@email.com"));
        courseRepository.save(course);
    }

    @Transactional
    public void addCoursesForGopeto() {
        Student gopeto = studentRepository.findById(2).get();
        gopeto.add(courseRepository.findById(2).get());
        gopeto.add(courseRepository.findById(3).get());
    }

    @Transactional
    public void printCourse() {
        Course course = courseRepository.findById(1).get();
        System.out.println(course);
        System.out.println(course.getStudents());
    }

    @Transactional
    public void printStudent() {
        Student student = studentRepository.findById(2).get();
        System.out.println(student);
        System.out.println(student.getCourses());
    }

    @Transactional
    public void deleteStudent() {
        Student student = studentRepository.findById(1).get();
        System.out.println("Deleting student: " + student);
        studentRepository.delete(student);
    }
}
