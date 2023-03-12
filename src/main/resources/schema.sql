-- CREATE TABLE Libros (LibroID int NOT NULL, Titulo varchar(200),Autor varchar(200),ISBN varchar(200),Precio int);
CREATE TABLE Usuarios (UsuarioID int NOT NULL, DNI varchar(200), Nombre varchar(200), Apellido varchar(200), Email varchar(200));
CREATE TABLE Pedidos (LibroID int NOT NULL, UsuarioID int, Cantidad int);

-- ALTER TABLE libros add primary key(LibroID);
-- ALTER TABLE Usuarios add primary key(UsuarioID);
-- ALTER TABLE Pedidos add PedidoID int;
-- ALTER TABLE Pedidos add primary key(PedidoID);
-- ALTER TABLE pedidos modify column PedidoID int auto_increment;
-- ALTER TABLE libros modify column LibroID int auto_increment;
-- ALTER TABLE Usuarios modify column UsuarioID int auto_increment;
-- ALTER TABLE Pedidos add foreign key(LibroID) references libros(LibroID), add foreign key(UsuarioID) references Usuarios(UsuarioID);