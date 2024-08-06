#Build Stage
FROM maven:3.8.7-openjdk-18 as build-stage
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

#Runtime stage
FROM amazoncorretto:17
ARG PROFILE=native
ARG APP_VERSION=1.0.0

WORKDIR /app
COPY --from=build-stage /build/target/config-server-*.jar /app/

EXPOSE 8888

ENV ACTIVE_PROFILE=${PROFILE}
ENV JAR_VERSION=${APP_VERSION}

CMD java -jar -Dspring.profiles.active=${ACTIVE_PROFILE} config-server-${JAR_VERSION}.jar
