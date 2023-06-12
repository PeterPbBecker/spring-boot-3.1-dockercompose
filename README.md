# Spring Boot 3.1 Example for Docker Compose integration

Example for the new Docker Compose functionality in Spring Boot 3.1

With Spring Boot 3.1 it is now possible to use a Docker Compose file to run docker containers.

If you have a Docker Compose file in the root directory of your Spring Boot 3.1 application,
Spring Boot can detect this file and execute it.

In the current version, the following file names are supported:

- docker-compose.yaml
- docker-compose.yml
- compose.yaml
- compose.yml

When you have a non-standard file name for the Docker Compose file, you can use the property
**spring.docker.compose.file** to set another file name.

To enable the mechanism, to start the Docker Compose file, you have to add the new module
**spring-boot-docker-compose**, that provides integration with Docker Compose.

```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-docker-compose</artifactId>
        </dependency>
```

After starting the Spring Boot application, you can see in the log, that Docker Compose start 
the containers, that are configured in the Docker Compose file. In the current example,
a Postgres database container is started.

```asciidoc
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.0)

2023-06-12T14:16:51.795+02:00  INFO 11430 --- [           main] o.p.e.n.d.DockerComposeDemoApplication   : Starting DockerComposeDemoApplication using Java 17.0.7 with PID 11430 (/home/pbecker/java/projects/samples/springboot3/dockercompose/target/classes started by pbecker in /home/pbecker/java/projects/samples/springboot3/dockercompose)
2023-06-12T14:16:51.804+02:00  INFO 11430 --- [           main] o.p.e.n.d.DockerComposeDemoApplication   : No active profile set, falling back to 1 default profile: "default"
2023-06-12T14:16:52.015+02:00  INFO 11430 --- [           main] .s.b.d.c.l.DockerComposeLifecycleManager : Using Docker Compose file '/home/pbecker/java/projects/samples/springboot3/dockercompose/docker-compose.yml'
2023-06-12T14:16:52.730+02:00  INFO 11430 --- [utReader-stderr] o.s.boot.docker.compose.core.DockerCli   :  Container dockercompose-database-1  Created
2023-06-12T14:16:52.731+02:00  INFO 11430 --- [utReader-stderr] o.s.boot.docker.compose.core.DockerCli   :  Container dockercompose-database-1  Starting
2023-06-12T14:16:53.111+02:00  INFO 11430 --- [utReader-stderr] o.s.boot.docker.compose.core.DockerCli   :  Container dockercompose-database-1  Started
2023-06-12T14:16:53.111+02:00  INFO 11430 --- [utReader-stderr] o.s.boot.docker.compose.core.DockerCli   :  Container dockercompose-database-1  Waiting
2023-06-12T14:16:53.614+02:00  INFO 11430 --- [utReader-stderr] o.s.boot.docker.compose.core.DockerCli   :  Container dockercompose-database-1  Healthy
...
2023-06-12T14:17:04.984+02:00  INFO 11430 --- [           main] o.p.e.n.d.DockerComposeDemoApplication   : Started DockerComposeDemoApplication in 14.175 seconds (process running for 15.308)
```
