FROM ubuntu:latest
LABEL authors="celestef"

ENTRYPOINT ["top", "-b"]