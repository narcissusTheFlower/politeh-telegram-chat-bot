FROM openjdk:17-jdk-alpine
MAINTAINER lev
EXPOSE 8080
ADD build/libs/TelegramBot-1.jar TelegramBot-1.jar
ENTRYPOINT ["java","-jar","TelegramBot-1.jar"]

