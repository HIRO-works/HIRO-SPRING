FROM amazoncorretto:17 as build

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