import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart';

class BotonScreen extends StatelessWidget {
   
  const BotonScreen({super.key});
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Botones - Buttons"),
      ),
      body: _Buttons(),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.arrow_back_ios),
        onPressed: (){

        },
      ),
    );
  }
}

class _Buttons extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: SizedBox(
        width: double.infinity,
        child: Padding(
          padding: EdgeInsetsGeometry.symmetric(horizontal: 10, vertical: 20),
          child: Wrap(
            spacing: 10,
            alignment: .center,
            children: [Column(   
              children: [
                // Elevated buttons
                ElevatedButton(onPressed: () {}, child: Text("Elevated Button")),
                ElevatedButton(onPressed: null, child: Text("Elevated Button Disabled (null)")),
                ElevatedButton.icon(onPressed: (){},
                  label: Text("Elevated Icon Button"),
                  icon: Icon(Icons.terminal),),
                // Filled buttons
                FilledButton(
                  onPressed: (){}, child: Text("Filled Buton")
                ),
                FilledButton.icon(onPressed: (){}, label: Text("Filled Icon"),
                icon: Icon(Icons.dnd_forwardslash_outlined),
                iconAlignment: .end,
                ),
                OutlinedButton(onPressed: (){}, child: Text("Outlined")),
                OutlinedButton.icon(onPressed: (){}, label: Text("Outlined Icon"),
                icon: Icon(Icons.offline_pin),),
                // TextButton
                TextButton(onPressed: (){}, child: Text("TextButton")),
                TextButton.icon(onPressed: (){}, label: Text("TextButton Icon"),
                icon: Icon(Icons.access_alarms),),
                IconButton(onPressed: (){}, icon: Icon(Icons.face),),
                IconButton(onPressed: (){}, icon: Icon(Icons.face_2_outlined, size: 50, color: Colors.white,),
                style: ButtonStyle(
                  backgroundColor: WidgetStatePropertyAll(Colors.lightBlue)
                ),),
      
                // Nos creamos nosotros nuestro boton personal
                SizedBox(height: 10,),
                _BotonPersonalizado(),
                SizedBox(height: 10,),
                _BotonPersonalizado(),
                SizedBox(height: 10,),
                _BotonPersonalizado(),
                SizedBox(height: 10,),
                _BotonPersonalizado(),
                SizedBox(height: 10,),
                _BotonPersonalizado(),
      
              ],
            ),
          ]),
        ),
      ),
    );
  }
}

class _BotonPersonalizado extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return ClipRRect(
      borderRadius: .circular(20),
      child: Material(
        color: Colors.amberAccent,
        child: InkWell( 
          onTap: () {
            
          },
          child: Padding(
            padding: const EdgeInsets.all(20.0),
            child: Text("Mi propio Botón!"),
          ),
        ),
      ),
    );
  }

}