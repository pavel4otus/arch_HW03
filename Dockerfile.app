FROM openjdk:8-jdk

ENV PROJECT_DIR=/app

RUN mkdir -p $PROJECT_DIR

WORKDIR $PROJECT_DIR

COPY /hw01.jar $PROJECT_DIR

EXPOSE 8082

CMD [ "java", "-jar", "hw02.jar"]
