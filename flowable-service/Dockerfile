FROM registry.cn-hangzhou.aliyuncs.com/yunshare/java:openjdk-8-alpine-ttf
MAINTAINER lzx lzx@yuyuda.com
ENV TZ "Asia/Shanghai"

ADD target/lib ./lib
ADD target/resources ./resources

ENV JAVA_OPTS="\
-server \
-Xmx2g \
-Xms2g \
-Xmn1g \
-XX:SurvivorRatio=8 \
-XX:MetaspaceSize=256m \
-XX:MaxMetaspaceSize=512m \
-XX:+UseParallelGC \
-XX:ParallelGCThreads=4 \
-XX:+UseParallelOldGC \
-XX:+UseAdaptiveSizePolicy \
-XX:+PrintGCDetails \
-XX:+PrintTenuringDistribution \
-XX:+PrintGCTimeStamps \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=/ \
-Xloggc:/gc.log \
-XX:+UseGCLogFileRotation \
-XX:NumberOfGCLogFiles=5 \
-XX:GCLogFileSize=10M"
ADD target/service.jar ./service.jar

ENTRYPOINT java $JAVA_OPTS -jar /service.jar

