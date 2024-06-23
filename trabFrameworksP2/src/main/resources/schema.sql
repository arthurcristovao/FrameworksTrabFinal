CREATE DATABASE IF NOT EXISTS trabtiagoframeworks;
USE trabtiagoframeworks;

CREATE TABLE IF NOT EXISTS Pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Tarefa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idPessoa INT NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    descricao TEXT,
    dataHora DATE,
    FOREIGN KEY (idPessoa) REFERENCES Pessoa(id) ON DELETE CASCADE
);
