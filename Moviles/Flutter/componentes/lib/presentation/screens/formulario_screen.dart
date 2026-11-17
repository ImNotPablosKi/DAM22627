import 'package:flutter/material.dart';

import '../screens.dart';
import '../widgets.dart';

class FormularioScreen extends StatelessWidget {
   
  const FormularioScreen({super.key});
  
  @override
  Widget build(BuildContext context) {

    // GlobalKey nos permite controlar y validar el formulario completo, está asociado directamente con el widget Form
    final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

    final Map<String, String> formValues = {

      "first_name": "",
      "last_name": "",
      "tfno": "",
      "email": "",
      "password": "",
      "role": ""

    };

    return Scaffold(
      appBar: AppBar(title: Text("Formularios"),),
      body: SingleChildScrollView(
         child: Padding(
          padding: EdgeInsetsGeometry.symmetric(horizontal: 20, vertical: 10),
          child: Form(

            key: _formKey,

            child: Column(
              
              spacing: 20,
            
              children: [
            
                CustomInputField(labelText: "Nombre", hintText: "Nombre del usuario", formValues: formValues, formProperty: "first_name",),
                CustomInputField(labelText: "Apellidos", hintText: "Apellidos del usuario", formValues: formValues, formProperty: "last_name",),
                CustomInputField(labelText: "Teléfono", hintText: "Teléfono del usuario", keyboardType: .phone, formValues: formValues, formProperty: "tfno",),
                CustomInputField(labelText: "Email", hintText: "Correo del usuario", keyboardType: .emailAddress, formValues: formValues, formProperty: "email",),
                CustomInputField(labelText: "Constraseña", hintText: "Contraseña del usuario", obscureText: true, formValues: formValues, formProperty: "password",),
            
                ElevatedButton(onPressed: () {

                  print(formValues);

                }, child: Text("Guardar")),
                DropdownButtonFormField(
                  initialValue: "Admin",
                  items: [
                    DropdownMenuItem(child: Text("Admin"), value: "Admin",),
                    DropdownMenuItem(child: Text("Superusuario"), value: "Superuser",),
                    DropdownMenuItem(child: Text("Developer"), value: "Developer",),
                    DropdownMenuItem(child: Text("Junior Developer"), value: "Jr",)
                  ], 
                  onChanged: (value) {
            
                    formValues["role"] = value ?? "Developer";
            
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

