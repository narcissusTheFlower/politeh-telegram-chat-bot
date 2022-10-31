FROM gradle:jdk17-jammy
WORKDIR /home
ADD . /home
EXPOSE 8080
RUN gradle clean build
ENTRYPOINT ["/bin/bash"]

