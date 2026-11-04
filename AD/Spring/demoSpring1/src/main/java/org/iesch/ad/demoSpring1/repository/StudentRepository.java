package org.iesch.ad.demoSpring1.repository;

import org.iesch.ad.demoSpring1.modelo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {



}
