# springboot 规则引擎

### docker 中如何设置docker
```
docker run \
        --name=redis_server \
        --hostname=fae21b885f4c \
        --mac-address=02:42:ac:11:00:02 \
        --env=PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin \
        --env=GOSU_VERSION=1.12 \
        --env=REDIS_VERSION=6.2.6 \
        --env=REDIS_DOWNLOAD_URL=http://download.redis.io/releases/redis-6.2.6.tar.gz \
        --env=REDIS_DOWNLOAD_SHA=5b2b8b7a50111ef395bf1c1d5be11e6e167ac018125055daa8b5c2317ae131ab \
        --volume=/data \
        --workdir=/data \
        -p 6379:6379 \
        --restart=no \
        --log-driver=journald \
        --detach=true \
        7faaec683238 \
        redis-server

```




