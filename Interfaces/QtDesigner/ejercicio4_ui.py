# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'ejercicio4.ui'
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
from PySide6.QtWidgets import (QApplication, QComboBox, QHBoxLayout, QLabel,
    QMainWindow, QMenuBar, QPushButton, QSizePolicy,
    QStatusBar, QVBoxLayout, QWidget)

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(299, 283)
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.label = QLabel(self.centralwidget)
        self.label.setObjectName(u"label")
        self.label.setGeometry(QRect(10, 10, 261, 20))
        self.widget = QWidget(self.centralwidget)
        self.widget.setObjectName(u"widget")
        self.widget.setGeometry(QRect(10, 50, 260, 162))
        self.verticalLayout_4 = QVBoxLayout(self.widget)
        self.verticalLayout_4.setObjectName(u"verticalLayout_4")
        self.verticalLayout_4.setContentsMargins(0, 0, 0, 0)
        self.horizontalLayout = QHBoxLayout()
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.comboBox = QComboBox(self.widget)
        self.comboBox.setObjectName(u"comboBox")

        self.horizontalLayout.addWidget(self.comboBox)

        self.pushButton = QPushButton(self.widget)
        self.pushButton.setObjectName(u"pushButton")

        self.horizontalLayout.addWidget(self.pushButton)

        self.pushButton_2 = QPushButton(self.widget)
        self.pushButton_2.setObjectName(u"pushButton_2")

        self.horizontalLayout.addWidget(self.pushButton_2)


        self.verticalLayout_4.addLayout(self.horizontalLayout)

        self.horizontalLayout_2 = QHBoxLayout()
        self.horizontalLayout_2.setObjectName(u"horizontalLayout_2")
        self.verticalLayout = QVBoxLayout()
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.label_2 = QLabel(self.widget)
        self.label_2.setObjectName(u"label_2")

        self.verticalLayout.addWidget(self.label_2)

        self.label_4 = QLabel(self.widget)
        self.label_4.setObjectName(u"label_4")

        self.verticalLayout.addWidget(self.label_4)

        self.label_3 = QLabel(self.widget)
        self.label_3.setObjectName(u"label_3")

        self.verticalLayout.addWidget(self.label_3)

        self.label_5 = QLabel(self.widget)
        self.label_5.setObjectName(u"label_5")

        self.verticalLayout.addWidget(self.label_5)


        self.horizontalLayout_2.addLayout(self.verticalLayout)

        self.verticalLayout_2 = QVBoxLayout()
        self.verticalLayout_2.setObjectName(u"verticalLayout_2")
        self.pushButton_4 = QPushButton(self.widget)
        self.pushButton_4.setObjectName(u"pushButton_4")

        self.verticalLayout_2.addWidget(self.pushButton_4)

        self.pushButton_7 = QPushButton(self.widget)
        self.pushButton_7.setObjectName(u"pushButton_7")

        self.verticalLayout_2.addWidget(self.pushButton_7)

        self.pushButton_5 = QPushButton(self.widget)
        self.pushButton_5.setObjectName(u"pushButton_5")

        self.verticalLayout_2.addWidget(self.pushButton_5)

        self.pushButton_6 = QPushButton(self.widget)
        self.pushButton_6.setObjectName(u"pushButton_6")

        self.verticalLayout_2.addWidget(self.pushButton_6)


        self.horizontalLayout_2.addLayout(self.verticalLayout_2)

        self.verticalLayout_3 = QVBoxLayout()
        self.verticalLayout_3.setObjectName(u"verticalLayout_3")
        self.pushButton_8 = QPushButton(self.widget)
        self.pushButton_8.setObjectName(u"pushButton_8")

        self.verticalLayout_3.addWidget(self.pushButton_8)

        self.pushButton_9 = QPushButton(self.widget)
        self.pushButton_9.setObjectName(u"pushButton_9")

        self.verticalLayout_3.addWidget(self.pushButton_9)

        self.pushButton_10 = QPushButton(self.widget)
        self.pushButton_10.setObjectName(u"pushButton_10")

        self.verticalLayout_3.addWidget(self.pushButton_10)

        self.pushButton_11 = QPushButton(self.widget)
        self.pushButton_11.setObjectName(u"pushButton_11")

        self.verticalLayout_3.addWidget(self.pushButton_11)


        self.horizontalLayout_2.addLayout(self.verticalLayout_3)


        self.verticalLayout_4.addLayout(self.horizontalLayout_2)

        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QMenuBar(MainWindow)
        self.menubar.setObjectName(u"menubar")
        self.menubar.setGeometry(QRect(0, 0, 299, 33))
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)

        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"MainWindow", None))
        self.label.setText(QCoreApplication.translate("MainWindow", u"Encender LEDs", None))
        self.pushButton.setText(QCoreApplication.translate("MainWindow", u"Conectar", None))
        self.pushButton_2.setText(QCoreApplication.translate("MainWindow", u"Actualizar", None))
        self.label_2.setText(QCoreApplication.translate("MainWindow", u"LED1", None))
        self.label_4.setText(QCoreApplication.translate("MainWindow", u"LED2", None))
        self.label_3.setText(QCoreApplication.translate("MainWindow", u"LED3", None))
        self.label_5.setText(QCoreApplication.translate("MainWindow", u"LED4", None))
        self.pushButton_4.setText(QCoreApplication.translate("MainWindow", u"ON", None))
        self.pushButton_7.setText(QCoreApplication.translate("MainWindow", u"ON", None))
        self.pushButton_5.setText(QCoreApplication.translate("MainWindow", u"ON", None))
        self.pushButton_6.setText(QCoreApplication.translate("MainWindow", u"ON", None))
        self.pushButton_8.setText(QCoreApplication.translate("MainWindow", u"OFF", None))
        self.pushButton_9.setText(QCoreApplication.translate("MainWindow", u"OFF", None))
        self.pushButton_10.setText(QCoreApplication.translate("MainWindow", u"OFF", None))
        self.pushButton_11.setText(QCoreApplication.translate("MainWindow", u"OFF", None))
    # retranslateUi

