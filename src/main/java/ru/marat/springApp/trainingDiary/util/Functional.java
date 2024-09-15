package ru.marat.springApp.trainingDiary.util;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class Functional {
    public static long convertTimeToSeconds(String time) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime localTime = LocalTime.parse(time, formatter);
            Duration duration = Duration.between(LocalTime.MIN, localTime);
            return duration.getSeconds();
        } catch (DateTimeParseException e) {
            System.out.println("Invalid format: " + e.getMessage());
            return 0;
        }
    }
}
