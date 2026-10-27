import 'package:flutter/material.dart';

class AppTheme {

  // Color primario
  static const Color primary = Colors.blue;
  static const Color secondary = Colors.deepOrangeAccent;

  static final ThemeData lightTheme = ThemeData.light().copyWith(

    // Color primario
    primaryColor: primary,
    useMaterial3: false,

    // Estilos para el AppBar
    appBarTheme: AppBarTheme(
      backgroundColor: primary,
      elevation: 0,
    ),
  );

  // Tema Halloween
  static final ThemeData halloweenTheme = ThemeData.dark().copyWith(
    // Color primario
    primaryColor: Colors.orangeAccent,
    primaryColorDark: Colors.orangeAccent,

    // iconTheme: IconThemeData(color: Colors.orange),

    // scaffoldBackgroundColor: Colors.blueGrey
  );

}