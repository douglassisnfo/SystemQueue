FROM webcenter/activemq:latest
MAINTAINER Douglas Marques 
#PORTS
EXPOSE 8161 61616 61613

docker run --name='activemq' -d -e 'ACTIVEMQ_ADMIN_LOGIN=admin' -e 'ACTIVEMQ_ADMIN_PASSWORD=your_password'-p 8161:8161 -p 61616:61616 -p 61613:61613