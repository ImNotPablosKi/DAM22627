from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QSpinBox

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("yes")

        spinBox = QSpinBox()
        spinBox.setRange(-67, 67)

        # Establecer de cuanto en cuanto quiero que salte
        spinBox.setSingleStep(2)
        spinBox.setSuffix(" €")

        spinBox.valueChanged.connect(self.valorCambiado)
        spinBox.textChanged.connect(self.valorCambiado)

        self.setCentralWidget(spinBox)

    def valorCambiado(self, valor):
        print(valor)

    def introPulsado(self):
        print("Intro Pulsado")



app = QApplication([])

window = MainWindow()

window.show()

app.exec()