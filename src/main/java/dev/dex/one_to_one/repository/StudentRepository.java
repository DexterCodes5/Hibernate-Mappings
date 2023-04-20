package dev.dex.one_to_one.repository;

import dev.dex.one_to_one.entity.*;
import org.springframework.data.jpa.repository.*;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Spring will provide implementation
}
