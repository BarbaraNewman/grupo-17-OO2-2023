USE `grupo-17-oo2-2023`;

INSERT INTO dispositivo
(`id_dispositivo`,
`activo`,
`fecha_actualizacion`,
`fecha_creacion`,
`nombre`,
`id_ubicacion`)
VALUES
(1, true, '2023-06-14 10:30:00', '2023-06-14 10:00:00', 'Dispositivo 1', 1),
(2, true, '2023-06-14 11:15:00', '2023-06-14 11:00:00', 'Dispositivo 2', 2),
(3, false, '2023-06-14 12:45:00', '2023-06-14 12:30:00', 'Dispositivo 3', 1),
(4, true, '2023-06-14 14:20:00', '2023-06-14 14:15:00', 'Dispositivo 4', 3),
(5, false, '2023-06-14 15:40:00', '2023-06-14 15:30:00', 'Dispositivo 5', 2);
