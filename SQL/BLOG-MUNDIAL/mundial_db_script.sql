BEGIN;


CREATE TABLE IF NOT EXISTS public.equipos
(
    id serial,
    nombre_equipo character varying(50) NOT NULL,
    id_grupo integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.grupos
(
    id serial,
    nombre_grupo character(1) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.partidos
(
    id serial,
    id_fase integer NOT NULL,
    id_equipo_1 integer NOT NULL,
    id_equipo_2 integer NOT NULL,
    fecha timestamp without time zone NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.resultados
(
    id serial,
    id_partido integer NOT NULL,
    goles_equipo_1 integer NOT NULL,
    goles_equipo_2 integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.fases
(
    id serial,
    nombre_fase character(1)[] NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.equipos
    ADD FOREIGN KEY (id_grupo)
    REFERENCES public.grupos (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.partidos
    ADD FOREIGN KEY (id_fase)
    REFERENCES public.fases (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.partidos
    ADD FOREIGN KEY (id_equipo_1)
    REFERENCES public.equipos (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.partidos
    ADD FOREIGN KEY (id_equipo_2)
    REFERENCES public.equipos (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE public.partidos
ADD CONSTRAINT chk_equipos_distintos CHECK (id_equipo_1 <> id_equipo_2);

ALTER TABLE IF EXISTS public.resultados
    ADD FOREIGN KEY (id_partido)
    REFERENCES public.partidos (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

END;