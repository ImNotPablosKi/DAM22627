import 'package:api_rest_1/models/user.dart';
import 'package:api_rest_1/services/users_service.dart';
import 'package:flutter/material.dart';

class UsersScreen extends StatefulWidget {
   
  const UsersScreen({super.key});

  @override
  State<UsersScreen> createState() => _UsersScreenState();
}

class _UsersScreenState extends State<UsersScreen> {

  late Future<List<dynamic>> _futureUsers;

  @override
  void initState() {

    super.initState();
    _futureUsers = UsersService.obtenerUsuariosConDIO();

  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Lista de Usuarios"),),
      body: FutureBuilder(
        future: _futureUsers,
        builder: (context, snapshot) {
          
          if (snapshot.connectionState == ConnectionState.waiting) {

            return Center(child: CircularProgressIndicator.adaptive(),);

          } else if (snapshot.hasError) {

            return Center(child: Text("Error al cargar los usuarios!: ${snapshot.error}"),);

          } else {

            final listaUsuarios = snapshot.data;
            return ListView.builder(

              itemCount: listaUsuarios!.length,
              itemBuilder: (context, index) {
                
                final usuario = listaUsuarios[index];

                return ListTile(
                  title: Text(usuario["name"]),
                  subtitle: Text("Dirección: ${usuario["address"]["street"]}"),
                );

              },

            );

          }

        },
      )
    );
  }
}