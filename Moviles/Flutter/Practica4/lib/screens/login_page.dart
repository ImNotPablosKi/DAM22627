import 'package:flutter/material.dart';
import 'package:practica4/providers/data_provider.dart';
import 'package:provider/provider.dart';

class LoginPage extends StatelessWidget {
  const LoginPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
          padding: EdgeInsetsGeometry.directional(top: 280,end: 20, start: 20),
          child: Column(
            children: [
              TextFormField(
                onChanged: (value) {
                  context.read<DataProvider>().setEmail(value);
                },
                autofocus: true,
                keyboardType: .emailAddress,
                textAlign: .center,
                validator: (value) {
                  if(value == "") return "Este campo ES necesario";
                  if (!RegExp(r'^[\w.+-]{5,}@[\w-]{3,}\.[a-zA-Z]{2,3}$').hasMatch(value!)) return "Formato de correo NO válido!!";
                  return null;
                },
                autovalidateMode: .onUserInteraction,
                decoration: InputDecoration(
                  hintText: "Email...",
                  prefixIcon: Icon(Icons.mark_email_read),
                  border: OutlineInputBorder(
                    borderRadius: .all(Radius.circular(10),),
                    borderSide:  BorderSide(
                      width: 1,
                      color: const Color.fromARGB(255, 160, 160, 160),
                    )
                  ),
                  focusedBorder: OutlineInputBorder(
                    borderRadius: .all(Radius.circular(10),),
                    borderSide:  BorderSide(
                      width: 3,
                      color: const Color.fromARGB(255, 160, 160, 160),
                    )
                  )
                ),
              ),
              SizedBox(height: 20,),
              TextFormField(
                onChanged: (value) {
                  context.read<DataProvider>().setPassword(value);
                },
                keyboardType: .visiblePassword,
                obscureText: true,
                textAlign: .center,
                // Comprobar
                validator: (value) {
                  if(value == "") return "Este campo ES necesario";
                  if(value!.length < 3) return "Contraseña muy corta, pon 3 carácteres o más";
                  return null;
                },
                // Decirle que compruebe solo cuando se use
                autovalidateMode: .onUserInteraction,
                decoration: InputDecoration(
                  hintText: "Contraseña...",
                  prefixIcon: Icon(Icons.password_outlined),
                  border: OutlineInputBorder(
                    borderRadius: .all(Radius.circular(10),),
                    borderSide:  BorderSide(
                      width: 1,
                      color: const Color.fromARGB(255, 160, 160, 160),
                    )
                  ),
                  focusedBorder: OutlineInputBorder(
                    borderRadius: .all(Radius.circular(10),),
                    borderSide:  BorderSide(
                      width: 3,
                      color: const Color.fromARGB(255, 160, 160, 160),
                    )
                  )
                ),
              ),
              SizedBox(height: 50,),
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  onPressed: () {
                    Navigator.pushNamed(context, "home");
                  },
                  style: ElevatedButton.styleFrom(
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                    backgroundColor: const Color.fromARGB(255, 51, 51, 51),
                    foregroundColor: const Color.fromARGB(255, 236, 236, 236),
                  ),
                  child: Text("Iniciar sesión"),
                ),
              ),
            ],
          ),
      ),
    );
  }
}