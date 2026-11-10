import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SnackbarScreen extends StatelessWidget {
   
  const SnackbarScreen({super.key});
  
  void mostrarSnackBarPersonalizado(BuildContext context) {

    // Eliminamos el snackbar para evitar repeticiones absurdas
    ScaffoldMessenger.of(context).clearSnackBars();

    final snackbar = SnackBar(
      content: Text("Hola a DAM 2!!!"),
      action: SnackBarAction(label: "Ok!", onPressed: (){}),
      duration: Duration(seconds: 2),
      backgroundColor: CupertinoColors.activeGreen,
    );

    // Mostramos el snackbar que nos hemos creado
    ScaffoldMessenger.of(context).showSnackBar(snackbar);

  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("SnackBar"),),


      floatingActionButton: FloatingActionButton.extended(
        icon: Icon(Icons.remove_red_eye),
        onPressed: () => mostrarSnackBarPersonalizado(context),
        label: Text("Mostrar SnackBar")
      ),
    );
  }
}