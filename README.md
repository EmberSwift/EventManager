Веб-приложение учёта проведенных мероприятий

Серверная часть веб-приложения на Java и Spring Boot для учёта проведенных мероприятий и участвовавших в них студентов. 
Проект спроектирован с использованием Onion Architecture, разделен на независимые слои, подключен к СУБД PostgreSQL и покрыт модульными тестами.



Запросы:

POST  /api/events  Создать новое мероприятие

GET  /api/events  Получить список всех мероприятий

DELETE  /api/events/{id}  Отменить мероприятие по ID

POST  /api/students  Зарегистрировать нового студента

GET  /api/students?group={name}  Найти студентов по названию группы

POST  /api/participations?eventId={eId}&studentId={sId}  Записать студента на мероприятие

GET  /api/participations/event/{eventId}  Получить список участников мероприятия

GET  /api/students/{studentId}/events  Получить историю мероприятий студента
