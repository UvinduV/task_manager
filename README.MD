# Task Manager Application

This is task manager web application for manage tasks , such as Create, Add, Edit , Delete and View task with Status update on their task.

## Tech Stack

- Framework: Spring Boot
- Database: MySQL
- Dependency Management: Gradle
- Java Version: 17
- Authentication: Spring Security with JWT Authentication (Token-based authentication for secure access)

## API End Points

- https://documenter.getpostman.com/view/36185079/2sB2cYdLg5

## Setup and Started

- Clone the repository:
    - BackEnd : https://github.com/UvinduV/task_manager.git
  
- config database url and password in "application-dev.properties" file:
    - spring.datasource.url=jdbc:mysql://localhost:3306/"Your Database Name"?createDatabaseIfNotExist=true
    - spring.datasource.username= "USERNAME"
    - spring.datasource.password= "PASSWORD"
  
- Successfully run project