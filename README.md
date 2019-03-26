From SpringBatch folder:

Install mysql inside docker

MYSQL:
 - docker pull mysql
 - to see if downloaded: docker images 
 - docker run --name mysql-standalone -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest
 - check if container is running -> docker ps -a  
 - download mysql bench and try connecting mysql( username/password -> root)
 - create database 'test' as code connects to db test
 
SPRING-BATCH-DEMO: 

 - docker build -f Dockerfile -t spring-batch-demo .
 - docker run -t --name spring-batch-demo --link mysql-standalone:mysql -p 9090:9090 spring-batch-demo
 
localhost:9090/api/load 