FROM gcr.io/distroless/java21-debian12:nonroot

WORKDIR /opt/Lavalink

COPY build/libs/Lavalink-Config-Server.jar Lavalink-Config-Server.jar

ENTRYPOINT ["java", "-jar"]

CMD ["Lavalink-Config-Server.jar"]
