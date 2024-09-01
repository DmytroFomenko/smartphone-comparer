CREATE TABLE IF NOT EXISTS public.smartphone
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    company character varying(50) COLLATE pg_catalog."default" NOT NULL,
    model character varying(70) COLLATE pg_catalog."default" NOT NULL,
    performance integer NOT NULL,
    price double precision NOT NULL,
    CONSTRAINT smartphone_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.smartphone
    OWNER to postgres;
