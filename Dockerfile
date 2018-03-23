FROM jboss/wildfly:11.0.0.Final

ADD config /opt/jboss/wildfly/config/

COPY web/target/web.war /opt/jboss/wildfly/config/
COPY api/target/api.war /opt/jboss/wildfly/config/

CMD ["/opt/jboss/wildfly/config/execute.sh"]

RUN mkdir ~/tmp

#RUN { \
#    echo '[mysqld]'; \
#    echo 'character-set-server = utf8mb4'; \
#    echo 'collation-server = utf8_unicode_ci'; \
#    echo '[client]'; \
#    echo 'default-character-set=utf8mb4'; \
#    echo '[mysql]'; \
#    echo 'default-character-set=utf8mb4'; \
#} > /etc/mysql/my.cnf
#
#VOLUME /var/lib/mysql