from formulario import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication, QMessageBox
from PyQt6.QtGui import QPalette, QColor

class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()

        self.pushButton.pressed.connect(self.entregar)
        self.pushButton_2.pressed.connect(self.entregar)
        self.pushButton_3.pressed.connect(self.entregar)

        self.checkBox.checkStateChanged.connect(self.fragil)

        self.pushButton_4.pressed.connect(self.enviar)
        self.pushButton_5.pressed.connect(lambda: self.close())


    def enviar(self):
        if self.pushButton.isChecked() and self.pushButton_2.isChecked() and self.pushButton_3.isChecked():

            dlg = QMessageBox(self)
            dlg.setWindowTitle("Estado de reporte")
            dlg.setText("Reporte enviado con éxito")
            dlg.setStandardButtons(QMessageBox.StandardButton.Ok)
            dlg.setIcon(QMessageBox.Icon.Information)

            # Aquí no es igual que en el QDialogButtonBox, hay que compararlo con el propio botón
            if dlg.exec() == QMessageBox.StandardButton.Ok:
                self.close()

        else:

            dlg = QMessageBox(self)
            dlg.setWindowTitle("Estado de reporte")
            dlg.setText("No se han entregado todos los paquetes")
            dlg.setStandardButtons(QMessageBox.StandardButton.Ok)
            dlg.setIcon(QMessageBox.Icon.Critical)
            dlg.exec()

    def entregar(self):
        if self.sender().isChecked():
            self.sender().setText("No entregado")
        else:
            self.sender().setText("Entregado")

    def fragil(self):

        activar = False

        if self.checkBox.isChecked():
            activar = True
        else:
            self.radioButton.setChecked(True)

        self.radioButton.setEnabled(activar)
        self.radioButton_2.setEnabled(activar)

        


app = QApplication([]) # Hago un objeto QApplication
# app.setStyle("Fusion") # Cambia el estilo de la interfaz en clase hemos visto "Fusion" y "Windows", "Windows vista" y "MacOs"

with open("estilo.qss","r") as f:
    app.setStyleSheet(f.read())

window = MainWindow() # Hago un objeto QMainWindow que es una ventana
app.exec() # Para que se quede la ventana ablierta