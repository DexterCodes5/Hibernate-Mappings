package dev.dex.one_to_one.repository;

import dev.dex.one_to_one.entity.*;
import org.springframework.data.jpa.repository.*;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {
    // Spring will provide implementation
}
