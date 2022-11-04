FROM openjdk:17
WORKDIR /opt
EXPOSE 8080
COPY src/. /opt
RUN javac Group10Calculator.java
CMD ["java", "Group10Calculator"]