# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.0/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.0/gradle-plugin/packaging-oci-image.html)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/3.5.0/reference/packaging/native-image/introducing-graalvm-native-images.html)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/3.5.0/specification/configuration-metadata/annotation-processor.html)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/3.5.0/reference/data/sql.html#data.sql.jdbc)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.5.0/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring LDAP](https://docs.spring.io/spring-boot/3.5.0/reference/data/nosql.html#data.nosql.ldap)
* [Spring Data R2DBC](https://docs.spring.io/spring-boot/3.5.0/reference/data/sql.html#data.sql.r2dbc)
* [Rest Repositories](https://docs.spring.io/spring-boot/3.5.0/how-to/data-access.html#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.5.0/reference/using/devtools.html)
* [Docker Compose Support](https://docs.spring.io/spring-boot/3.5.0/reference/features/dev-services.html#features.dev-services.docker-compose)
* [Flyway Migration](https://docs.spring.io/spring-boot/3.5.0/how-to/data-initialization.html#howto.data-initialization.migration-tool.flyway)
* [Spring for GraphQL](https://docs.spring.io/spring-boot/3.5.0/reference/web/spring-graphql.html)
* [Spring HATEOAS](https://docs.spring.io/spring-boot/3.5.0/reference/web/spring-hateoas.html)
* [JDBC API](https://docs.spring.io/spring-boot/3.5.0/reference/data/sql.html)
* [Jersey](https://docs.spring.io/spring-boot/3.5.0/reference/web/servlet.html#web.servlet.jersey)
* [JOOQ Access Layer](https://docs.spring.io/spring-boot/3.5.0/reference/data/sql.html#data.sql.jooq)
* [Liquibase Migration](https://docs.spring.io/spring-boot/3.5.0/how-to/data-initialization.html#howto.data-initialization.migration-tool.liquibase)
* [Spring Modulith](https://docs.spring.io/spring-modulith/reference/)
* [OAuth2 Authorization Server](https://docs.spring.io/spring-boot/3.5.0/reference/web/spring-security.html#web.security.oauth2.authorization-server)
* [OAuth2 Client](https://docs.spring.io/spring-boot/3.5.0/reference/web/spring-security.html#web.security.oauth2.client)
* [OAuth2 Resource Server](https://docs.spring.io/spring-boot/3.5.0/reference/web/spring-security.html#web.security.oauth2.server)
* [Spring Security](https://docs.spring.io/spring-boot/3.5.0/reference/web/spring-security.html)
* [Spring Session](https://docs.spring.io/spring-session/reference/)
* [Vaadin](https://vaadin.com/docs)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.0/reference/web/servlet.html)
* [Spring Web Services](https://docs.spring.io/spring-boot/3.5.0/reference/io/webservices.html)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/3.5.0/reference/web/reactive.html)

### Guides

The following guides illustrate how to use some features concretely:

* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with R2DBC](https://spring.io/guides/gs/accessing-data-r2dbc/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Building a GraphQL service](https://spring.io/guides/gs/graphql-server/)
* [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Creating CRUD UI with Vaadin](https://spring.io/guides/gs/crud-with-vaadin/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Configure AOT settings in Build Plugin](https://docs.spring.io/spring-boot/3.5.0/how-to/aot.html)
* [R2DBC Homepage](https://r2dbc.io)

## GraphQL code generation with DGS

This project has been configured to use the Netflix DGS Codegen plugin.
This plugin can be used to generate client files for accessing remote GraphQL services.
The default setup assumes that the GraphQL schema file for the remote service is added to the
`src/main/resources/graphql-client/` location.

You can learn more about
the [plugin configuration options](https://netflix.github.io/dgs/generating-code-from-schema/#configuring-code-generation)
and
[how to use the generated types](https://netflix.github.io/dgs/generating-code-from-schema/) to adapt the default setup.

### Docker Compose support

This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* mariadb: [`mariadb:latest`](https://hub.docker.com/_/mariadb)
* mysql: [`mysql:latest`](https://hub.docker.com/_/mysql)
* oracle: [`gvenzl/oracle-free:latest`](https://hub.docker.com/r/gvenzl/oracle-free)
* postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)
* sqlserver: [`mcr.microsoft.com/mssql/server:latest`](https://mcr.microsoft.com/en-us/product/mssql/server/about/)

Please review the tags of the used images and set them to the same as you're running in production.

## GraalVM Native Support

This project has been configured to let you generate either a lightweight container or a native executable.
It is also possible to run your tests in a native image.

### Lightweight Container with Cloud Native Buildpacks

If you're already familiar with Spring Boot container images support, this is the easiest way to get started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
$ ./gradlew bootBuildImage
```

Then, you can run the app like any other container:

```
$ docker run --rm -p 8080:8080 crm-chatbot-backend:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools

Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.

To create the executable, run the following goal:

```
$ ./gradlew nativeCompile
```

Then, you can run the app as follows:

```
$ build/native/nativeCompile/crm-chatbot-backend
```

You can also run your existing tests suite in a native image.
This is an efficient way to validate the compatibility of your application.

To run your existing tests in a native image, run the following goal:

```
$ ./gradlew nativeTest
```

### Gradle Toolchain support

There are some limitations regarding Native Build Tools and Gradle toolchains.
Native Build Tools disable toolchain support by default.
Effectively, native image compilation is done with the JDK used to execute Gradle.
You can read more
about [toolchain support in the Native Build Tools here](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html#configuration-toolchains).

