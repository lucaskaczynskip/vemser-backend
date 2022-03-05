CREATE TABLE VEM_SER.PAIS (
	id_pais NUMBER(38) PRIMARY KEY NOT NULL,
	nome VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE VEM_SER.ESTADO (
	id_estado NUMBER(38) PRIMARY KEY NOT NULL,
	id_pais NUMBER(38) NOT NULL,
	nome VARCHAR2(50) UNIQUE NOT NULL,
	
	CONSTRAINT FK_ESTADO_ID_PAIS FOREIGN KEY (id_pais) REFERENCES PAIS (id_pais)
);

CREATE TABLE VEM_SER.CIDADE (
	id_cidade NUMBER(38) NOT NULL,
	id_estado NUMBER(38) NOT NULL,
	nome VARCHAR2(50) NOT NULL,
	PRIMARY KEY (id_cidade, id_estado)
);

CREATE TABLE VEM_SER.BAIRRO (
	id_bairro NUMBER(38) NOT NULL,
	id_cidade NUMBER(38) NOT NULL,
	id_estado NUMBER(38) NOT NULL,
	nome VARCHAR2(50) NOT NULL,
	PRIMARY KEY (id_bairro, id_cidade),
	
	CONSTRAINT FK_BAIRRO_ID_ESTADO FOREIGN KEY (id_estado) REFERENCES ESTADO (id_estado)
);

CREATE TABLE VEM_SER.ENDERECO (
	id_endereco NUMBER(38) NOT NULL,
	id_bairro NUMBER(38) NOT NULL,
	id_cidade NUMBER(38) NOT NULL,
	logradouro VARCHAR2(255) NOT NULL,
	numero NUMBER(38) NOT NULL,
	complemento VARCHAR2(100) NOT NULL,
	cep CHAR(9),
	
	PRIMARY KEY (id_endereco),
	CONSTRAINT FK_ENDERECO_ID_BAIRRO FOREIGN KEY (id_bairro, id_cidade) REFERENCES BAIRRO (id_bairro, id_cidade)
);

CREATE SEQUENCE seq_pais
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE seq_estado
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE seq_cidade
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE seq_bairro
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE seq_endereco
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;


INSERT INTO PAIS VALUES (VEM_SER.seq_pais.nextval, 'Brasil');
INSERT INTO ESTADO VALUES (VEM_SER.seq_estado.nextval, 1, 'Rio Grande do Sul');
INSERT INTO ESTADO VALUES (VEM_SER.seq_estado.nextval, 1, 'São Paulo');
INSERT INTO CIDADE VALUES (VEM_SER.seq_cidade.nextval, 1, 'Porto Alegre');
INSERT INTO CIDADE VALUES (VEM_SER.seq_cidade.nextval, 2, 'São Paulo');
INSERT INTO BAIRRO VALUES (VEM_SER.seq_bairro.nextval, 1, 1, 'Vila Ipiranga');
INSERT INTO BAIRRO VALUES (VEM_SER.seq_bairro.nextval, 2, 2, 'Mirandópolis');
INSERT INTO ENDERECO VALUES (VEM_SER.seq_endereco.nextval, 1, 1, 'Av. do Forte', 895, 'de 895/896 ao fim', '91360-001');
INSERT INTO ENDERECO VALUES (VEM_SER.seq_endereco.nextval, 1, 1, 'Beco Um', 2000, 'Viela da Alegria', '91330-780');
INSERT INTO ENDERECO VALUES (VEM_SER.seq_endereco.nextval, 2, 2, 'Rua Olímpia Golfeto dos Santos', 281, 'Centro', '16820-970');
INSERT INTO ENDERECO VALUES (VEM_SER.seq_endereco.nextval, 2, 2, 'Rua Nagata', 211, 's/n', '16830-971');

INSERT INTO PAIS VALUES (VEM_SER.seq_pais.nextval, 'Argentina');
INSERT INTO ESTADO VALUES (VEM_SER.seq_estado.nextval, 2, 'Buenos Aires');
INSERT INTO ESTADO VALUES (VEM_SER.seq_estado.nextval, 2, 'Santa Fé');
INSERT INTO CIDADE VALUES (VEM_SER.seq_cidade.nextval, 3, 'Buenos Aires');
INSERT INTO CIDADE VALUES (VEM_SER.seq_cidade.nextval, 4, 'Santa Fé');
INSERT INTO BAIRRO VALUES (VEM_SER.seq_bairro.nextval, 3, 3, 'San Telmo');
INSERT INTO BAIRRO VALUES (VEM_SER.seq_bairro.nextval, 4, 4, 'Acindar');
INSERT INTO ENDERECO VALUES (VEM_SER.seq_endereco.nextval, 3, 3, 'Mercado de San Telmo', 963, 'Defensa', ' 9549709');
INSERT INTO ENDERECO VALUES (VEM_SER.seq_endereco.nextval, 3, 3, 'Rua Chile', 371, 'Escultura Mafalda', ' 9549819');
INSERT INTO ENDERECO VALUES (VEM_SER.seq_endereco.nextval, 4, 4, 'Av Liberdad', 972, 'centro', '2149709');
INSERT INTO ENDERECO VALUES (VEM_SER.seq_endereco.nextval, 4, 4, 'Rua Juan', 111, ' ', '93709');

SELECT * FROM PAIS ORDER BY nome DESC;
SELECT logradouro, cep FROM ENDERECO WHERE UPPER(logradouro) LIKE 'A%';
SELECT * FROM ENDERECO WHERE cep LIKE '%0';
SELECT * FROM ENDERECO WHERE numero BETWEEN 1 AND 100;
SELECT * FROM ENDERECO WHERE UPPER(logradouro) LIKE 'RUA%' ORDER BY cep DESC; 
SELECT COUNT(*) FROM ENDERECO;
SELECT COUNT(*) FROM ENDERECO GROUP BY id_cidade;

UPDATE ENDERECO e
SET 	
	e.logradouro = 'atualizado',
	e.complemento = 'novo'
WHERE 
	e.id_endereco = 2 OR e.id_endereco = 3;

UPDATE ENDERECO e
SET e.numero = 99999
WHERE e.id_endereco = 4; 
	
DELETE FROM ENDERECO e WHERE e.id_endereco = (SELECT MAX(id_endereco) FROM ENDERECO); 
DELETE FROM ENDERECO e WHERE e.numero = 99999;
DELETE FROM ENDERECO e;

SELECT p.nome
FROM PESSOA p
CROSS JOIN (SELECT c.numero FROM CONTATO c);


