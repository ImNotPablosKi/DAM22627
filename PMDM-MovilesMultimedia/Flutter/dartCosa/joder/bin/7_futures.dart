void main() {

  print("Inicio del programa");

 httpGet("https://www.google.es")
  .then((value) => print(value))
  .catchError( (err) => print(err));

  print("Final del programa");

}

Future<String> httpGet(String url) {

  return Future.delayed(Duration(seconds: 2), (){

    // return "Respuesta de la petición HTTP";
    throw "Error en la petición HTTP";

  });

}