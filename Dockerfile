FROM gradle

# copy folder
COPY . /library

# set working directory
WORKDIR /library

# make jar file
RUN ./gradlew bootJar

FROM openjdk:latest

# copy jar file
COPY --from=0 /library/build/libs/library-0.0.1-SNAPSHOT.jar /library.jar

# run jar file
CMD ["java", "-jar", "/library.jar"]