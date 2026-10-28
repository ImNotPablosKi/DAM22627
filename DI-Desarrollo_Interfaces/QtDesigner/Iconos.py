from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QComboBox, QRadioButton, QMenu, QStatusBar, QApplication, QMainWindow, QHBoxLayout, QWidget, QVBoxLayout, QPushButton, QRadioButton, QGroupBox, QGridLayout, QStackedLayout, QTabWidget, QLabel, QLineEdit, QTextEdit, QCheckBox, QToolBar, QDialog, QStyle
from PyQt6.QtGui import QPixmap, QAction, QIcon

app = QApplication([])
boton = QPushButton()

estilo = boton.style()
icono = estilo.standardIcon(QStyle.StandardPixmap.SP_ArrowRight)
boton.setIcon(icono)
boton.setIconSize(QSize(40,40))
boton.show()
app.exec()