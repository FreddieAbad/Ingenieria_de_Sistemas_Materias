
-- Insertar registro
INSERT INTO curso_big_data(en, nombre, carrera, tel_mov, email)
VALUES(001, 'Freddy', 'Ing Sistemas', 0988596203, 'freddy.abad@ucuenca.edu.ec');

-- Actualizar registro
UPDATE curso_big_data SET email='freddy.abadl@ucuenca.edu.ec'
WHERE en=002;

-- Leer registro
SELECT nombre, email FROM curso_big_data;

-- Eliminar registro
DELETE tel_mov FROM curso_big_data WHERE en=003;
/