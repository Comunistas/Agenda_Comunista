
use test;

drop database if exists bd_agenda_comunista;

create database bd_agenda_comunista;
use bd_agenda_comunista;

-- --------------------------------------------------------------------------------------------------
-- ------------------------------------------ TABLAS ------------------------------------------------
-- --------------------------------------------------------------------------------------------------
set foreign_key_checks=0;

create table tb_proyecto
(
cod_pro int auto_increment not null,
nom_pro varchar(200),
fec_ini_pro date,
fec_lim_pro date,
fec_fin_pro date,
llave varchar(50),
primary key (cod_pro)
);

create table tb_perfil
(
cod_per int auto_increment not null,
des_per varchar(70),
primary key(cod_per)
);

create table tb_tipo_documento
(
cod_tipo_doc int auto_increment not null,
des_tipo_doc varchar(20),
primary key (cod_tipo_doc)
);

create table tb_camarada
(
cod_cam char(10) not null,
nom_cam varchar(200),
ape_cam varchar(200),
tel_cam varchar(10),
pwd_cam varchar(30),
fec_ult_ing date,
primary key (cod_cam)
);

create table tb_tipo_dato
(
cod_pro int,
cod_td int not null, -- autoincrementado
des_td varchar(20) not null,
primary key (cod_pro, cod_td)
)ENGINE = innodb;

create table tb_estado
(
cod_est int auto_increment not null,
des_est varchar(50),
primary key (cod_est)
);

create table tb_actividad
(
cod_pro int not null, -- ref proyecto
cod_act int not null, -- autoincrementado
cod_cam char(10), -- ref comarada
des_act varchar(200),
fec_ini_act date not null,
fec_fin_act date,
tiempo_est_act varchar(50), -- tiempo estimado de actividad
cod_est int, -- ref estado
primary key(cod_pro, cod_act)
);

create table tb_vista
(
cod_pro int not null, -- ref proyecto
cod_vis int not null, -- autoincrementado
des_vis varchar(50),
primary key (cod_pro, cod_vis) 
);

create table tb_input
(
cod_pro int not null, -- ref proycto
cod_vis int not null, -- ref vista
cod_input int not null, -- autoincrementado
nom_input varchar(50) not null, 
cod_td int, -- ref td
primary key (cod_pro, cod_vis, cod_input)
);



create table tb_output
(
cod_pro int not null, -- ref proycto
cod_vis int not null, -- ref vista
cod_output int not null, -- autoincrementado
nom_output varchar(50) not null,
cod_td int, -- ref td
primary key (cod_pro, cod_vis, cod_output)
);

create table tb_variable
(
cod_pro int not null, -- ref proyecto
cod_var int not null, -- autoincrementado
nom_var varchar(50),
cod_td int, -- ref td
primary key (cod_pro, cod_var)
)ENGINE=INNODB;

create table tb_comentario
(
cod_pro int not null, -- ref proyecto
cod_com int not null, -- autoincrementado
des_com varchar(200),
primary key (cod_pro, cod_com)
);

create table tb_estandar
(
cod_pro int not null, -- ref proyecto
cod_est int not null, -- autoincrementado
des_est varchar(200),
primary key(cod_pro, cod_est)
);

create table tb_documento
(
cod_doc int auto_increment not null,
cod_pro int not null, -- ref proyecto
nom_doc varchar(20),
des_doc varchar(300),
cod_tipo_doc int, -- ref tipo_doc
adjunto longblob,
primary key(cod_doc)
);

create table tb_modificacion
(
cod_pro int not null, -- ref proyecto
cod_mod int not null, -- autincrementado
cod_cam char(10) not null, -- ref camarada
cod_act int not null, -- ref actividad
atendido int not null,
com_mod varchar(300),
primary key (cod_pro, cod_mod)
);

create table tb_proyecto_integrante
(
cod_pro int not null, -- ref proyecto
cod_cam char(10) not null, -- ref camarada
cod_per int, -- ref perfil
coordinador int,
primary key(cod_pro, cod_cam)
);

create table tb_dependencia_actividad
(
cod_pro int not null, -- ref proyecto
cod_act_dep int not null, -- ref actividad
cod_act int not null, -- ref actividad
primary key (cod_pro, cod_act_dep, cod_act)
);

create table tb_tema
(
cod_tema varchar(100) not null,
nom_tema varchar(30),
seleccionado int,
primary key (cod_tema)
);


-- --------------------------------------------------------------------------------------------------
-- ------------------------------------ DEPENDENCIAS ------------------------------------------------
-- --------------------------------------------------------------------------------------------------


alter table tb_actividad 
add constraint fk_act_pro foreign key (cod_pro) references tb_proyecto (cod_pro),
add constraint fk_act_com foreign key (cod_cam) references tb_camarada (cod_cam),
add constraint fk_act_est foreign key (cod_est) references tb_estado (cod_est);

alter table tb_tipo_dato 
add constraint fk_td_pro foreign key (cod_pro) references tb_proyecto (cod_pro);

alter table tb_vista
add constraint fk_vis_pro  foreign key (cod_pro) references tb_proyecto (cod_pro);

alter table tb_input
add constraint fk_input_vis foreign key (cod_pro, cod_vis) references tb_vista (cod_pro, cod_vis),
add constraint fk_input_td foreign key (cod_pro, cod_td) references tb_tipo_dato (cod_pro, cod_td);

alter table tb_output
add constraint fk_output_vis foreign key (cod_pro, cod_vis) references tb_vista (cod_pro, cod_vis),
add constraint fk_output_td foreign key (cod_pro, cod_td) references tb_tipo_dato (cod_pro, cod_td);

alter table tb_variable
add constraint fk_var_pro foreign key (cod_pro) references tb_proyecto (cod_pro),
add constraint fk_var_td foreign key (cod_pro, cod_td) references tb_tipo_dato (cod_pro, cod_td);

alter table tb_comentario
add constraint fk_com_pro foreign key (cod_pro) references tb_proyecto (cod_pro);

alter table tb_estandar
add constraint fk_est_pro foreign key (cod_pro) references tb_proyecto (cod_pro);

alter table tb_proyecto_integrante
add constraint fk_int_pro foreign key (cod_pro) references tb_proyecto (cod_pro),
add constraint fk_int_cam foreign key (cod_cam) references tb_camarada (cod_cam),
add constraint fk_int_per foreign key (cod_per) references tb_perfil (cod_per);

alter table tb_dependencia_actividad
add constraint fk_dep_act_pro foreign key (cod_pro, cod_act_dep) references tb_actividad (cod_pro, cod_act),
add constraint fk_dep_act_act foreign key (cod_pro, cod_act) references tb_actividad (cod_pro, cod_act);

alter table tb_modificacion
add constraint fk_mod_cam foreign key (cod_cam) references tb_camarada (cod_cam),
add constraint fk_mod_act foreign key (cod_pro,cod_act) references tb_actividad (cod_pro,cod_act);

alter table tb_documento
add constraint fk_doc_pro foreign key (cod_pro) references tb_proyecto (cod_pro);

alter table tb_proyecto
add constraint uq_llave_pro unique (llave);


set foreign_key_checks=1;
SHOW ENGINE INNODB STATUS;

-- --------------------------------------------------------------------------------------------------
-- ------------------------------------ TRIGGERS ------------------------------------------------
-- --------------------------------------------------------------------------------------------------

DELIMITER $$
create trigger tg_tipo_dato before insert on tb_tipo_dato
for each row
begin
	declare cod int;
    select ifnull(max(cod_td),0)+1 from tb_tipo_dato where cod_pro = NEW.cod_pro into cod;
	set NEW.cod_td = cod;
end$$ 
DELIMITER ;



DELIMITER $$
create trigger tg_actividad before insert on tb_actividad
for each row
begin
	declare cod int;
    select ifnull(max(cod_act),0)+1 from tb_actividad where cod_pro = NEW.cod_pro into cod;
	set NEW.cod_act = cod;
end$$ 
DELIMITER ;

DELIMITER $$
create trigger tg_vista before insert on tb_vista
for each row
begin
	declare cod int;
    select ifnull(max(cod_vis),0)+1 from tb_vista where cod_pro = NEW.cod_pro into cod;
	set NEW.cod_vis = cod;
end$$ 
DELIMITER ;


DELIMITER $$
create trigger tg_input before insert on tb_input
for each row
begin
	declare cod int;
    select ifnull(max(cod_input),0)+1 from tb_input where cod_pro = NEW.cod_pro and cod_vis = NEW.cod_vis into cod;
	set NEW.cod_input = cod;
end$$ 
DELIMITER ;


DELIMITER $$
create trigger tg_output before insert on tb_output
for each row
begin
	declare cod int;
    select ifnull(max(cod_output), 0)+1 from tb_output where cod_pro = NEW.cod_pro and cod_vis = NEW.cod_vis into cod;
	set NEW.cod_output = cod;
end$$ 
DELIMITER ;


DELIMITER $$
create trigger tg_variable before insert on tb_variable
for each row
begin
	declare cod int;
    select ifnull(max(cod_var), 0)+1 from tb_variable where cod_pro = NEW.cod_pro into cod;
	set NEW.cod_var = cod;
end$$ 
DELIMITER ;


DELIMITER $$
create trigger tg_comentario before insert on tb_comentario
for each row
begin
	declare cod int;
    select ifnull(max(cod_com), 0)+1 from tb_comentario where cod_pro = NEW.cod_pro into cod;
	set NEW.cod_com = cod;
end$$ 
DELIMITER ;

DELIMITER $$
create trigger tg_estandar before insert on tb_estandar
for each row
begin
	declare cod int;
    select ifnull(max(cod_est), 0)+1 from tb_estandar where cod_pro = NEW.cod_pro into cod;
	set NEW.cod_est = cod;
end$$ 
DELIMITER ;

DELIMITER $$
create trigger tg_modificacion before insert on tb_modificacion
for each row
begin
	declare cod int;
    select ifnull(max(cod_mod), 0)+1 from tb_modificacion where cod_pro = NEW.cod_pro into cod;
	set NEW.cod_mod = cod;
end$$ 
DELIMITER ;


use bd_agenda_comunista;
select count(*) from tb_proyecto;
select * from tb_camarada;
