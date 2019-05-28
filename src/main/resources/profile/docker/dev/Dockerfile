FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD employee-1.0-SNAPSHOT.war app.war
RUN sh -c 'touch /app.war'
ENTRYPOINT ["java","-Duser.timezone=Europe/Warsaw","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]