# Installing a Postgresql Docker image

Section 2 of the course (Data Access in Spring) makes use of a remote (i.e. not in-memory) Postgresql database. 
I installed a Postgresql Docker image for that purpose.   

## Install Docker Desktop for Mac

https://docs.docker.com/docker-for-mac/install/

```
$ docker --version
```

## Common Docker commands

Installed images / running containers:

```
$ docker image ls
$ docker container ls
$ docker ps
$ docker container ls -a
```

Images available in the Docker hub repository: 

https://hub.docker.com/search?q=&type=image

## Postgresql

https://hub.docker.com/_/postgres?tab=description

Download postgres image and run it

```
$ docker pull postgres
$ docker run --name postgres-spring-boot -e POSTGRES_PASSWORD=secret -d postgres
```

## Removing containers and images

```
$ docker container stop <name>
$ docker container rm <name>
$ docker image rm <name>
```

## Installing psql (Postgresql client)

```
$ brew install libpq
```

NB: Manually added libpq/bin to $PATH in .bashrc.
