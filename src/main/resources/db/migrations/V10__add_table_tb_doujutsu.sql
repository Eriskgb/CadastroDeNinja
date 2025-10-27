/*Criando nova tabela para cadastro de Doujutsu e criando chave estrangeira com NinjaModel*/

CREATE TABLE tb_doujutsu (
    id INT PRIMARY KEY,
    nome VARCHAR(255)
);

ALTER TABLE tb_doujutsu
ADD COLUMN doujutsu_id BIGINT;

ALTER TABLE tb_doujutsu
ADD CONSTRAINT fk_doujutsu
FOREIGN KEY (doujutsu_id)
REFERENCES tb_doujutsu(id);