package dev.dex.one_to_one.service;

import dev.dex.one_to_one.entity.*;
import dev.dex.one_to_one.repository.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
public class InstructorService {
    private InstructorRepository repository;
    private EntityManager entityManager;

    @Autowired
    public InstructorService(InstructorRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    public void saveInstructorAndInstructorDetail() {
        Instructor instructor = new Instructor("Dimitar", "Tanchev", "dexter@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("youtube/dexter", "Cars");
        instructor.setInstructorDetail(instructorDetail);
        repository.save(instructor);
    }

    @Transactional
    public void findInstructor() {
        Instructor instructor = repository.findById(1).get();
        System.out.println(instructor);
        List<Course> list = instructor.getCourses();
        System.out.println(list);
    }

    public void fetchJoin() {
        Query query = entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses WHERE i.id=?1", Instructor.class);
        query.setParameter(1, "1");
        Instructor instructor = (Instructor) query.getSingleResult();
//        Instructor instructor = repository.findById(1).get();
        System.out.println(instructor);
        List<Course> list = instructor.getCourses();
        System.out.println(list);
    }

    @Transactional
    private void deleteInstructorAndInstructorDetail() {
        repository.deleteById(2);
    }
}
