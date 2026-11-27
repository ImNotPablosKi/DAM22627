import mysql.connector
from PyQt6.QtWidgets import QLabel, QMainWindow, QApplication, QTableWidget, QVBoxLayout, QTableWidgetItem, QWidget, QHBoxLayout, QLineEdit, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("EJ 1")

        try:

            self.conexion = mysql.connector.connect(
                
                host = "localhost",
                port = 3306,
                user = "root",
                password = "1234",
                database = "capitales"
                
            )

        except mysql.connector.Error as error:
            print(error)
            print("Error catastrófico")

        self.contenedor = QVBoxLayout()
        self.layoutMain = QVBoxLayout()
        self.layoutArriba = QHBoxLayout()
        self.mainWidget = QWidget()
        self.widgetArriba = QWidget()
        self.tabla = QTableWidget()
        self.labelMax = QLabel("Maximo: ")
        self.labelMin = QLabel("Minimo: ")
        self.boton = QPushButton("Seleccionar")
        self.editMin = QLineEdit()
        self.editMax = QLineEdit()

        self.contenedor.addWidget(self.mainWidget)
        self.mainWidget.setLayout(self.layoutMain)

        self.layoutMain.addWidget(self.widgetArriba)
        self.widgetArriba.setLayout(self.layoutArriba)

        self.layoutArriba.addWidget(self.labelMin)
        self.layoutArriba.addWidget(self.editMin)
        self.layoutArriba.addWidget(self.labelMax)
        self.layoutArriba.addWidget(self.editMax)
        self.layoutArriba.addWidget(self.boton)

        self.layoutMain.addWidget(self.tabla)

        self.setCentralWidget(self.mainWidget)

        self.boton.clicked.connect(lambda: self.cargarDatos())

    def cargarDatos(self):

        # Recoger el texto de cada edit
        min = self.editMin.text()
        max = self.editMax.text()

        cursor = self.conexion.cursor()
        # Los parámetros por posición (%s) hacen referencia a la variable que pasas cuando ejecutas el cursor "Y SOLO PUEDE SER %S" - @Hecprooll
        sql = "SELECT DISTINCT * FROM capitales WHERE Población>%s AND Población<%s"
        cursor.execute(sql, (min, max))

        columnas = [desc[0] for desc in cursor.description]
        self.resultado = cursor.fetchall()

        # Esto cuenta columnas
        self.tabla.setColumnCount(len(columnas))
        # Esto cuenta filas
        self.tabla.setRowCount(len(self.resultado))
        # Poner el nombre de cada columna usando estas mismas
        self.tabla.setHorizontalHeaderLabels(columnas)

        # Por cada registro
        for fila, registro in enumerate(self.resultado):
            # Por cada valor
            for col, valor in enumerate(registro):
                # Coloca cada elemento en su posición, si es un valor lo autoconvierte a String
                texto = "" if valor is None else str(valor)
                item = QTableWidgetItem(texto)
                self.tabla.setItem(fila, col, item)

app = QApplication([])
ventana = MainWindow()
ventana.resize(400, 800)
ventana.show() 
app.exec()        
