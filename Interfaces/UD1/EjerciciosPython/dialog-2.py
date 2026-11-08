from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QDialog

from dialogs import CustomDialog

class MainWindow(QMainWindow): # Creación de una clase
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")

        boton = QPushButton("Púlsame!")
        boton.clicked.connect(self.botonpulsado)

        self.setCentralWidget(boton)

    def botonpulsado(self):
        dialog = CustomDialog(self)
        if dialog.exec(): # Si el usuario pulsa un boton con rol de aceptar...
            print("El usuario ha aceptado")
        else:
            print("El usuario ha rechazado")

app = QApplication([])
window = MainWindow()
window.show()
app.exec()

