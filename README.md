# README #

TALLER JEE7 - GRUPO 4

INTEGRANTES:
-Toomas Child
-Matias Lazos
-Sebastian Meneses
-Rosa Muñoz
-Juan Pablo Roa
-Alan Vergara


## Ejecucion en Linux ###
1.- importar el proyecto como gradle proyect en Eclipse
2.- Iniciar Glassfish $ asadmin start-domain

Dentro del directorio del proyecto 
3.- $gradle clean
4.- $gradle build
5.- $gradle war

6.- Entrar a Glassfish y en la pestaña de aplicaciones hacemos deploy al .war generado. 
7.- Finalmente le hacemos Launch a la aplicacion.

# Convención de servicios #
Por defecto, para encontrar todos los films de un actor, se usa la url /actors/{id}/films/, siendo id el valor númerico del id del actor deseado. Mismo caso para los films, para hallar todos los actores de un film, se utiliza /films/{id}/actors/

# Creación de nuevas relaciones #
Para crear una nueva relación entre un actor y un film, se utiliza el método POST en la url /filmActors. Se pasa como objeto json el id del actor, el id del film, y la fecha de edición. Así se asocia una actor con un film. El cambio queda presente en tiempo de ejecución y persistente en la base de datos.

# Creación de nuevas instancias #
Tanto en films como en actors, se pasa mediante POST los atributos correspondiente en formato json. Se usa la url por defecto de cada clase, es decir, /actors y /films especificamente.
