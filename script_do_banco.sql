-- Criando a tabela de pessoas

CREATE TABLE public."Pessoas"
(
   id INTEGER NOT NULL, 
   nome CHARACTER VARYING(30) NOT NULL, 
   idade INTEGER NOT NULL, 
   sexo CHARACTER VARYING(20) NOT NULL, 
   PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)
;
COMMENT ON COLUMN public."Pessoas".id IS 'id da pessoa';
COMMENT ON COLUMN public."Pessoas".nome IS 'nome da pessoa';
COMMENT ON COLUMN public."Pessoas".idade IS 'idade da pessoa';
COMMENT ON COLUMN public."Pessoas".sexo IS 'sexo da pessoa';
COMMENT ON TABLE public."Pessoas"
  IS 'Tabela de Pessoas';


-- inserte na tabela de pessoas, para teste 

INSERT INTO public."Pessoas" ( id, nome, idade, sexo ) VALUES ( 1, 'Teste 01', 21, 'M');
INSERT INTO public."Pessoas" ( id, nome, idade, sexo ) VALUES ( 2, 'Teste 02', 45, 'F');
INSERT INTO public."Pessoas" ( id, nome, idade, sexo ) VALUES ( 3, 'Teste 03', 15, 'M');
INSERT INTO public."Pessoas" ( id, nome, idade, sexo ) VALUES ( 4, 'Teste 04', 18, 'F');
INSERT INTO public."Pessoas" ( id, nome, idade, sexo ) VALUES ( 5, 'Teste 05', 90, 'M');
INSERT INTO public."Pessoas" ( id, nome, idade, sexo ) VALUES ( 6, 'Teste 06', 62, 'F');
INSERT INTO public."Pessoas" ( id, nome, idade, sexo ) VALUES ( 7, 'Teste 07', 07, 'M');

-- Criando a função que fara o select na tabela de pessoas filtrado pelo sexo da pessoa

CREATE OR REPLACE FUNCTION buscarPessoasPorSexo(genero VARCHAR) RETURNS SETOF public."Pessoas" AS $$
BEGIN
	RETURN QUERY 

        SELECT pessoa.id,
               pessoa.nome,
               pessoa.idade,
               pessoa.sexo
        
        FROM public."Pessoas" AS pessoa
        
        WHERE pessoa.sexo = genero;
	
	RETURN;
END;
$$ LANGUAGE 'plpgsql'
