from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QCheckBox

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Knigga GOAT")

        casilla = QCheckBox("Pulsa para que pase algo ns")
        formato = casilla.font()
        formato.setBold(True)
        formato.setFamily("Cascadia Code")

        casilla.setFont(formato)
        casilla.stateChanged.connect(self.muestraEstado)

        self.setCentralWidget(casilla)

    def muestraEstado(self, s):
        print(s)


app = QApplication([])

window = MainWindow()

window.show()

app.exec()