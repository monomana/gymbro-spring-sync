package ar.elolmo.gymbro.repository;

import ar.elolmo.gymbro.entities.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<ClassEntity, Integer> {
}
