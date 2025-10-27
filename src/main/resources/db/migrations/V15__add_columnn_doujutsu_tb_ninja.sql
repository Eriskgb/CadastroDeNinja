ALTER TABLE tb_ninja ADD COLUMN doujutsu_id BIGINT;

ALTER TABLE tb_ninja ADD CONSTRAINT fk_ninja_doujutsu
FOREIGN KEY (doujutsu_id) REFERENCES tb_doujutsu(id);
