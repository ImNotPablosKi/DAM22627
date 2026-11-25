import mysql.connector
from PyQt6.QtWidgets import QMainWindow, QApplication, QTableWidget, QVBoxLayout, QTableWidgetItem

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
        self.tabla = QTableWidget()
        self.contenedor.addWidget(self.tabla)
        self.setCentralWidget(self.tabla)
        self.cargarDatos()

    def cargarDatos(self):
        cursor = self.conexion.cursor()
        cursor.execute("SELECT * FROM capitales")

        # Cada columna es el contenido de cada fila del cursor
        # cursor.description devuelve una lista de tuplas
        columnas = [desc[0] for desc in cursor.description]
        self.resultado = cursor.fetchall()

        # Esto cuenta columnas
        self.tabla.setColumnCount(len(columnas))
        # Esto cuenta filas
        self.tabla.setRowCount(len(self.resultado))
        # Poner el nombre de cada columna usando estas mismas
        self.tabla.setHorizontalHeaderLabels(columnas)

        """
        ============================================
        Enumerate devuelve un Pair (Clave, Valor), y un valor asignado a esa clave la cual es iterable (aka un índice)
        Es útil para obtener una lista con índices por cada valor (lista indexada)

        "Es literalmente un forEach con un índice" - @Hecprooll
        ============================================
        """

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
