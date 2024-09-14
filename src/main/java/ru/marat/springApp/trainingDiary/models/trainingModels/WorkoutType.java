package ru.marat.springApp.trainingDiary.models.trainingModels;

public enum WorkoutType {
    CARDIO,
    STRENGTH;


    @Override
    public String toString() {
        switch (this) {
            case CARDIO: return "Кардио (бег)";
            case STRENGTH: return "Силовая (жим штанги)";
            default: throw new IllegalArgumentException();
        }
    }
}
