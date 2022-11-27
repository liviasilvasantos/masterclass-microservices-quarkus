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

--

Livenesse Probe: indica se a app está viva, rodando. Kubernetes checa de tempos em tempos se a app está up, senão, o Kubernetes vai restartar o pod. Exposto em um endpoint.

Readiness Probe: indica se a app está pronta para receber requests, dependendo da regra de negócio de cada app. Kubernetes checa de tempos em tempos se a app está pronta, mas não faz nada. Exposto em um endpoint.

SmallRye = implementação do microprofile disponível no quarkus. 

