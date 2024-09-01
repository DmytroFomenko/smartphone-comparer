
create table smartphone
(
    performance_cpu    smallint,
    gaming_performance smallint,
    id                 bigserial
        primary key,
    company_id         bigint
        constraint smartphone_companies_id_fk
        references company,
    model_id           bigint
        constraint smartphone_models_id_fk
        references model,
    camera             smallint
);

alter table smartphone
    owner to postgres;



create table model
(
    id         bigint default nextval('models_id_seq'::regclass) not null
        constraint model_pk
            primary key,
    model_name varchar(70)                                       not null
);



alter table model
    owner to postgres;

create table company
(
    id           bigint default nextval('companies_id_seq'::regclass) not null
        constraint company_pk
            primary key,
    company_name varchar(50)                                          not null
);

alter table company
    owner to postgres;

