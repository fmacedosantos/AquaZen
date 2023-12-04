/*
CREATE, ALTER, DROP
*/
create schema aquazen;
use aquazen;
CREATE TABLE paciente
(
codigo INT PRIMARY KEY AUTO_INCREMENT, 
objetivo VARCHAR(20) NOT NULL,
nome VARCHAR(255) NOT NULL,
telefone VARCHAR(15) NOT NULL,
sexo VARCHAR(9) NOT NULL,
tipoAtividade VARCHAR(20) NOT NULL,
servico1 varchar(255),
servico2 varchar(255) DEFAULT 'Serviço ñ selecionado',
servico3 varchar(255) DEFAULT 'Serviço ñ selecionado',
peso float CHECK (peso > 0),
altura float CHECK (altura > 0),
pesoIdeal float CHECK (pesoIdeal > 0)
);






