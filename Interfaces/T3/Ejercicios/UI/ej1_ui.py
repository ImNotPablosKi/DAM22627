# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'ej1.ui'
##
## Created by: Qt User Interface Compiler version 6.12.0
##
## WARNING! All changes made in this file will be lost when recompiling UI file!
################################################################################

from PySide6.QtCore import (QCoreApplication, QDate, QDateTime, QLocale,
    QMetaObject, QObject, QPoint, QRect,
    QSize, QTime, QUrl, Qt)
from PySide6.QtGui import (QBrush, QColor, QConicalGradient, QCursor,
    QFont, QFontDatabase, QGradient, QIcon,
    QImage, QKeySequence, QLinearGradient, QPainter,
    QPalette, QPixmap, QRadialGradient, QTransform)
from PySide6.QtWidgets import (QApplication, QHBoxLayout, QLabel, QLineEdit,
    QMainWindow, QMenuBar, QPushButton, QSizePolicy,
    QStatusBar, QVBoxLayout, QWidget)

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(483, 303)
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.widget = QWidget(self.centralwidget)
        self.widget.setObjectName(u"widget")
        self.widget.setGeometry(QRect(40, 21, 411, 211))
        self.verticalLayout = QVBoxLayout(self.widget)
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.verticalLayout.setContentsMargins(0, 0, 0, 0)
        self.horizontalLayout = QHBoxLayout()
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.provincia = QLabel(self.widget)
        self.provincia.setObjectName(u"provincia")

        self.horizontalLayout.addWidget(self.provincia)

        self.editProvincia = QLineEdit(self.widget)
        self.editProvincia.setObjectName(u"editProvincia")

        self.horizontalLayout.addWidget(self.editProvincia)


        self.verticalLayout.addLayout(self.horizontalLayout)

        self.horizontalLayout_2 = QHBoxLayout()
        self.horizontalLayout_2.setObjectName(u"horizontalLayout_2")
        self.Autonomia = QLabel(self.widget)
        self.Autonomia.setObjectName(u"Autonomia")

        self.horizontalLayout_2.addWidget(self.Autonomia)

        self.editAuto = QLineEdit(self.widget)
        self.editAuto.setObjectName(u"editAuto")

        self.horizontalLayout_2.addWidget(self.editAuto)


        self.verticalLayout.addLayout(self.horizontalLayout_2)

        self.horizontalLayout_3 = QHBoxLayout()
        self.horizontalLayout_3.setObjectName(u"horizontalLayout_3")
        self.Poblacion = QLabel(self.widget)
        self.Poblacion.setObjectName(u"Poblacion")

        self.horizontalLayout_3.addWidget(self.Poblacion)

        self.editPoblacion = QLineEdit(self.widget)
        self.editPoblacion.setObjectName(u"editPoblacion")

        self.horizontalLayout_3.addWidget(self.editPoblacion)


        self.verticalLayout.addLayout(self.horizontalLayout_3)

        self.horizontalLayout_4 = QHBoxLayout()
        self.horizontalLayout_4.setObjectName(u"horizontalLayout_4")
        self.btnAtras = QPushButton(self.widget)
        self.btnAtras.setObjectName(u"btnAtras")

        self.horizontalLayout_4.addWidget(self.btnAtras)

        self.btnAnterior = QPushButton(self.widget)
        self.btnAnterior.setObjectName(u"btnAnterior")

        self.horizontalLayout_4.addWidget(self.btnAnterior)

        self.btnSiguiente = QPushButton(self.widget)
        self.btnSiguiente.setObjectName(u"btnSiguiente")

        self.horizontalLayout_4.addWidget(self.btnSiguiente)

        self.btnAdelante = QPushButton(self.widget)
        self.btnAdelante.setObjectName(u"btnAdelante")

        self.horizontalLayout_4.addWidget(self.btnAdelante)


        self.verticalLayout.addLayout(self.horizontalLayout_4)

        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QMenuBar(MainWindow)
        self.menubar.setObjectName(u"menubar")
        self.menubar.setGeometry(QRect(0, 0, 483, 33))
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)

        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"MainWindow", None))
        self.provincia.setText(QCoreApplication.translate("MainWindow", u"Provincia", None))
        self.Autonomia.setText(QCoreApplication.translate("MainWindow", u"Autonomia", None))
        self.Poblacion.setText(QCoreApplication.translate("MainWindow", u"Poblacion", None))
        self.btnAtras.setText(QCoreApplication.translate("MainWindow", u"<<", None))
        self.btnAnterior.setText(QCoreApplication.translate("MainWindow", u"<", None))
        self.btnSiguiente.setText(QCoreApplication.translate("MainWindow", u">", None))
        self.btnAdelante.setText(QCoreApplication.translate("MainWindow", u">>", None))
    # retranslateUi

