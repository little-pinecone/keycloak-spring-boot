# keycloak-spring-boot

[![keep_growing logo](readme-images/logo_250x60.png)](https://keepgrowing.in/)

## About this project

This project shows an example integration of Spring Boot with Keycloak.

## Getting started

First, [clone](https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository-from-github/cloning-a-repository)
this repository.

Then, build it locally with:

```shell
mvn clean install
```

You can run the app in a command line with the following command:

```shell
mvn spring-boot:run
```

### Running tests

You can run tests with:

```shell
mvn test
```

### API documentation

The Postman collection for the API is publicly available[^1], click the button below and select the `localhost`
environment:

[![Run in Postman](https://run.pstmn.io/button.svg)](https://god.gw.postman.com/run-collection/2376101-355eea51-db59-42b1-a7cd-5b30bffbc279?action=collection%2Ffork&collection-url=entityId%3D2376101-355eea51-db59-42b1-a7cd-5b30bffbc279%26entityType%3Dcollection%26workspaceId%3Dcab089bb-1815-498b-a447-bd5ff08145fb#?env%5Blocalhost%5D=W3sia2V5IjoiYmFzZVVybCIsInZhbHVlIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwIiwiZW5hYmxlZCI6dHJ1ZSwic2Vzc2lvblZhbHVlIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwIiwic2Vzc2lvbkluZGV4IjowfV0=)

![Postman collection screenshot](readme-images/postman-collection.png)

[^1]: Clicking the `Run in Postman` button navigates to the page where you can fork the collection to your workspace.
[Forking the collection](https://learning.postman.com/docs/collaborating-in-postman/version-control-for-collections/#forking-a-collection)
into your workspace will enable you to contribute to the source collection using pull requests. You can also view the
collection in a public workspace if you like and even import a copy of the collection using the links present on the
screen.

## Built With

* [Spring Boot v2.6+](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/)
* [Dummy4j](https://daniel-frak.github.io/dummy4j/)