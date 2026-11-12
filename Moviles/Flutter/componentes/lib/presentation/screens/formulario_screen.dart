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
          child: Form(
            child: Column(
              
              spacing: 20,
            
              children: [
            
                CustomInputField(labelText: "Nombre", hintText: "Nombre del usuario",),
                CustomInputField(labelText: "Apellidos", hintText: "Apellidos del usuario",),
                CustomInputField(labelText: "Teléfono", hintText: "Teléfono del usuario", keyboardType: .phone,),
                CustomInputField(labelText: "Email", hintText: "Correo del usuario", keyboardType: .emailAddress,),
                CustomInputField(labelText: "Constraseña", hintText: "Contraseña del usuario", obscureText: true,),
            
                ElevatedButton(onPressed: null, child: Text("Guardar")),
                DropdownButtonFormField(
                  initialValue: "Admin",
                  items: [
                    DropdownMenuItem(child: Text("Admin"), value: "Admin",),
                    DropdownMenuItem(child: Text("Superusuario"), value: "Superuser",),
                    DropdownMenuItem(child: Text("Developer"), value: "Developer",),
                    DropdownMenuItem(child: Text("Junior Developer"), value: "Jr",)
                  ], 
                  onChanged: (value) {
            
                    print(value);
            
                  }
                )
            
              ],
            
            ),
          ),
        ),
      ),
    );
  }
}

