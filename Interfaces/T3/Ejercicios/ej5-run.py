import mysql.connector
from ej5 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication

# Estos DOS atributos SON NECESARIOS
class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.setWindowTitle("EJ 1")

        self.actual = 0

        try:

            self.conexion = mysql.connector.connect(
                
                host = "localhost",
                port = 3306,
                user = "root",
                password = "1234",
                database = "piezas"
                
            )

        except mysql.connector.Error as error:
            print(error)
            print("Error catastrófico")

        # Que el usuario no pueda cambiar el comboBox
        self.comboTipo.setEnabled(False)
        self.btnAdelante.clicked.connect(self.irAlFinal)
        self.btnAtras.clicked.connect(self.irAlInicio)
        self.btnAnterior.clicked.connect(self.anterior)
        self.btnSiguiente.clicked.connect(self.siguiente)

        self.rellenarCombo()
        self.cargarDatos()
        
    def cargarDatos(self):
        cursor = self.conexion.cursor()
        sql = "SELECT * FROM piezas"
        cursor.execute(sql)

        # La hago global con self para poder llamarla desde donde sea
        self.resultados = cursor.fetchall()
        self.ponerDatos(self.resultados[self.actual])


    def ponerDatos(self, dato):
        self.editId.setText(str(dato[0]))
        self.editNombre.setText(dato[1])
        self.editPrecio.setText(str(dato[2]))
        self.editUnidades.setText(str(dato[3]))

        # OLVIDO todo lo anterior porque @Hecprooll sabe programar de verdad
        self.comboTipo.setCurrentIndex(dato[4]-1)
        
        # findData busca el índice del combo cuyo dato oculto coincida con dato[4] q es el tipo
        # Por lo q mientras no devuelva un -1 (que NO debería pero vete tu a saber) ponemos ese índice como el actual
        # indice = self.comboTipo.findData(dato[4])
        # if indice != -1:
        #     self.comboTipo.setCurrentIndex(indice)


    def rellenarCombo(self):
        cursor = self.conexion.cursor()
        cursor.execute("SELECT * FROM tipo")

        self.resultados2 = cursor.fetchall()

        for tipo in self.resultados2:
            # El segundo parámetro de addItem guarda un valor oculto asociado a lo que que sea que hayas puesto primero
            # Guardar el nombre visible tipo[1] y su ID oculto tipo[0]
            self.comboTipo.addItem(tipo[1], tipo[0]) # Este segundo parametro al final no es necesario

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
