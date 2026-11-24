import 'package:flutter/material.dart';
import 'package:gestor_de_estados/providers/contador_provider.dart';
import 'package:gestor_de_estados/providers/theme_provider.dart';
import 'package:provider/provider.dart';

class Pagina3 extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      // color: Colors.limeAccent,
      child: Center(
        child: Column(
          spacing: 20,
          children: [
            
            Text(
              "El contador de la página 1 marca: ${context.watch<ContadorProvider>().contador.toString()}", style: TextStyle(color: Colors.white, fontSize: 20),
            ),
            ElevatedButton(onPressed: () {
              
              context.read<ThemeProvider>().cambiarTheme();

            }, child: Text("Modo Light/Dark"))
          ],
        ),
      )
    );
  }
}