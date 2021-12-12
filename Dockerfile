FROM openjdk:8-jdk-alpine
COPY target/GeoLite2Service-0.0.1-SNAPSHOT.jar geo-lite-0.0.1.jar
COPY GeoLite2-Country.mmdb  GeoLite2-Country.mmdb
ENTRYPOINT ["java","-jar","/geo-lite-0.0.1.jar"]
