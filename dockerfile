FROM ubuntu
MAINTAINER kumar
USER kumar
RUN apt-get update
RUN apt-get install -y git 