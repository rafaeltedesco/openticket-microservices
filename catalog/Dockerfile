FROM eclipse-temurin:17-jdk-focal
 
WORKDIR /app
 
COPY . .
RUN ./mvnw dependency:go-offline
 
EXPOSE 3030
 
CMD ["./mvnw", "spring-boot:run"]