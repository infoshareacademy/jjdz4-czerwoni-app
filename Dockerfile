FROM jboss/wildfly:11.0.0.Final

ADD config /opt/jboss/wildfly/config/

COPY web/target/web.war /opt/jboss/wildfly/config/
COPY api/target/api.war /opt/jboss/wildfly/config/

CMD ["/opt/jboss/wildfly/config/execute.sh"]

RUN mkdir ~/tmp