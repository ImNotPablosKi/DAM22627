import 'package:flutter/material.dart';
import 'package:gestor_de_estados/providers/contador_provider.dart';
import 'package:provider/provider.dart';

class Pagina3 extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.limeAccent,
      child: Center(
        child: Text(
          "El contador de la página 1 marca: ${context.watch<ContadorProvider>().contador.toString()}"
        ),
      )
    );
  }
}