package ru.marat.springApp.trainingDiary.models.trainingModels;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("STRENGTH")
@Data
public class StrengthWorkout extends Workout {
    private int weight;

}
