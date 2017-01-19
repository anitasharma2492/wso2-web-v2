FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD wso2-resource-server-v2-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8099
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=production"]