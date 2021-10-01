CREATE TABLE colaborador(
    id int not null primary key,
    nome varchar(150),
    numero_da_matriculo varchar(20),
    endereco_de_email varchar(150),
    senha_de_login varchar(50),
    id_equipe int not null,
    constraint equipe_fk
        foreign key(id_equipe)
            references equipe(id),
    id_comentario int not null,
    constraint comentario_fk
        foreign key(id_comentario)
            references comentario(id)
);

CREATE TABLE equipe(
    id int not null primary key,
    id_coordenador int not null,
    constraint coordenador_fk
        foreign key(id_coordenador)
            references coordenador(id)
);

CREATE TABLE coordenador(
    id int not null primary key,
    id_projeto int not null,
    constraint projeto_fk
        foreign key(id_projeto)
            references projeto(id)
);

CREATE TABLE projeto(
    id int not null primary key,
    horario int not null,
    ordem_cronologica varchar(20),
    data_projeto varchar(10),
    id_categoria int not null,
    constraint categoria_fk
        foreign key(id_categoria)
            references categoria(id),
    id_comentario int not null,
    constraint comentario_fk
        foreign key(id_comentario)
            references comentario(id)
);

CREATE TABLE categoria(
    id int not null primary key,
    melhorias_social varchar(1000),
    melhorias_processo varchar(1000),
);

CREATE TABLE comentario(
    id int not null primary key,
);


