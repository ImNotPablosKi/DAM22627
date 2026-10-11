from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QWidget, QVBoxLayout, QLabel

class OtraVentana(QWidget):
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre

        plantilla = QVBoxLayout()
        self.etiqueta = QLabel("Otra Ventana")
        plantilla.addWidget(self.etiqueta)

        self.setLayout(plantilla)

class MainWindow(QMainWindow): # Creación de una clase
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")

        boton = QPushButton("Púlsame!")
        boton.clicked.connect(self.mostrarOtraVentana)

        self.setCentralWidget(boton)

    def mostrarOtraVentana(self):
        self.window = OtraVentana()
        self.window.show()

app = QApplication([])
window = MainWindow()
window.show()
app.exec()

