FROM curlimages/curl:7.81.0 AS download
RUN curl --silent --fail -L "https://oss.sonatype.org/service/local/artifact/maven/redirect?r=releases&g=co.elastic.apm&a=elastic-apm-agent&v=LATEST" -o "$HOME/apm-agent.jar"

FROM maven:3.8.6-openjdk-18 AS build
ADD . /build
RUN cd /build && mvn package --quiet

FROM openjdk:18-jdk-slim-buster
COPY --from=build /build/target/*.jar /app.jar
COPY --from=download /home/curl_user/apm-agent.jar /apm-agent.jar
CMD ["java", \
  "-jar", "/app.jar" \
]
