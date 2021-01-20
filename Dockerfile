FROM maven:3.6-openjdk-11 AS BUILD
WORKDIR /tmp
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ src/
RUN mvn -q package -DskipTests=true

FROM openjdk:11.0.9
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY --from=BUILD /tmp/target/user-service.war user-service.war
EXPOSE 9002
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar user-service.war
