# Repository Guidelines

## Project Structure & Module Organization
This is a multi-module COLA layout:
- `starter/` hosts the Spring Boot entry point and resources (`starter/src/main/java/com/use/demo/Application.java`, `starter/src/main/resources/application.yml`).
- `adapter/` contains web controllers and transport DTOs (`adapter/src/main/java/com/use/demo/adapter/web`).
- `app/` contains application services and unit tests (`app/src/main/java/com/use/demo/application`, `app/src/test/java`).
- `domain/` holds domain interfaces and core types (`domain/src/main/java/com/use/demo/domain`).
- `infrastructure/` contains external integrations and persistence adapters.
Keep modules focused and avoid leaking adapter DTOs into the domain layer.

## Build, Test, and Development Commands
This project targets JDK 17 and Spring Boot 2.7.18, and uses Gradle 8.0.2. Use the wrapper so versions stay consistent:
- `./gradlew test` to run all module tests.
- `./gradlew :app:test` to run only application-layer tests.
- `./gradlew build` to compile, test, and assemble artifacts.
- `./gradlew :starter:bootRun` for local development.

## Coding Style & Naming Conventions
Default to 4-space indentation, one public class per file, and packages in `lowercase` (for example, `com.use.demo.adapter`). Use `PascalCase` for classes and `camelCase` for methods/fields. Add a formatter/linter early (for example, Spotless + Google Java Format or Checkstyle) and enforce it in CI.

## Testing Guidelines
Use JUnit 5 for unit tests and name test classes after the unit under test (for example, `UserServiceTest`). Keep tests deterministic and fast; prefer small fixtures and no shared mutable state. For Spring Boot integration tests, use `@SpringBootTest`, name them `*IT`, and configure Gradle to run them explicitly.

## Commit & Pull Request Guidelines
There is no Git history yet. Use Conventional Commits (`feat:`, `fix:`, `docs:`, `chore:`) and keep messages imperative. Pull requests should include a short summary, linked issues, and any migration or setup steps needed to validate the change locally. Add screenshots for UI or console output changes.

## Security & Configuration Tips
Keep secrets out of source control. Use environment variables or a local `application-local.yml` ignored by Git, and document required keys in `application.yml` with safe defaults. Prefer Spring profiles for environment-specific settings (for example, `application-dev.yml`, `application-prod.yml`) and make the active profile explicit in startup docs (for example, `SPRING_PROFILES_ACTIVE=dev`). For logging, use Logback with a plain-text pattern encoder, define levels per package in `application.yml` (for example, `com.use.demo` at `INFO`, noisy dependencies at `WARN`), and keep the format consistent across environments. For Actuator, keep exposure minimal (for example, only `health` and `info`), disable sensitive endpoints by default, and require authentication in non-local environments.
When adding dependencies, prefer the newest versions that remain compatible with Spring Boot 2.7.18’s BOM.

Example `logback-spring.xml` pattern encoder:
```xml
<configuration>
  <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>\r\n      <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>\r\n    </encoder>
  </appender>
  <root level="INFO">
    <appender-ref ref="CONSOLE" />
  </root>
</configuration>
```

