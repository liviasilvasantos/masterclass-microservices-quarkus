# masterclass-microservices-quarkus
Masterclass do Elder Moraes sobre Microservices

https://code.quarkus.io/
- JAX-RS: REST endpoint framework
- Hibernate ORM with Panache
- JDBC Driver - H2
- RESTEasy Classic Json-B

> mvn quarkus:dev

> mvn quarkus:add-extension -Dextension="quarkus-hibernate-orm-panache"

> mvn quarkus:add-extension -Dextension="quarkus-jdbc-h2"

> mvn quarkus:add-extension -Dextension="quarkus-resteasy-jsonb"

> mvn quarkus:add-extension -Dextension="quarkus-smallrye-health"

http://localhost:8080/q/health 

> mvn quarkus:add-extension -Dextension="quarkus-smallrye-fault-tolerance"

> mvn quarkus:add-extension -Dextension="quarkus-container-image-jib, quarkus-kubernetes"

--

Livenesse Probe: indica se a app está viva, rodando. Kubernetes checa de tempos em tempos se a app está up, senão, o Kubernetes vai restartar o pod. Exposto em um endpoint.

Readiness Probe: indica se a app está pronta para receber requests, dependendo da regra de negócio de cada app. Kubernetes checa de tempos em tempos se a app está pronta, mas não faz nada. Exposto em um endpoint.

SmallRye = implementação do microprofile disponível no quarkus. 

Circuit Breaker

- requestVolumeThreshold = quantidade de requisições que serão a amostra. Se o valor for 4, no intervalo de 4 requisições, serão validados os outros parâmetros definidos no circuit breaker.

- failureRatio = qual a porcentagem de falha em relação ao seu threshold. Se o valor for 0.5, então se 50% das 4 requisições falharem, o circuito será aberto.

- defaly = depois de quantos milisegundos o circuito será testado novamente, se pode ser fechado. 

- successThreshold = define a amostra a ser considerada com sucesso após o delay para fechar novamente o circuito. 

--

Baixar client do OpenShift Container

https://access.redhat.com/downloads/content/290/ver=4.9/rhel---8/4.9.52/x86_64/product-software
oc-4.9.52-macosx.zip

> mvn clean package -Dquarkus.kubernetes.deploy=true


