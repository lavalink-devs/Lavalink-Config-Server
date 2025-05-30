FROM eclipse-temurin:18-jre-jammy

# Run as non-root user
RUN groupadd -g 322 lavalink && \
    useradd -r -u 322 -g lavalink lavalink

WORKDIR /opt/Lavalink-Config-Server

RUN chown -R lavalink:lavalink /opt/Lavalink-Config-Server

USER lavalink

COPY build/libs/Lavalink-Config-Server.jar Lavalink-Config-Server.jar

ENTRYPOINT ["java", "-jar"]

CMD ["Lavalink-Config-Server.jar"]
