# 使用官方Java运行环境作为基础镜像
FROM docker.m.daocloud.io/openjdk:17

# 指定维护者信息
LABEL maintainer="524948250@qq.com"

# 将工作目录设置为/app
WORKDIR /app

# 将编译好的jar文件复制到/app目录下
COPY target/Khalims-Brain-1.6.2.jar app.jar


# 暴露80端口
EXPOSE 80

# 运行jar文件
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=8080"]

