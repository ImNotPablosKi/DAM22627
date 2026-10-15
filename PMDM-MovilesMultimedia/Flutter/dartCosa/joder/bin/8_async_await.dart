void main() async{

  print("Inicio del programa");
  
  try {

    final value = await httpGet("URL");
    print(value);

  } catch (err) {

    print("Tenemos un Error: $err");

  }

 /*httpGet("https://www.google.es")
  .then((value) => print(value))
  .catchError( (err) => print(err));*/

  print("Final del programa");

}

Future<String> httpGet(String url) async {

  await Future.delayed(Duration(seconds: 3));
  throw "Error de la petición HTTP";

  /*await Future.delayed(Duration(seconds: 2), (){

    return "Respuesta de la petición HTTP";
    // throw "Error en la petición HTTP";

  });*/

}