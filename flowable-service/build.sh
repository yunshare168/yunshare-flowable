mvn clean package

docker build -t registry.cn-hangzhou.aliyuncs.com/yunshare/yunshare-bpm-service:1.0.0 .

docker push registry.cn-hangzhou.aliyuncs.com/yunshare/yunshare-bpm-service:1.0.0
