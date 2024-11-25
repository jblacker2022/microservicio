# Imagen base con JDK 11
FROM openjdk:11-jdk-slim

# Directorio de trabajo
WORKDIR /app

# Copia el FAT JAR generado
COPY target/microservicio-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto de la aplicación
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
