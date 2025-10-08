ALTER TABLE tb_ninja
ADD COLUMN aldeia_id BIGINT;

ALTER TABLE tb_ninja
ADD CONSTRAINT fk_aldeia
FOREIGN KEY (aldeia_id)
REFERENCES tb_aldeia(id);