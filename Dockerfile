FROM alpine:latest as alp

LABEL MAINTENER="Allan"

RUN apk update
RUN apk add git 
RUN apk add maven

RUN git clone https://github.com/asemin08/MyResto.git

WORKDIR MyResto

RUN mvn clean package


RUN mv /MyResto/Presentation/target/Presentation*.war /MyResto/webApp/MyResto.war
