阿里云加速器

https://5flt124z.mirror.aliyuncs.com

sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://5flt124z.mirror.aliyuncs.com"]
}
EOF


教程:https://www.cnblogs.com/morang/p/9501223.html
https://www.jianshu.com/p/ee608c756c1b

授权
sudo chmod +x /usr/local/bin/docker-compose