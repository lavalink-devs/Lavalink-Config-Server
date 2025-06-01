FROM eclipse-temurin:18-jre-jammy

WORKDIR /opt/Lavalink-Config-Server

# Run as non-root user
RUN addgroup --gid 322 --system lavalink && \
	adduser --uid 322 --system --gid 322 lavalink && \
	chown -R lavalink:lavalink /opt/Lavalink-Config-Server

USER lavalink

COPY build/libs/Lavalink-Config-Server.jar Lavalink-Config-Server.jar

ENTRYPOINT ["java", "-jar"]

CMD ["Lavalink-Config-Server.jar"]
