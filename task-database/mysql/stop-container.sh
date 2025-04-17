#!/bin/bash

CONTAINER_NAME=$1

# 컨테이너가 실행 중이면 중지
if podman ps -q --filter "name=$CONTAINER_NAME"; then
  echo "Stopping container: $CONTAINER_NAME"
  podman stop $CONTAINER_NAME
  podman rm $CONTAINER_NAME
else
  echo "No running container found with the name $CONTAINER_NAME"
fi

# 포트(3306) 해제
echo "Releasing port 3306"
sudo iptables -t nat -D PREROUTING -p tcp --dport 3306 -j REDIRECT --to-ports 3306

# 확인 메시지
echo "Port 3306 has been released."