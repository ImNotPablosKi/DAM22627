import 'package:componentes/models/menu_option.dart';
import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
   
  const HomeScreen({super.key});
  
  @override
  Widget build(BuildContext context) {

    final menuOptions = <MenuOption>[

      MenuOption(ruta: "listView1", icono: Icons.list_alt, nombre: "ListView Tipo 1 (Uno)"),
      MenuOption(ruta: "listView2", icono: Icons.list, nombre: "ListView Tipo 2 (Dos)"),
      MenuOption(ruta: "alert", icono: Icons.add_alert, nombre: "Alertas - Alerts"),
      MenuOption(ruta: "card", icono: Icons.card_membership_rounded, nombre: "Tarjetas - Cards"),

    ];

    return Scaffold(
      appBar: AppBar(
        title: Text('Componentes en flutter'),
      ),
      body: ListView.separated(
        itemBuilder: (context, i) => ListTile(
          leading: Icon(menuOptions[i].icono, color: AppTheme.primary,),
          title: Text(menuOptions[i].nombre),
          onTap: () {

            /*final route = MaterialPageRoute(
              builder: (context) => Listview2Screen(),
            );
            Navigator.push(context, route);*/

            Navigator.pushNamed(context, menuOptions[i].ruta);

          },
          trailing: Icon(Icons.arrow_forward_ios_rounded, color: AppTheme.secondary,),
        ),
        separatorBuilder: (_, _) => Divider(),
        itemCount: menuOptions.length
        )
    );
  }
}
