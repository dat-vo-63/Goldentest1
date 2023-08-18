FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/docker-shoes.jar docker-shoes.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","docker-shoes.jar"]