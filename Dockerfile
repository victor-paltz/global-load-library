FROM centos:7

RUN yum install -y gcc-c++ make
RUN yum install -y java-1.8.0-openjdk java-1.8.0-openjdk-devel

ENV JAVA_HOME /usr/lib/jvm/java-1.8.0-openjdk

COPY . /opt/globalload

WORKDIR /opt/globalload

RUN make

ENTRYPOINT [ "cp", "-r", "/opt/globalload/src/main", "/github/workspace/build" ]