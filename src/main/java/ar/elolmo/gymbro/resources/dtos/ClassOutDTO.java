package ar.elolmo.gymbro.resources.dtos;

import ar.elolmo.gymbro.entities.ClassEntity;
import ar.elolmo.gymbro.entities.Trainer;
import org.springframework.beans.BeanUtils;


public class ClassOutDTO {
   
    private Integer id;
    private String name;
    private String description;
    private Trainer trainer;

    public static ClassOutDTO convertToDTO(ClassEntity classEntity) {
        ClassOutDTO dto = new ClassOutDTO();
        dto.setDescription(classEntity.getDescription());
        dto.setName(classEntity.getName());
        dto.setTrainer(classEntity.getTrainer());
        return dto;
    }

    public ClassEntity convertToEntity() {
        ClassEntity classEntity = new ClassEntity();
        BeanUtils.copyProperties(this, classEntity);

//        Trainer trainer = new Trainer();
//        trainer.setId(this.trainerId);
//        classEntity.setTrainer(trainer);
        return classEntity;
    }


    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
