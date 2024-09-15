package ru.marat.springApp.trainingDiary.models.trainingModels;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("STRENGTH")  // Соответствует значению "STRENGTH" в столбце workout_type
@Data
public class StrengthWorkout extends Workout {
    private int weight;

}
