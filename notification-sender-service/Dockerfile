FROM java:8u72-jre

ADD ./target/notification-sender-service-*.jar /app/

RUN mkdir /root/.fcmjava
COPY ./fcmjava.properties /root/.fcmjava

CMD ["java", "-Xmx200m", "-jar", "/app/notification-sender-service-0.0.1-SNAPSHOT.jar"]
