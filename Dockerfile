FROM openjdk:17
WORKDIR /opt
EXPOSE 8080
COPY src/main/java/. /opt
COPY lib /opt
RUN javac Group10Calculator.java
CMD ["java", "Group10Calculator.java"]