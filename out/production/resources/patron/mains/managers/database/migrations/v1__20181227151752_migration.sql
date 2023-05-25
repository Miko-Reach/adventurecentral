
    create table event (
       id bigint not null auto_increment,
        createdAt datetime,
        updatedAt datetime,
        agentCommission double precision,
        agentReduction double precision,
        title varchar(255),
        type varchar(255),
        createdBy_id bigint,
        primary key (id)
    ) engine=MyISAM;

    create table log (
       id bigint not null auto_increment,
        createdAt datetime,
        updatedAt datetime,
        exception TEXT,
        level varchar(255),
        message TEXT,
        section varchar(255),
        primary key (id)
    ) engine=MyISAM;

    create table role (
       id bigint not null auto_increment,
        createdAt datetime,
        updatedAt datetime,
        roleName integer,
        primary key (id)
    ) engine=MyISAM;

    create table ticket (
       id bigint not null auto_increment,
        createdAt datetime,
        updatedAt datetime,
        description varchar(255),
        price double precision,
        reserved bit,
        title varchar(255),
        type varchar(255),
        createdBy_id bigint,
        event_id bigint,
        reservedBy_id bigint,
        primary key (id)
    ) engine=MyISAM;

    create table user (
       id bigint not null auto_increment,
        createdAt datetime,
        updatedAt datetime,
        login varchar(255),
        password varchar(255),
        primary key (id)
    ) engine=MyISAM;

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=MyISAM;

    alter table event 
       add constraint FKpx2xfwvff7xbgtfhojcgc1rq9 
       foreign key (createdBy_id) 
       references user (id);

    alter table ticket 
       add constraint FKnph0xyheva98y5u01muoy4836 
       foreign key (createdBy_id) 
       references user (id);

    alter table ticket 
       add constraint FKfytuhjopeamxbt1cpudy92x5n 
       foreign key (event_id) 
       references event (id);

    alter table ticket 
       add constraint FKk8np3paq6v0jjy28n3oxlisvw 
       foreign key (reservedBy_id) 
       references user (id);

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id);

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id);
