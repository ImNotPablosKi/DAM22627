# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'ejercicio3.ui'
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
    QSpacerItem, QStatusBar, QVBoxLayout, QWidget)

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(353, 258)
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.widget = QWidget(self.centralwidget)
        self.widget.setObjectName(u"widget")
        self.widget.setGeometry(QRect(21, 11, 166, 64))
        self.verticalLayout = QVBoxLayout(self.widget)
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.verticalLayout.setContentsMargins(0, 0, 0, 0)
        self.horizontalLayout = QHBoxLayout()
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.nombre = QLabel(self.widget)
        self.nombre.setObjectName(u"nombre")

        self.horizontalLayout.addWidget(self.nombre)

        self.editNombre = QLineEdit(self.widget)
        self.editNombre.setObjectName(u"editNombre")

        self.horizontalLayout.addWidget(self.editNombre)


        self.verticalLayout.addLayout(self.horizontalLayout)

        self.horizontalLayout_2 = QHBoxLayout()
        self.horizontalLayout_2.setObjectName(u"horizontalLayout_2")
        self.contrasena = QLabel(self.widget)
        self.contrasena.setObjectName(u"contrasena")

        self.horizontalLayout_2.addWidget(self.contrasena)

        self.editContrasena = QLineEdit(self.widget)
        self.editContrasena.setObjectName(u"editContrasena")

        self.horizontalLayout_2.addWidget(self.editContrasena)


        self.verticalLayout.addLayout(self.horizontalLayout_2)

        self.widget1 = QWidget(self.centralwidget)
        self.widget1.setObjectName(u"widget1")
        self.widget1.setGeometry(QRect(22, 90, 284, 28))
        self.horizontalLayout_3 = QHBoxLayout(self.widget1)
        self.horizontalLayout_3.setObjectName(u"horizontalLayout_3")
        self.horizontalLayout_3.setContentsMargins(0, 0, 0, 0)
        self.horizontalSpacer = QSpacerItem(55, 20, QSizePolicy.Policy.Fixed, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_3.addItem(self.horizontalSpacer)

        self.btnAceptar = QPushButton(self.widget1)
        self.btnAceptar.setObjectName(u"btnAceptar")

        self.horizontalLayout_3.addWidget(self.btnAceptar)

        self.horizontalSpacer_2 = QSpacerItem(40, 20, QSizePolicy.Policy.Fixed, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_3.addItem(self.horizontalSpacer_2)

        self.btnCancelar = QPushButton(self.widget1)
        self.btnCancelar.setObjectName(u"btnCancelar")

        self.horizontalLayout_3.addWidget(self.btnCancelar)

        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QMenuBar(MainWindow)
        self.menubar.setObjectName(u"menubar")
        self.menubar.setGeometry(QRect(0, 0, 353, 33))
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)

        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"MainWindow", None))
        self.nombre.setText(QCoreApplication.translate("MainWindow", u"Nombre:", None))
        self.contrasena.setText(QCoreApplication.translate("MainWindow", u"Contrase\u00f1a:", None))
        self.btnAceptar.setText(QCoreApplication.translate("MainWindow", u"Aceptar", None))
        self.btnCancelar.setText(QCoreApplication.translate("MainWindow", u"Cancelar", None))
    # retranslateUi

