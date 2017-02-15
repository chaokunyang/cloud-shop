1、在hosts文件配置域名映射
127.0.0.1 eureka1
127.0.0.1 eureka2

2、激活profile方式
java -jar eureka-server-0.1.jar --spring.profiles.active=eureka1
java -jar eureka-server-0.1.jar --spring.profiles.active=eureka2
