> 创建配置
```shell
kubectl create cm rabbit-plugins --from-literal=enabled_plugins="[rabbitmq_shovel,rabbitmq_shovel_management]."
```

> YAML 服务编排配置
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  namespace: env-test
  name: rabbitmq
  labels:
    app: rabbitmq
spec:
  replicas: 1
  selector:
    matchLabels:
      app: rabbitmq
  template:
    metadata:
      labels:
        app: rabbitmq
    spec:
      hostname: simple-rabbit
      containers:
      - name: rabbitmq
        image: rabbitmq:3.9-management
        ports:
        - name: rabbitmq-ui
          containerPort: 15672
        - name: rabbitmq-server
          containerPort: 5672
        env:
        - name: RABBITMQ_DEFAULT_VHOST
          value: "test"
        - name: RABBITMQ_DEFAULT_USER
          value: "guest"
        - name: RABBITMQ_DEFAULT_PASS
          value: "guest"
---
apiVersion: v1
kind: Service
metadata:
  name: rabbitmq-ui
  namespace: env-test
spec:
  ports:
  - port: 15672
    nodePort: 15673
  selector:
    app: rabbitmq
  type: NodePort
---
apiVersion: v1
kind: Service
metadata:
  name: rabbitmq-server
  namespace: env-test
spec:
  ports:
  - port: 5672
    nodePort: 5673
  selector:
    app: rabbitmq
  type: NodePort
```