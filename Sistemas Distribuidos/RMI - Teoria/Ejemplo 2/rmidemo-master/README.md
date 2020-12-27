# rmidemo

This project contains a small demo of Java RMI. You can run it in your own way (in this case still reading is not necessary) or you can use the provided Dockerfile and run it with the provided steps below.

## Requirements

* [Docker](https://www.docker.com/)

## Run

Open 2 shells, go to the root project folder and execute the commands on the indicated shell.

### Shell #1

```bash
    docker build . -t rmidemo
    docker run -d rmidemo
```

The last command will return an ID. Copy it we will refer it as **\<container-id\>**  in the following steps. This ID refers to the container id which currently is running the rmiregistry and where we will execute the 2 processes.

```bash
    docker exec <container-id> /bin/sh startAlice.sh
```

### Shell #2

```bash
    docker exec <container-id> /bin/sh startBob.sh
```

To kill the docker container just run

```bash
    docker kill <container-id>
```