-- 1. Remover a chave estrangeira que depende da chave primária
ALTER TABLE tb_doujutsu DROP CONSTRAINT FK_DOUJUTSU;

-- 2. Remover a chave primária
ALTER TABLE tb_doujutsu DROP CONSTRAINT CONSTRAINT_5B;

-- 3. Alterar o tipo da coluna
ALTER TABLE tb_doujutsu ALTER COLUMN id BIGINT;

-- 4. Recriar a chave primária
ALTER TABLE tb_doujutsu ADD PRIMARY KEY (id);

-- 5. Recriar a chave estrangeira
ALTER TABLE tb_doujutsu ADD CONSTRAINT FK_DOUJUTSU
FOREIGN KEY (doujutsu_id) REFERENCES tb_doujutsu(id);
