create table Usuarios
(
    id       uuid primary key,
    username varchar(200) not null,
    password varchar(200) not null
);

create table Cargo
(
    id        uuid primary key,
    titulo    varchar(200) not null,
    descricao varchar(200)
);

create table Funcionario
(
    id           uuid primary key,
    usuarioId    uuid references Usuarios (id),
    cargoId      uuid references Cargo (id),
    dataAdmissao date           not null,
    dataDemissao date,
    salario      numeric(10, 2) not null
);

create table Administrador
(
    id        uuid primary key,
    usuarioId uuid references Usuarios (id)
);

create table Produto
(
    id        uuid primary key,
    nome      varchar(200)   not null,
    descricao varchar(200),
    preco     numeric(10, 2) not null
);

create table Pedido
(
    id          uuid primary key,
    nomeCliente varchar(200) not null,
    cpfCliente  varchar(11)  not null
);


create table ProdutoItem
(
    id        uuid primary key,
    idProduto uuid references Produto (id) not null
);

create table PedidoProduto
(
    id         uuid primary key,
    idPedido   uuid references Pedido (id)  not null,
    idProduto  uuid references Produto (id) not null,
    quantidade numeric                      not null
);


