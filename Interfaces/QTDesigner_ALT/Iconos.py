from PyQt6.QtWidgets import QPushButton, QApplication, QStyle
from PyQt6.QtCore import QSize

# Ejecución de la app
app = QApplication([])

boton=QPushButton()

estilo=boton.style()
icono=estilo.standardIcon(QStyle.StandardPixmap.SP_MessageBoxCritical)
boton.setIcon(icono)
boton.setIconSize(QSize(40,40))
boton.show()
app.exec()


