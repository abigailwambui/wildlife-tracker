--
-- PostgreSQL database dump
--

-- Dumped from database version 10.8 (Ubuntu 10.8-0ubuntu0.18.10.1)
-- Dumped by pg_dump version 10.8 (Ubuntu 10.8-0ubuntu0.18.10.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: abigail
--

CREATE TABLE public.animals (
    id integer NOT NULL,
    name character varying,
    health character varying,
    age character varying,
    sightingid integer
);


ALTER TABLE public.animals OWNER TO abigail;

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: abigail
--

CREATE SEQUENCE public.animals_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.animals_id_seq OWNER TO abigail;

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: abigail
--

ALTER SEQUENCE public.animals_id_seq OWNED BY public.animals.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: abigail
--

CREATE TABLE public.sightings (
    id integer NOT NULL,
    location character varying,
    rangername character varying,
    date timestamp without time zone
);


ALTER TABLE public.sightings OWNER TO abigail;

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: abigail
--

CREATE SEQUENCE public.sightings_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sightings_id_seq OWNER TO abigail;

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: abigail
--

ALTER SEQUENCE public.sightings_id_seq OWNED BY public.sightings.id;


--
-- Name: species; Type: TABLE; Schema: public; Owner: abigail
--

CREATE TABLE public.species (
    id integer NOT NULL,
    name character varying,
    population integer,
    endangered boolean,
    sightingid integer
);


ALTER TABLE public.species OWNER TO abigail;

--
-- Name: species_id_seq; Type: SEQUENCE; Schema: public; Owner: abigail
--

CREATE SEQUENCE public.species_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.species_id_seq OWNER TO abigail;

--
-- Name: species_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: abigail
--

ALTER SEQUENCE public.species_id_seq OWNED BY public.species.id;


--
-- Name: animals id; Type: DEFAULT; Schema: public; Owner: abigail
--

ALTER TABLE ONLY public.animals ALTER COLUMN id SET DEFAULT nextval('public.animals_id_seq'::regclass);


--
-- Name: sightings id; Type: DEFAULT; Schema: public; Owner: abigail
--

ALTER TABLE ONLY public.sightings ALTER COLUMN id SET DEFAULT nextval('public.sightings_id_seq'::regclass);


--
-- Name: species id; Type: DEFAULT; Schema: public; Owner: abigail
--

ALTER TABLE ONLY public.species ALTER COLUMN id SET DEFAULT nextval('public.species_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: abigail
--

COPY public.animals (id, name, health, age, sightingid) FROM stdin;
\.


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: abigail
--

COPY public.sightings (id, location, rangername, date) FROM stdin;
\.


--
-- Data for Name: species; Type: TABLE DATA; Schema: public; Owner: abigail
--

COPY public.species (id, name, population, endangered, sightingid) FROM stdin;
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: abigail
--

SELECT pg_catalog.setval('public.animals_id_seq', 1, false);


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: abigail
--

SELECT pg_catalog.setval('public.sightings_id_seq', 1, false);


--
-- Name: species_id_seq; Type: SEQUENCE SET; Schema: public; Owner: abigail
--

SELECT pg_catalog.setval('public.species_id_seq', 1, false);


--
-- Name: animals animals_pkey; Type: CONSTRAINT; Schema: public; Owner: abigail
--

ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: sightings sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: abigail
--

ALTER TABLE ONLY public.sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- Name: species species_pkey; Type: CONSTRAINT; Schema: public; Owner: abigail
--

ALTER TABLE ONLY public.species
    ADD CONSTRAINT species_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

