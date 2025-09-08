# 使用官方Java运行环境作为基础镜像
FROM docker.m.daocloud.io/openjdk:17

# 指定维护者信息
LABEL maintainer="524948250@qq.com"

# 将工作目录设置为/app
WORKDIR /app

# 将编译好的jar文件复制到/app目录下
COPY target/Khalims-Brain-1.10.0.jar app.jar


# 暴露8080端口
EXPOSE 8080

# 运行jar文件
ENTRYPOINT sh -c 'if [ -f /hdm_back_door/khalims_brain_env.sh ]; then . /hdm_back_door/khalims_brain_env.sh; fi; exec java -jar app.jar --server.port=8080'
