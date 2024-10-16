# 1. Corretto 17을 기반으로 하는 이미지 사용
FROM amazoncorretto:17-alpine

# 2. 애플리케이션 JAR 파일을 Docker 이미지로 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# 3. 애플리케이션 실행 명령 설정
ENTRYPOINT ["java", "-jar", "/app.jar"]