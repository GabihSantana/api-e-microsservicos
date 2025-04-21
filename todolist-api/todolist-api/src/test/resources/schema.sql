CREATE TABLE tarefa(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    prioridade VARCHAR(50) NOT NULL,
    data_limite DATE,
    concluida BOOLEAN DEFAULT FALSE,
    categoria VARCHAR(255) NOT NULL,
    criada_em DATE
);