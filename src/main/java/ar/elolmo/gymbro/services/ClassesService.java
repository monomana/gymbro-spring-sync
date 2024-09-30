package ar.elolmo.gymbro.services;

import ar.elolmo.gymbro.entities.ClassEntity;
import ar.elolmo.gymbro.repository.ClassesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassesService {

    private ClassesRepository repository;

    public ClassesService(ClassesRepository repository) {
        this.repository = repository;
    }

    public List<ClassEntity> findAll() {
        return repository.findAll();
    }

    public Optional<ClassEntity> findById(Integer id) {
        return repository.findById(id);
    }

    public ClassEntity save(ClassEntity classEntity) {
        return repository.save(classEntity);
    }

//    public ClassEntity update(Integer id,ClassInDTO classInDTO) {
//        this.findById(id)
//                .map(ClassInDTO::convertToDTO)
//
//                .map(ClassInDTO::convertToEntity)
//        return repository.save(classes);
//    }


    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
