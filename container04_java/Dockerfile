FROM openjdk:11-jdk
RUN apt-get update && apt-get install -y wget unzip
RUN wget https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.36.0.3/sqlite-jdbc-3.36.0.3.jar -O /opt/sqlite-jdbc.jar
RUN wget https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.4.44.v20210927/jetty-distribution-9.4.44.v20210927.zip && \
    unzip jetty-distribution-9.4.44.v20210927.zip -d /opt && \
    mv /opt/jetty-distribution-9.4.44.v20210927 /opt/jetty
ENV JETTY_BASE /opt/jetty
COPY webapp /opt/jetty/webapps/root
COPY webapp/WEB-INF/classes /opt/jetty/webapps/root/WEB-INF/classes
COPY webapp/PopularDB.java /opt/
WORKDIR /opt
RUN javac -cp sqlite-jdbc.jar PopularDB.java && java -cp .:sqlite-jdbc.jar PopularDB
WORKDIR /opt/jetty
EXPOSE 8013
CMD ["java", "-cp", "/opt/sqlite-jdbc.jar:/opt/jetty/webapps/root/WEB-INF/classes", "org.eclipse.jetty.start.Main"]
