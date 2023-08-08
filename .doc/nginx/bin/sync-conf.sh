#!/bin/bash
# 同步生产服务器 42.192.222.62 nginx 配置

PRO_PATH="/Users/fusheng/WorkSpace/CompanyWork/work-fusheng/core-pro"
# shellcheck disable=SC2164
cd ${PRO_PATH}/code-springboot-model/.doc/nginx/bin
# 同步配置
rsync -avz -e 'ssh -p 22221' --progress ../conf.d/ root@42.192.222.62:/etc/nginx/conf.d

rsync -avz --progress file.conf root@47.111.158.6:/etc/nginx/conf.d