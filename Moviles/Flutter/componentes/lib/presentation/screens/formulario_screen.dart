import 'package:flutter/material.dart';

import '../screens.dart';
import '../widgets.dart';

class FormularioScreen extends StatelessWidget {
   
  const FormularioScreen({super.key});
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Formularios"),),
      body: SingleChildScrollView(
         child: Padding(
          padding: EdgeInsetsGeometry.symmetric(horizontal: 20, vertical: 10),
          child: Column(
            
            children: [

              CustomInputField(),

            ],

          ),
        ),
      ),
    );
  }
}

