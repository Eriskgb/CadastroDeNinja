ALTER TABLE tb_ninja
ADD COLUMN jinchuriki_id BIGINT;

ALTER TABLE tb_ninja
ADD CONSTRAINT fk_jinchuriki
FOREIGN KEY (jinchuriki_id)
REFERENCES tb_biju(id);