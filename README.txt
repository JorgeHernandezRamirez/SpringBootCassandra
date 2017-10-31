cat /etc/cassandra/cassandra.yaml | grep authenticator
authenticator: AllowAllAuthenticator (Se puede autenticar con cualquier usuario)

-> Login con usuario por defecto
cqlsh -u cassandra -p cassandra

-> Crear usuario
create user jorge with password 'password' superuser;

-> Mostrar keyspaces
describe keyspaces

-> Crear keyspace
create keyspace localkeyspace with replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};

-> Usar localkeyspace
use localkeyspace;

-> Crear tabla
CREATE TABLE user (
  id uuid,
  username varchar,
  password varchar,
  PRIMARY KEY (id)
);

CREATE INDEX indx_user_username ON user (username);

insert into user (id, username, password) values(fb008464-be46-11e7-abc4-cec278b6b50a, 'Jorge', '1234');

Para evitar ClassNotFound io.netty:netty-all crear RestTemplateConfiguration

https://github.com/spring-projects/spring-boot/issues/7240

-> Mostrar tablas
describe tables
