from repaso import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication
from PyQt6.QtGui import QPalette, QColor

# Estos dos atributos son necesarios
# Ventanas:      Propia      Importada
class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()

        # Cambiar el estilo de un texto al pulsar un botón
        # Se puede llamar a un cambio de estilos desde un lambda
        self.btnAceptar.clicked.connect(lambda: self.edit1.setStyleSheet("font-family: Verdana;"))
        self.btnAceptar.clicked.connect(lambda: self.edit1.setStyleSheet("font-size: 18px;"))

        # Al detectar que ha cambiado el comboBox, llamar a la función
        self.comboBox.currentIndexChanged.connect(self.cambiarEstilo)

    # Cambiar la hoja de estilos referenciada según un evento que ocurra
    # En este caso este evento será la opción del comboBox
    def cambiarEstilo(self, evento):
        with open(f"repaso/styles/repaso_widget{["1", "2", "3"][evento]}.qss","r") as f:
            app.setStyleSheet(f.read())

app = QApplication([]) # Hago un objeto QApplication
#app.setStyle("Fusion") # Cambia el estilo de la interfaz en clase hemos visto "Fusion" y "Windows"

with open("repaso/styles/repaso_base.qss","r") as f:
    app.setStyleSheet(f.read())

#paleta = QPalette()
#paleta.setColor(QPalette.ColorRole.Window, QColor("#777777"))
#app.setPalette(paleta)

window = MainWindow() # Hago un objeto QMainWindow que es una ventana
app.exec() # Para que se quede la ventana ablierta