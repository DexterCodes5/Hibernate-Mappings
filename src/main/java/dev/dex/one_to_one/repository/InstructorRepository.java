package dev.dex.one_to_one.repository;

import dev.dex.one_to_one.entity.*;
import org.springframework.data.jpa.repository.*;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
