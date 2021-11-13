FROM alpine:latest

LABEL MAINTENER="Allan"

RUN apk update && \
    apk upgrade && \
    apk add git && \
    apk add maven && \
    apk add bash

RUN git clone https://github.com/asemin08/MyResto.git

WORKDIR MyResto

RUN mvn clean package


ENV TOMCAT_MAJOR=10 \
    TOMCAT_VERSION=10.0.12

RUN apk -U upgrade --update && \
    wget -O /tmp/apache-tomcat.tar.gz https://archive.apache.org/dist/tomcat/tomcat-${TOMCAT_MAJOR}/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz && \
    tar -C /opt -xvf /tmp/apache-tomcat.tar.gz && \
    ln -s /opt/apache-tomcat-${TOMCAT_VERSION}/ /usr/local/tomcat && \
    rm /usr/local/tomcat/conf/tomcat-users.xml && \
    rm /usr/local/tomcat/webapps/manager/META-INF/context.xml && \
    rm /usr/local/tomcat/webapps/host-manager/META-INF/context.xml && \
   # rm -rf /usr/local/tomcat/webapps/* && \
    rm -rf /tmp/apache-tomcat.tar.gz && \
    addgroup -g 2000 tomcat && \
    adduser -h /usr/local/tomcat -u 2000 -G tomcat -s /bin/sh -D tomcat && \
    mkdir -p /usr/local/tomcat/logs && \
    mkdir -p /usr/local/tomcat/work && \
    chown -R tomcat:tomcat /usr/local/tomcat/ && \
    chmod -R u+wxr /usr/local/tomcat

ENV CATALINA_HOME /usr/local/tomcat/
ENV PATH $CATALINA_HOME/bin:$PATH
ENV TOMCAT_NATIVE_LIBDIR=$CATALINA_HOME/native-jni-lib
ENV LD_LIBRARY_PATH=$CATALINA_HOME/native-jni-lib

COPY tomcat-init/conf/tomcat-users.xml /usr/local/tomcat/conf/
COPY tomcat-init/manager/META-INF/context.xml /usr/local/tomcat/webapps/manager/META-INF/ 
COPY tomcat-init/host-manager/META-INF/context.xml /usr/local/tomcat/webapps/host-manager/META-INF/

RUN cp Presentation/target/Presentation*.war /usr/local/tomcat/webapps/MyResto.war

WORKDIR $CATALINA_HOME
USER tomcat
EXPOSE 8080

CMD ["catalina.sh", "run"]
