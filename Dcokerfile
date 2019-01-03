FROM private-registry.sohucs.com/sohuauto/compilejava:mvn_fis_jdk8 as buildserver
ADD . /code
WORKDIR /code
RUN mvn clean package -Dmaven.test.skip=true

FROM private-registry.sohucs.com/domeos-pub/jdk:8-alpine
RUN mkdir -p /opt/logs
WORKDIR /opt/project
COPY --from=buildserver /code/target/auto-monitor-0.0.1-SNAPSHOT.jar .