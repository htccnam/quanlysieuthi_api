# Build stage: Biên dịch ứng dụng với Maven và JDK 21
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy mã nguồn và cấu hình Maven
COPY pom.xml .
COPY src ./src

# Đóng gói file JAR (bỏ qua kiểm tra test khi build Docker)
RUN mvn clean package -DskipTests

# Run stage: Chạy ứng dụng với JRE 21 gọn nhẹ
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy file jar đã build từ stage trước
COPY --from=build /app/target/*.jar app.jar

# Cổng mặc định của Spring Boot
EXPOSE 8080

# Chạy ứng dụng với biến môi trường JAVA_OPTS (được cấu hình trong docker-compose)
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
