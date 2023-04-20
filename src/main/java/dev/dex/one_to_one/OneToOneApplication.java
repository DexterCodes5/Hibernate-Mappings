package dev.dex.one_to_one;

import dev.dex.one_to_one.service.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class OneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorService service, CourseService courseService) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
//				service.saveInstructorAndInstructorDetail();
//				courseService.findReview();
//				courseService.deleteCourse();
//				courseService.saveCourse();
//				courseService.saveStudent();
//				courseService.printCourse();
//				courseService.addCoursesForGopeto();
//				courseService.deleteCourse();
//				courseService.printStudent();
				courseService.deleteStudent();
				courseService.printCourse();
			}
		};
	}

}
