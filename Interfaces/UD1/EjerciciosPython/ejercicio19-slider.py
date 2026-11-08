from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QSlider

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("yes")

        slider = QSlider()
        slider.setRange(-67, 67)

        # Para poder cambiar la dirección del widgent, horizontal o vertical
        slider.setOrientation(Qt.Orientation.Horizontal)

        slider.valueChanged.connect(self.valorCambiado)

        self.setCentralWidget(slider)

    def valorCambiado(self, valor):
        print(valor)

    def introPulsado(self):
        print("Intro Pulsado")



app = QApplication([])

window = MainWindow()

window.show()

app.exec()