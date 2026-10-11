from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QMessageBox

class MainWindow(QMainWindow): # Creación de una clase
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")

        boton = QPushButton("Púlsame!")
        boton.clicked.connect(self.botonpulsado)

        self.setCentralWidget(boton)

    def botonpulsado(self):
        dialog = QMessageBox(self)
        dialog.setWindowTitle("Cuadro de mensaje")
        dialog.setText("Este es el mensaje de mi cuadro de mensaje!")
        dialog.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No)

        # También podemos poner un Icono, podemos cambiar su "severidad" o tipo
        dialog.setIcon(QMessageBox.Icon.Information)

        if dialog.exec() == QMessageBox.StandardButton.Yes:
            print("El usuario ha aceptado")
        else:
            print("El usuario ha rechazado")

app = QApplication([])
window = MainWindow()
window.show()
app.exec()

