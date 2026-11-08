from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QWidget, QVBoxLayout, QLabel, QLineEdit

class MainWindow(QMainWindow): # Creación de una clase
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")

        self.etiqueta = QLabel("Púlsame!")
        self.setCentralWidget(self.etiqueta)

    def mouseMoveEvent(self, e):
        self.etiqueta.setText("EL RATÓN SE HA MOVIDOOOO")

    def mousePressEvent(self, e):
        self.etiqueta.setText("HAS HECHO CLICK")

    def mouseReleaseEvent(self, e):
        self.etiqueta.setText("HAS SOLTADO")
        
    def mouseDoubleClickEvent(self, e):
        self.etiqueta.setText("HAS HECHO DOS (2) CLICKS")

app = QApplication([])
window = MainWindow()
window.show()
app.exec()

