import 'package:flutter/material.dart';
import 'package:gestor_de_estados/providers/contador_provider.dart';
import 'package:gestor_de_estados/providers/theme_provider.dart';
import 'package:gestor_de_estados/screens/home_screen.dart';
import 'package:provider/provider.dart';

void main() => runApp( MultiProvider(
  providers: [
        ChangeNotifierProvider(create: (_) => ContadorProvider(),),
        ChangeNotifierProvider(create: (_) => ThemeProvider())
  ],
  child: MyApp()));

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {

    final tema = context.watch<ThemeProvider>();

    return MaterialApp(

        title: 'Gestor de estados',
        home: HomeScreen(),
        debugShowCheckedModeBanner: false,
        theme: ThemeData.light(),
        darkTheme: ThemeData.dark(),
        themeMode: tema.themeMode,
        
      );
  }
}