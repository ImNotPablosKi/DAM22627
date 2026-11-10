import 'package:flutter/material.dart';


class SliderScreen extends StatefulWidget {
  const SliderScreen({super.key});


  @override
  State<SliderScreen> createState() => _SliderScreenState();
}


class _SliderScreenState extends State<SliderScreen> {
  double _valorSlider = 20;

  bool _sliderActivado = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Sliders & Checks")),
      body: Column(
        children: [
          Slider.adaptive(
            min: 0,
            max: 400,
            value: _valorSlider,
            onChanged: _sliderActivado
            ? (value) {
              setState(() {
                _valorSlider = value;
              });
            } : null
          ),

          // Checkbox.adaptive(
          //   value: _sliderActivado,
          //   onChanged: (value) {
          //    _sliderActivado = value ?? true;
          //    setState(() {
               
          //    });
          //   }
          // ),

          // Switch.adaptive(value: _sliderActivado, onChanged: ((value) {
          //   _sliderActivado = value;
          //   setState(() {
              
          //   });
          // })),

          CheckboxListTile.adaptive(
            title: Text("Habilitar Slider"),
            titleAlignment: .center,
            // secondary: Icon(Icons.check), // Como el leading para poner un icono al principio.
            // subtitle: Text("Esto es el subtítulo btw"),
            value: _sliderActivado,
            onChanged: (value) {

              _sliderActivado = value ?? true;
              setState(() {
                
              });

            }
          ),

          SwitchListTile.adaptive(
            
              title: Text("Habilitar Slider"),

              value: _sliderActivado,
              onChanged: (value) {

                _sliderActivado = value;
                setState(() {
                  
                });

              }
            ),

          // AboutListTile()   -> Para ver las licencias
          Expanded(
            child: SingleChildScrollView(
              child: Image(
                image: NetworkImage("https://cdn.pixabay.com/photo/2020/07/06/17/51/batman-5377804_1280.png"),
                fit: BoxFit.contain,
                width: _valorSlider,
              ),
            ),
          )
        ],
      ),
    );
  }
}



