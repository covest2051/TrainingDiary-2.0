# Приложение "Дневник тренировок"

Это веб-приложение **Дневник тренировок**, созданное с использованием **Spring Boot**, **Thymeleaf** и **Hibernate**. Приложение позволяет пользователям отслеживать свои тренировки и следить за прогрессом. Оно поддерживает два основных типа тренировок: **Кардио** и **Силовые**.

## Описание проекта

Приложение предназначено для людей, которые занимаются спортом и хотят вести учет своих тренировок. Пользователи могут добавлять свои кардио- и силовые тренировки, а также отслеживать историю тренировок для оценки прогресса. Система предлагает:

- Удобный интерфейс для регистрации и входа.
- Возможность записи тренировок с деталями по времени, весу, количеству повторений и сожженным калориям.
- Подсчет общего объема тренировки (время для кардио, общий вес для силовых упражнений).
- Таймер для отслеживания времени тренировки.
- Личный профиль пользователя с историей тренировок.
- Поддержка многопользовательской работы с раздельным хранением данных.

## Возможности

- **Регистрация и аутентификация**: Пользователи могут зарегистрироваться и войти в систему с помощью Spring Security.
- **Отслеживание тренировок**: Поддержка кардио- и силовых тренировок с возможностью записи информации о каждом сеансе.
  - **Кардио-тренировки**: Запись продолжительности и сожженных калорий.
  - **Силовые тренировки**: Запись веса, повторений и подсчет общего веса.
- **История тренировок**: Просмотр всех прошлых тренировок для оценки прогресса.
- **Управление пользователями**: Каждый пользователь имеет личный профиль с данными о тренировках.
- **Встроенный таймер** для точного учета времени.

## Стек технологий

- **Backend**: Spring Boot, Spring Security, Hibernate.
- **Frontend**: Thymeleaf, HTML, CSS, JavaScript.
- **База данных**: PostgreSQL для хранения данных о пользователях и тренировках.
- **Сборка и запуск**: Maven.
