FROM jboss/wildfly:latest
MAINTAINER Douglas Marques 
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
#ADD client.war /opt/jboss/wildfly/standalone/deployments
#VOLUME /opt/wildfly/logs
#EXPOSE 8080