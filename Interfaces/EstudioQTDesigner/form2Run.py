from form2 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication
from PyQt6.QtGui import QPalette, QColor

class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()

        self.btnEscribir.clicked.connect(self.escribirTexto)
        self.btnEspacio.clicked.connect(self.separar)
        self.btnBorrar.clicked.connect(self.borrarTexto)

    def escribirTexto(self):
        self.textoGeneral.append(self.lineEdit.text())
        self.textoGeneral.setStyleSheet("border: 2px solid white")
        
    def separar(self):
        self.textoGeneral.append("")
        
    def borrarTexto(self):
        self.textoGeneral.setText("")
        self.textoGeneral.setStyleSheet("border: 2px solid red")

app = QApplication([])

with open("estilo2.qss","r") as f:
    app.setStyleSheet(f.read())

window = MainWindow() # Hago un objeto QMainWindow que es una ventana
app.exec() # Para que se quede la ventana ablierta