FROM java:8
LABEL maintainer="corentin.barban@toulouse.miage.fr"
VOLUME /tmp
EXPOSE 8089
ADD target/gestioncours-0.0.1-SNAPSHOT.jar gestioncours-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","gestioncours-0.0.1-SNAPSHOT.jar"]
