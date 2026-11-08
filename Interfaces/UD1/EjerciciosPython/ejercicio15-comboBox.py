from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QComboBox

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Knigga GOAT")

        lista = QComboBox()
        lista.addItems(["Cosa", "Otra Cosa", "Una más"])
        lista.addItem("Cuatro")
        lista.setEditable(True) # Permite editar la lista en tiempo real

        lista.currentIndexChanged.connect(self.muestraIndice) # Devuelve el índice
        lista.currentTextChanged.connect(self.muestraTexto) # Devuelve el texto de dicho índice

        self.setCentralWidget(lista)

    def muestraIndice(self, indice):
        print(indice)

    def muestraTexto(self, texto):
        print(texto)

app = QApplication([])

window = MainWindow()

window.show()

app.exec()