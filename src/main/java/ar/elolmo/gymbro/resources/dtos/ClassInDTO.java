package ar.elolmo.gymbro.resources.dtos;

import ar.elolmo.gymbro.entities.ClassEntity;
import ar.elolmo.gymbro.entities.Trainer;
import org.springframework.beans.BeanUtils;

public class ClassInDTO {

    private String name;
    private String description;
    private Integer trainerId;


    public static ClassInDTO convertToDTO(ClassEntity classEntity) {
        ClassInDTO dto = new ClassInDTO();
        dto.setDescription(classEntity.getDescription());
        dto.setName(classEntity.getName());
        dto.setTrainerId(classEntity.getTrainer().getId());
        return dto;
    }

    public ClassEntity convertToEntity() {
        ClassEntity classEntity = new ClassEntity();
        BeanUtils.copyProperties(this, classEntity);

        Trainer trainer = new Trainer();
        trainer.setId(this.trainerId);
        classEntity.setTrainer(trainer);
        return classEntity;
    }


    // Getters and setters


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

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }
}

