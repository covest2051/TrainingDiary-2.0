package ru.marat.springApp.trainingDiary.models.trainingModels;

public enum WorkoutType {
    CARDIO,
    STRENGTH;


    @Override
    public String toString() {
        switch (this) {
            case CARDIO: return "CARDIO";
            case STRENGTH: return "STRENGTH";
            default: throw new IllegalArgumentException();
        }
    }
}
