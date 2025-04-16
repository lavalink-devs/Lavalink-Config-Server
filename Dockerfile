FROM azul/zulu-openjdk-alpine:21-jre-headless-latest

# Run as non-root user
RUN addgroup -g 322 -S lavalink && \
    adduser -u 322 -S lavalink lavalink

WORKDIR /opt/Lavalink-Config-Server

RUN chown -R lavalink:lavalink /opt/Lavalink-Config-Server

USER lavalink

COPY build/libs/Lavalink-Config-Server.jar Lavalink-Config-Server.jar

ENTRYPOINT ["java", "-jar"]

CMD ["Lavalink-Config-Server.jar"]
