insert into author (name, email,phone,birth_date)
values ('Mario Vargas','mvargas@blog.com','978745405','2020-01-30T11:00');

insert into blog (name, description,url,status,author_id)
values ('El Utero de Marita','blog de noticias','http://utero.pe/','ACTIVO',1);
insert into blog (name, description,url,status,author_id)
values ('El Comercio','blog de noticias Peru','http://elcomercio.pe/','INACTIVO',1);

insert into post(title,date,status,content, blog_id)
values('LAS MUJERES EMPRENDEDORAS LIDERAN EL MUNDO DIGITAL EN EL PERÚ','2020-01-30',
'BORRADOR','En el 2014, la Organización de las Naciones Unidas (ONU) declaró el 19 de noviembre...',1);

insert into comment(date,comment,post_id)
values('2020-01-30','Las mujeres emprendedoras',1);