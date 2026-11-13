import mysql.connector
from ej1 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication

# Estos DOS atributos SON NECESARIOS
class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.setWindowTitle("EJ 1")

        self.datos = []

        try:

            self.conexion = mysql.connector.connect(
                host = "localhost",
                port=3306,
                user = "root",
                password = "1234",
                database = "capitales"
            )

            self.cargarDatos()
                
            # print(dato)
            self.editProvincia.setText(self.datos[0][0])
            self.editAuto.setText(self.datos[0][1])
            self.editPoblacion.setText(str(self.datos[0][2]))

        except mysql.connector.Error as error:
            print(error)    

    def cargarDatos(self):
        cursor = self.conexion.cursor()
        sql = "SELECT * FROM capitales"
        cursor.execute(sql)

        self.datos = cursor.fetchall()

        # for dato in resultados:
        #     self.datos.append(dato)

    # def insertarDatos(self, provincia, auto, poblacion):

    
    
app = QApplication([])
ventana = MainWindow()
ventana.show() 
app.exec()        