FROM alpine:latest as alp

LABEL MAINTENER="Allan"

RUN apk update
RUN apk add git 
RUN apk add maven

RUN git clone https://github.com/asemin08/MyResto.git

WORKDIR MyResto

RUN mvn clean package

FROM tomcat:jre11 as tomcat

COPY --from=alp /MyResto/Presentation/target/Presentation*.war /usr/local/tomcat/webapps/Presentation.war

EXPOSE 8080

CMD [ "catalina.sh", "run" ]
