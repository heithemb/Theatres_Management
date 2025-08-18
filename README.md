# Theatre Management REST API

This repository contains a simple example of a RESTful API for theatre management using Spring Boot and MySQL.

## Configuration

Make sure to add the `application.properties` file under `src/main/resources/` following this structure:

```properties
spring.application.name=demo-1
server.port=8090

spring.datasource.url=jdbc:mysql://localhost:3306/{database_name}
spring.datasource.username={your_username_or_root}
spring.datasource.password={your_password}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true
```

## API Examples

### Reservation API

Get Reservation by ID: [http://localhost:8090/RestApi/reservation?id=1](http://localhost:8090/RestApi/reservation?id=1)

Get Reservation by Client: [http://localhost:8090/RestApi/reservation/client?client=JohnDoe](http://localhost:8090/RestApi/reservation/client?client=JohnDoe)

Get Reservation by Spectacle ID: [http://localhost:8090/RestApi/reservation/spectacle?idspectacle=5](http://localhost:8090/RestApi/reservation/spectacle?idspectacle=5)

Create Reservation: [http://localhost:8090/RestApi/reservation](http://localhost:8090/RestApi/reservation)

Update Reservation: [http://localhost:8090/RestApi/reservation/1](http://localhost:8090/RestApi/reservation/1)

Delete Reservation: [http://localhost:8090/RestApi/reservation?id=1\&Client=JohnDoe](http://localhost:8090/RestApi/reservation?id=1&Client=JohnDoe)

### Spectacles API

Get All Spectacles: [http://localhost:8090/RestApi/spectacle](http://localhost:8090/RestApi/spectacle)

Get Spectacle by ID: [http://localhost:8090/RestApi/spectacle/1](http://localhost:8090/RestApi/spectacle/1)

Get Spectacle by Name: [http://localhost:8090/RestApi/spectacle/name/Musical](http://localhost:8090/RestApi/spectacle/name/Musical)

Get Spectacle by Creator: [http://localhost:8090/RestApi/spectacle/creator/JohnDoe](http://localhost:8090/RestApi/spectacle/creator/JohnDoe)

Get Spectacle by Date: [http://localhost:8090/RestApi/spectacle/date/2025-08-18](http://localhost:8090/RestApi/spectacle/date/2025-08-18)

Get Spectacle by Theatre ID: [http://localhost:8090/RestApi/spectacle/theatre/2](http://localhost:8090/RestApi/spectacle/theatre/2)

Create Spectacle: [http://localhost:8090/RestApi/spectacle](http://localhost:8090/RestApi/spectacle)

Update Spectacle: [http://localhost:8090/RestApi/spectacle/1](http://localhost:8090/RestApi/spectacle/1)

Delete Spectacle: [http://localhost:8090/RestApi/spectacle/1](http://localhost:8090/RestApi/spectacle/1)

### Theatres API

Get All Theatres: [http://localhost:8090/RestApi/theatre](http://localhost:8090/RestApi/theatre)

Get Theatre by Name: [http://localhost:8090/RestApi/theatre/name/MainTheatre](http://localhost:8090/RestApi/theatre/name/MainTheatre)

Get Theatre by Address: [http://localhost:8090/RestApi/theatre/address/123MainSt](http://localhost:8090/RestApi/theatre/address/123MainSt)

Create Theatre: [http://localhost:8090/RestApi/theatre](http://localhost:8090/RestApi/theatre)

Update Theatre: [http://localhost:8090/RestApi/theatre/1](http://localhost:8090/RestApi/theatre/1)

Delete Theatre by ID: [http://localhost:8090/RestApi/theatre/1](http://localhost:8090/RestApi/theatre/1)

Delete Theatre by Name & Address: [http://localhost:8090/RestApi/theatre/MainTheatre/123MainSt](http://localhost:8090/RestApi/theatre/MainTheatre/123MainSt)
