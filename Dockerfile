FROM alpine:latest

# Copy everything from your project directory to 
# a folder called app. Basically copies Main.java
COPY . /app

# Move into that directory
WORKDIR /app

# Install Java 17, maven
RUN apk update && apk add openjdk17 maven

RUN mvn clean package

COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]

