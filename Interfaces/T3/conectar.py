import mysql.connector
from PyQt6.QtWidgets import QMainWindow, QApplication

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Conectar a BBDD")

        # Conectarse a la BBDD con credenciales e indicar cual es la base de datos
        try:
            self.conexion = mysql.connector.connect(
                host = "localhost",
                port=3306,
                user = "root",
                password = "1234",
                database = "capitales"
            )

            self.cargarDatos()
            self.cargarPrimerDato()
        except mysql.connector.Error as error:
            print(error)    

    # Función para cargar los datos
    def cargarDatos(self):
        # Creamos un cursor para recorrer los datos
        cursor = self.conexion.cursor()
        # Creamos la consulta
        sql = "SELECT * FROM capitales"
        # Asignar la consulta SQL al cursor
        cursor.execute(sql)
        # Almacenar lo que devuelva el cursor con la consulta en una variable
        # fetchall devuelve todo
        # fetchone te devuelve la siguiente
        # fetchmany te devuelve los que tu quieras
        resultado = cursor.fetchall()

        # primerResultado = cursor.fetchone()
        # print("============ PRIMER RESULTADO ============")
        # print(primerResultado)

        # Si quisiera mostrar un fetchone y fetchall a la vez debería de ejecutar por separado 2 .execute(sql) distintos
        # Básicamente debería de crearme OTRA función
        for dato in resultado:
            print(dato)
            # print(dato[0]) # Nombre

    def cargarPrimerDato(self):
            # Creamos un cursor para recorrer los datos
            cursor = self.conexion.cursor()
            # Creamos la consulta
            sql = "SELECT * FROM capitales"
            # Asignar la consulta SQL al cursor
            cursor.execute(sql)
    
            primerResultado = cursor.fetchone()
            print("============ PRIMER RESULTADO ============")
            print(primerResultado)

app = QApplication([])
ventana = MainWindow()
ventana.show() 
app.exec()