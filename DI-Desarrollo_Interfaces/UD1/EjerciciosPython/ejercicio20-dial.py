from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QDial

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("yes")

        dial = QDial()
        dial.setRange(-67, 67)

        # Mostrar las muescas del dial
        dial.setNotchesVisible(True)

        dial.valueChanged.connect(self.valorCambiado)
        dial.sliderMoved.connect(self.valorCambiado)

        self.setCentralWidget(dial)

    def valorCambiado(self, valor):
        print(valor)

    def introPulsado(self):
        print("Intro Pulsado")



app = QApplication([])

window = MainWindow()

window.show()

app.exec()