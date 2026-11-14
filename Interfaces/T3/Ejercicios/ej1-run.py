import mysql.connector
from ej1 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication

"""
PLAN: Hacer un contador global (self.actual) que se pasará a cada tupla que recoja en la función cargarDatos()
Desde la función cargarDatos() llamar a otra para poner los datos en cada elemento de la interfaz a la que le
pasaré los resultados en el index resultados[actual]... etc

Una vez terminado eso he de hacer funcionar los botones para pasar entre los ditintos datos
Deben de avanzar, retroceder y saltar tanto al inicio como al final
"""

# Estos DOS atributos SON NECESARIOS
class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.setWindowTitle("EJ 1")

        self.actual = 0
        # self.datos = []

        try:

            self.conexion = mysql.connector.connect(
                
                host = "localhost",
                port = 3306,
                user = "root",
                password = "1234",
                database = "capitales"
                
            )
                
            # # print(dato)
            # El fetchAll nos devuelve tuplas, entonces hay que elegir [tupla][contenido de esa tupla]
            # self.editProvincia.setText(self.datos[0][0])
            # self.editAuto.setText(self.datos[0][1])
            # self.editPoblacion.setText(str(self.datos[0][2]))

        except mysql.connector.Error as error:
            print(error)
            print("Error catastrófico")
            
        self.cargarDatos()
        
        self.btnAnterior.clicked.connect(self.anterior)
        self.btnSiguiente.clicked.connect(self.siguiente)
        self.btnAtras.clicked.connect(self.irAlInicio)
        self.btnAdelante.clicked.connect(self.irAlFinal)

    def cargarDatos(self):
        cursor = self.conexion.cursor()
        sql = "SELECT * FROM capitales"
        cursor.execute(sql)

        # La hago global con self para poder llamarla desde donde sea
        self.resultados = cursor.fetchall()
        self.ponerDatos(self.resultados[self.actual])
        
    def ponerDatos(self, dato):
        # Cada dato recibido es el contenido de una tupla, es básicamente un array
        self.editProvincia.setText(dato[0])
        self.editAuto.setText(dato[1])
        self.editPoblacion.setText(str(dato[2])) # Lo parseo a string porque poblacion es un número
        
    def anterior(self):
        # Comprobar que el index no es el primero o no podré retroceder más
        if (self.actual > 0):
            self.actual -= 1
            # Una vez he modificado el index actual, se lo paso a resultados para que me cambie los datos
            self.ponerDatos(self.resultados[self.actual])
        
    def siguiente(self):
        # Comprobar que el index no es el final de los datos, pues no podré avanzar si no hay nada más
        if (self.actual < len(self.resultados) - 1):
            self.actual += 1
            self.ponerDatos(self.resultados[self.actual])
     
    def irAlInicio(self):
        # Simplemente decirle al index que sea 0
        self.actual = 0
        self.ponerDatos(self.resultados[self.actual])
        
    def irAlFinal(self):
        # Poner el índice al final del todo
        self.actual = len(self.resultados) -1
        self.ponerDatos(self.resultados[self.actual])
        
    
app = QApplication([])
ventana = MainWindow()
ventana.show() 
app.exec()        
