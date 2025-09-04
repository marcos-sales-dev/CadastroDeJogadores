
-- V2: Migrations para adicionar a coluna de RANK na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);

-- A migration é imutavel, não podemos adicionar mais nada nessa versão de tabela