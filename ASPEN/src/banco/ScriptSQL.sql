/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Aluno
 * Created: 13 de mar. de 2023
 */

CREATE DATABASE aspen;

use aspen;

CREATE TABLE cliente(
	cod_cliente int not null primary key auto_increment,
    nome varchar(50) not null,
    cpf varchar(14) not null,
    telfone varchar(17) not null,
    endereco varchar(50) not null,
    cidade varchar(50) not null,
    estado varchar(2) not null,
    cep varchar(9) not null,
    senha varchar(8) not null,
    email varchar(50) not null
);