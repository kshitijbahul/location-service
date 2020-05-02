FROM openjdk:12-alpine
EXPOSE 6001
COPY ./target/location-service.jar .
CMD ["java","-jar","location-service.jar"]