# forum
Aula API REST com Kotlin e Spring Boot: Camada Web

---
empacotar o jar:
mvn package
---
startando a aplicação via linha de comando: mvn spring-boot:run

---
### profiles
startando a aplicação via linha de comando informando o profiles:
mvn spring-boot:run -Dspring-boot.run.profiles=dev

startando a aplicação via edit configurations/VM options:
-Dspring.profiles.active=dev

startando a aplicação via edit configurations/Environment variables:
spring.profiles.active=prod
---
### Docker

Construindo a imagem:
docker build -t forum -f Dockerfile .

Subindo aplicação:
docker run  -p 3080:8080 forum
