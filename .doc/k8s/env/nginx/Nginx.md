> 创建配置挂载
```shell
$ kubectl create configmap nginx-conf --from-file=../nginx/conf.d/default.conf -n env-test
$ kubectl create configmap nginx-html --from-file=../nginx/html -n env-test
# 删除指令
$ kubectl delete configmap nginx-conf -n env-test
$ kubectl delete configmap nginx-html -n env-test
# 查看文件挂载情况
$ kubectl exec -it nginx-7f8b95c5bb-226b4 -n env-test -- ls -lA /usr/share/nginx/html/
$ kubectl exec nginx-7f8b95c5bb-226b4 -n env-test -- nginx -T
# 编辑 cm
$ kubectl edit configmaps/nginx-html -n env-test
# 刷新 nginx 
$ kubectl exec -it nginx-7f8b95c5bb-226b4 -n env-test -- nginx -s reload
```

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: nginx
  namespace: env-test
  labels:
    app: nginx
spec:
  replicas: 1
  selector:
    matchLabels:
      app: nginx
  template:
    metadata:
      labels:
        app: nginx
    spec:
      containers:
      - name: nginx
        image: nginx:latest
        ports:
        - containerPort: 80
        volumeMounts:
        - name: nginx-conf
          mountPath: /etc/nginx/conf.d
        - name: nginx-html
          mountPath: /usr/share/nginx/html
      volumes:
      - name: nginx-conf
        configMap:
          name: nginx-conf
      - name: nginx-html
        configMap:
          name: nginx-html
      restartPolicy: Always
---
apiVersion: v1
kind: Service
metadata:
  name: nginx-service
  namespace: env-test
spec:
  type: NodePort
  selector:
    app: nginx
  ports:
    - protocol: TCP
      port: 80
      targetPort: 80
      nodePort: 30080
```