----------------------------------
-- CREACION Y SELECION DATABASE --

CREATE DATABASE IF NOT EXISTS `grupo-17-oo2-2023`;

use `grupo-17-oo2-2023`;


-----------
-- USERS --

insert into `grupo-17-oo2-2023`.user(enabled, password, username)
values(1, '$2a$10$KxUoFBacvSbyUjq86seGxe2pO6B9cuoBfeKyur1VLKZ9YSZH4CciG', 'admin');

insert into `grupo-17-oo2-2023`.user_role(role, user_id) values('ROLE_ADMIN', 1);

insert into `grupo-17-oo2-2023`.user(enabled, password, username)
values(1, '$2a$10$HJJGX.i64hIvs6zcKuUzV.IKVBZaO4QSwdzH9SrB4qDU1YidaVrGu', 'auditor');

insert into `grupo-17-oo2-2023`.user_role(role, user_id) values('ROLE_AUDITOR', 2);


---------------
-- UBICACION --

INSERT INTO ubicacion (id_ubicacion, descripcion, nombre)
VALUES
(1, 'Edificio', 'José Hernández'),
(2, 'Comedor Universitario', 'Padre Mujica'),
(3, 'Estudio de Grabación', 'Enrique Santos Discépolo'),
(4, 'Edificio', 'Lola Mora'),
(5, 'Edificio', 'Hernández Arregui'),
(6, 'Gimnasio Comunitario', 'Gatica'),
(7, 'Quincho', 'Roberto Fontanarrosa'),
(8, 'Edificio', 'Juana Manso'),
(9, 'Edificio', 'Inadi'),
(10, 'Campo de deportes ', 'Delfo Cabrera'),
(11, 'Edificio', 'Irma Laciar de Carrica'),
(12, 'Edificio', 'Leonardo Werthein'),
(13, 'Edificio', 'Oscar Varsavsky'),
(14, 'Jardin Maternal', 'Azucena Villaflor'),
(15, 'Edificio', 'Héctor Oesterheld'),
(16, 'Cine', 'Tita Merello'),
(17, 'Edificio', 'Casa del Estudiante'),
(18, 'Edificio', 'Lisandro de la Torre'),
(19, 'Edificio', 'Macedonio Fernández'),
(20, 'Edificio', 'Raúl Scalabrini Ortiz'),
(21, 'Edificio', 'Arturo Jauretche'),
(22, 'Edificio', 'Manuel Ugarte'),
(23, 'Edificio', 'Homero Manzi'),
(24, 'Edificio', 'Ortega Peña'),
(25, 'Edificio', 'Leopoldo Marechal'),
(26, 'Edificio', 'Juana Azurduy'),
(27, 'Edificio', 'Pascual Contursi'),
(28, 'Edificio', 'Néstor Kirchner'),
(29, 'Aulario', 'Remedios del Valle');


-----------------
-- DISPOSITIVO --

INSERT INTO dispositivo
(`id_dispositivo`, `fecha_actualizacion`, `fecha_creacion`, `nombre`, `id_ubicacion`)
VALUES
(1, '2023-06-14 10:30:00', '2023-06-14 10:00:00', 'Contenedor', 1),
(2, '2023-06-14 11:15:00', '2023-06-14 11:00:00', 'Contenedor', 2),
(3, '2023-06-14 12:45:00', '2023-06-14 12:30:00', 'Contenedor', 1),
(4, '2023-06-14 14:20:00', '2023-06-14 14:15:00', 'Contenedor', 3),
(5, '2023-06-14 15:40:00', '2023-06-14 15:30:00', 'Contenedor', 2),

-- DISPOSITIVO PARKING--
(6, true, '2023-06-14 20:30:00', '2023-06-14 20:00:00', 'Parking 1', 19),
(7, true, '2023-06-14 21:15:00', '2023-06-14 21:00:00', 'Parking 2', 1);

----------------
-- CONTENEDOR --

INSERT INTO contenedor
(capacidad, reciclable, id_dispositivo)
VALUES
(2400, true, 1),
(1200, false, 2),
(600, true, 3),
(1200, false, 4),
(2400, true, 5);

----------------
-- PARKING--
INSERT INTO `grupo-17-oo2-2023`.parking
(nro_lugar, id_dispositivo)
VALUES
(1, 6),
(2, 7);

-------------------------------
-- SENSOR CONTENEDOR METRICAS --

INSERT INTO sensor_contenedor
(`id_sensor`, `modelo`, `nivel_bateria`, `nivel_llenado`, `numero_serie`, `id_contenedor`)
VALUES
('1', 'Eco-Bits 20', '80', '100', '20-9876543210', '1'),
('2', 'Eco-Bits 20', '45', '30', '20-2468135790', '2'),
('3', 'Eco-Bits 20', '90', '75', '20-1122334455', '3'),
('4', 'Eco-Bits 20', '60', '42', '20-9876543212', '4'),
('5', 'Eco-Bits 20', '75', '20', '20-5432109876', '5');

-------------------------------
-- MEDICIONES PARKING --
insert into `grupo-17-oo2-2023`.medicion_parking(id_medicion_parking, created_at, hora, ocupado,
id_dispositivo)
values
(1, '2023-06-20 09:00:00', '2023-06-20 09:00:00', true, 6),
(2, '2023-06-20 10:30:00', '2023-06-20 10:30:00', false, 6),
(3, '2023-06-20 12:00:00', '2023-06-20 12:00:00', true, 7),
(4, '2023-06-20 22:58:00', '2023-06-20 22:58:00', false, 7),
(5, '2023-06-21 08:58:00', '2023-06-21 08:58:00', true, 7);
