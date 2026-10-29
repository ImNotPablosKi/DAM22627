import 'package:flutter/material.dart';

const listaColores = <Color> [

  Colors.blue,
  Colors.teal,
  Colors.green,
  Colors.red,
  Colors.purple,
  Colors.deepPurple,
  Colors.orange,
  Colors.pink,
  Colors.pinkAccent,

];

class AppTheme {

  final int colorSeleccionado;

  new({
    this.colorSeleccionado = 0
  }): assert(colorSeleccionado >= 0, "El color seleccionado DEBE ser mayor que 0"),
      assert(colorSeleccionado < listaColores.length, "El color seleccionado debe ser menor que ${listaColores.length}");

  ThemeData getTheme() => ThemeData(
    useMaterial3: true,
    colorSchemeSeed: listaColores[colorSeleccionado],
    // AppBarTheme
    appBarTheme: AppBarTheme(
      centerTitle: true,
    ),
  );

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