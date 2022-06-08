# Highlevel Architecture Design

![image](https://user-images.githubusercontent.com/3886381/172467340-4fb5da94-cc11-4ec6-ab5c-596d44fe21e0.png)

## Distributed Tracing 

![image](https://user-images.githubusercontent.com/3886381/172703604-c2aa88dc-580d-4b4f-a9ab-4f8374364375.png)

## ELK Stack

- Microservices will produce the logs and send them to log stash over TCP.
- And then, log stash will forward these logs to elastic search
- Since, multiple services are there, hence logs of each service will be sent to separate index in elastic search.

![image](https://user-images.githubusercontent.com/3886381/172705471-2fd87b10-7126-42fc-9497-c48d593b8f8b.png)

## Kibana Logs

![image](https://user-images.githubusercontent.com/3886381/172717273-3cb76180-acff-40f9-865c-6335b9de517b.png)

## Containers

<img width="1463" alt="image" src="https://user-images.githubusercontent.com/3886381/172717573-5bed6856-b157-41ed-95da-643692c8b0b8.png">