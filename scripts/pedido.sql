create table pedido
(
    id              bigint auto_increment
        primary key,
    data_entrega    date           null,
    descricao       varchar(255)   null,
    nome_produto    varchar(255)   null,
    url_imagem      varchar(255)   null,
    url_produto     varchar(255)   null,
    valor           decimal(19, 2) null,
    valor_negociado decimal(19, 2) null,
    status_pedido   varchar(255)   null,
    user_username   varchar(255)   null,
    constraint FKjgvb1pj32pv4ub09dofgm2eoh
        foreign key (user_username) references users (username)
)
    auto_increment = 26;