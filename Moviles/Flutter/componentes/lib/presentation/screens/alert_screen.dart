import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class AlertScreen extends StatelessWidget {
   
  const AlertScreen({super.key});

  void mostrarAlerta(BuildContext context) {

    showCupertinoDialog(
      context: context,
      builder: (context) {
        return AlertDialog(
          title: Text("Título de la Alerta"),
          content: Column(
            mainAxisSize: .min,
            children: [
              Text("Esto es el contenido de la alerta"),
              SizedBox(height: 20,),
              FlutterLogo(size: 100,)
            ],
          ),
        );
      },
    );

  }
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Alertas"),
        // backgroundColor: Colors.blue,
        elevation: 0,
      ),
      body: Center(
          child: ElevatedButton(
            style: ElevatedButton.styleFrom(
              backgroundColor: AppTheme.primary,
              shape: StadiumBorder()
            ),
            onPressed:() {
              mostrarAlerta(context);
            },
            child: Padding(
              //padding: EdgeInsets.symmetric(horizontal: 10, vertical: 30),
              padding: EdgeInsets.all(25),
              child: Text("Mostrar Alerta"),
            )
         ),
      ),
    );
  }
}