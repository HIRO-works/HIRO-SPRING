FROM amazoncorretto:17 as build

ARG MYSQL_URL
ARG MYSQL_USERNAME
ARG MYSQL_PASSWORD
ARG JWT_SECRET
ARG S3_ID
ARG S3_SECRET
ARG S3_BUCKET
ARG S3_REGION

ENV MYSQL_URL=${MYSQL_URL}
ENV MYSQL_USERNAME=${MYSQL_USERNAME}
ENV MYSQL_PASSWORD=${MYSQL_PASSWORD}
ENV JWT_SECRET=${JWT_SECRET}
ENV S3_ID=${S3_ID}
ENV S3_SECRET=${S3_SECRET}
ENV S3_BUCKET=${S3_BUCKET}
ENV S3_REGION=${S3_REGION}

WORKDIR /workspace/app

COPY ../portfolio /workspace/app
RUN --mount=type=cache,target=/root/.gradle bash ./gradlew clean build
RUN mkdir -p ./build/dependency && (cd ./build/dependency; jar -xf ../libs/hiro_java-*[0-9].jar)

FROM amazoncorretto:17

VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*", "-Dspring.profiles.active=${PROFILE}", "org.example.hiro_java.HiroJavaApplication"]