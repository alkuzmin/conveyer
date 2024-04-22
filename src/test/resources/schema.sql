CREATE TABLE IF NOT EXISTS artefact
(
	id serial PRIMARY KEY,
	name varchar(80)
);

insert into artefact (name) values ('tree'), ('crystal'), ('tree'),('tree'),('box');