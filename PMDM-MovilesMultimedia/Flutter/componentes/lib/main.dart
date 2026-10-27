import 'package:componentes/theme/app_theme.dart';

import 'presentation/screens.dart'; // Archivo de Barril con todos los imports en un solo archivo

import 'package:flutter/material.dart';



void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      // home: ListviewScreen(),
      initialRoute: "/",
      routes: {
        "/" :(BuildContext context) => HomeScreen(),
        "listView1" :(context) => ListviewScreen(),
        "listView2" :(context) => Listview2Screen(),
        "alert" :(context) => AlertScreen(),
        "card"  :(context) => CardScreen()
      },
      onGenerateRoute: (settings) => MaterialPageRoute(builder: (context) => HomeScreen()),
      theme: AppTheme.lightTheme,
      // theme: AppTheme.lightTheme
    );
  }
}