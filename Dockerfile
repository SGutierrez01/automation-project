FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app
COPY . /app

RUN mvn clean install -DskipTests

FROM selenium/standalone-chrome:latest

USER root
COPY --from=builder /app /app
WORKDIR /app

# Allure CLI installation (opcional si generarás el reporte adentro)
RUN apt-get update && \
    apt-get install -y unzip wget && \
    wget https://github.com/allure-framework/allure2/releases/download/2.24.0/allure-2.24.0.zip && \
    unzip allure-2.24.0.zip -d /opt/ && \
    ln -s /opt/allure-2.24.0/bin/allure /usr/bin/allure

# Set display for Selenium
ENV DISPLAY=:99

ENTRYPOINT ["mvn", "clean", "test"]
