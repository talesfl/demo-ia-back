#### Projeto

Projeto criado com o intúito de particifar de um procesos seletivo.

Projeto tenta integrar as tecnologias: Spring Boot, Redis, Kafka e Angular


Execução:

```
java -jar <nome arquivo>.jar
```


#### OS

```
Linux maquina 5.4.0-77-generic #86-Ubuntu x86_64 x86_64 x86_64 GNU/Linux

```

#### Java

```
openjdk version "11.0.11" 2021-04-20
OpenJDK Runtime Environment (build 11.0.11+9-Ubuntu-0ubuntu2.20.04)
OpenJDK 64-Bit Server VM (build 11.0.11+9-Ubuntu-0ubuntu2.20.04, mixed mode, sharing)

```

#### Rodar a aplicação e application.properties fora do jar

```
 java -jar myproject.jar --spring.config.location=file:///Users/home/config
```
ou

```
mvn spring-boot:run -Dspring.config.location="file:///Users/home/application.properties"
```
ou

```
export SPRING_CONFIG_NAME=application
export SPRING_CONFIG_LOCATION=file:///Users/home/config
java -jar app.jar
```

#### RabbitMQ

Foi instalado diretamente na máquina: 

```
RabbitMQ 3.8.2
```


#### Redis

Foi instalado diretamento na máquina:

```
Redis server v=5.0.7 sha=00000000:0 malloc=jemalloc-5.2.1 bits=64 build=636cde3b5c7a3923
```

#### Kafka

Baixar o arquivo em [Kafka](https://kafka.apache.org/downloads) e escolher a versão kafka_2.13-2.8.0.tgz

Existe uma tutorial para iniciar o servico [Quick Start](https://kafka.apache.org/quickstart)

Inciar o Zookeper:

```
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```

Inciar o Kafka:

```
$ bin/kafka-server-start.sh config/server.properties
```


