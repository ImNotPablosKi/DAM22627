from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QDialog

from cuadrado import Color

class MainWindow(QMainWindow): # Creación de una clase
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")

        boton = QPushButton("Pulsa para revelar un dialogo")
        boton.clicked.connect(self.botonpulsado)

        self.setCentralWidget(boton)

    def botonpulsado(self):

        # Si le quitas self, el dialogo se queda con tamaño predeterminado en vez de ajustarse al padre
        dialog = QDialog(self)
        dialog.setWindowTitle("Cuadro de dialogo")
        dialog.exec()

app = QApplication([])
window = MainWindow()
window.show()
app.exec()

