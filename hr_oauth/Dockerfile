FROM openjdk:17
VOLUME /tmp
ADD ./target/hr_oauth-0.0.1-SNAPSHOT.jar hr-oauth.jar
ENTRYPOINT ["java","-jar","/hr-oauth.jar"]