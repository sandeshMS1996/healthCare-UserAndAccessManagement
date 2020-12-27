/*drop table oauth_access_token;
drop table if EXISTS oauth_refresh_token;


create table oauth_access_token(
                                   token_id varchar(100) primary key ,
                                   token VARBINARY(1000),
                                   authentication_id varchar(100),
                                   user_name varchar(10),
                                   client_id varchar(10),
                                   authentication VARBINARY(10000),
                                   refresh_token varchar(100)
);

create table oauth_refresh_token(
                                    token_id varchar(100) primary key not null,
                                    token varbinary(1000),
                                    authentication VARBINARY(10000));*/