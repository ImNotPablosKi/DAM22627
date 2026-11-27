import mysql.connector
from PyQt6.QtWidgets import QLabel, QMainWindow, QApplication, QTableWidget, QVBoxLayout, QTableWidgetItem, QComboBox, QWidget

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
        self.mainWidget = QWidget()
        self.tabla = QTableWidget()
        self.combo = QComboBox()
        self.label = QLabel("Selecciona la comunidad Autónoma: ")

        self.contenedor.addWidget(self.mainWidget)
        self.mainWidget.setLayout(self.layoutMain)

        self.layoutMain.addWidget(self.label)

        self.layoutMain.addWidget(self.combo)
        self.layoutMain.addWidget(self.tabla)

        self.setCentralWidget(self.mainWidget)
        self.rellenarCombo()
        self.cargarDatos()
        self.combo.currentIndexChanged.connect(self.cargarDatos)

    def rellenarCombo(self):
        cursor = self.conexion.cursor()
        # DISTINCT para que no se repitan datos
        cursor.execute("SELECT DISTINCT Autonomía FROM capitales")

        self.resultados = cursor.fetchall()
        self.combo.addItems([autonomia[0] for autonomia in self.resultados])

    def cargarDatos(self):

        # Coger el texto actual del combo de las autonomías para llamarlo después al ejecutar el cursor
        autonomia = self.combo.currentText()

        cursor = self.conexion.cursor()
        # Los parámetros por posición (%s) hacen referencia a la variable que pasas cuando ejecutas el cursor
        sql = "SELECT * FROM capitales WHERE Autonomía=%s"
        cursor.execute(sql, (autonomia,))

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
