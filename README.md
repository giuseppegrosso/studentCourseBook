# Course

Course is a spring boot project for studyng Spring boot feature, in particular

- Spring boot v. 2.5.6
- spring jpa
- lombok
- mapstruct 1.4.2
- spring web
- support sqlite
- support coursegres


## Course Description

In this course i show you how to implements rest services, in particular

- Connect to database
- sqlite
- postgres
- Jpa Mapping
- Pagination and Sorting
- 1:1 Relationships
- 1:M Relationships
- M:M Many to Many relationships
- Transactions

## Database Supported

- SQLite
- postgreSQL

## Data Model

The Course data model represents a digital media store, including tables for artists, albums, media tracks, invoices and customers.

## How do I Download and Create the course Database?

Download the repository, compile and launch in intellij or eclipse or visualstudio code.
After installation run the command

```
mvn clean install
java -jar .\target\course-0.0.1-SNAPSHOT.jar --server.port=8080 --spring.profiles.active=sqlite
```

## active profiles

- sqlite
- coursegres

An embedded database, SQLite and SQL Server Compact, it is also provided the embedded database in src/main/resourse/course.db

Notes:

## coursegres

- Tested with postgres v 14.1

## SQLite

- Tested with SQLite 3.25.2

## Development

### System Requirements

- Intellij comunity edition
- Eclipse
- Visual Studio Code
- postgres v 14.1
- Sqlite v 3.25.2

## database: ER

![Diagramma ER](sqlite-sample-database-color.jpg)

## Catalogo Swagger

![Diagramma ER](swagger.jpg)
![Diagramma ER](swagger-student.jpg)
![Diagramma ER](swagger-course.jpg)
![Diagramma ER](swagger-student-enrolment.jpg)

## License

[MIT](https://choosealicense.com/licenses/mit/)

## swagger catalog at 

http://localhost:8090/Course/swagger-ui/index.html?configUrl=/Course/v3/api-docs/swagger-config#/tag-controller/findAll_1