# Giai đoạn 1: Build JAR
FROM gradle:8.3.0-jdk17 AS builder

# Cài đặt thư mục làm việc
WORKDIR /app

# Sao chép mã nguồn ứng dụng
COPY . .

# Build JAR bằng Gradle
RUN gradle build -x test

# Giai đoạn 2: Chạy ứng dụng
FROM openjdk:17 AS runner

# Sao chép JAR đã build
COPY --from=builder /app/build/libs/*.jar app.jar

# Cài đặt thư mục làm việc
WORKDIR /app

# Chạy ứng dụng bằng Java
ENTRYPOINT ["java", "-jar", "app.jar"]
