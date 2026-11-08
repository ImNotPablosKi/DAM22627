from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QListWidget, QAbstractItemView

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("yes")

        lista = QListWidget()
        lista.addItems(["Hola", "Adios", "Cosa", "Otra Cosa"])

        lista.currentTextChanged.connect(self.muestraTexto)

        lista.setSelectionMode(QAbstractItemView.SelectionMode.MultiSelection) # Permite seleccionar varios elementos a la vez

        self.setCentralWidget(lista)
    
    def muestraTexto(self, texto):
        print(texto)

app = QApplication([])

window = MainWindow()

window.show()

app.exec()