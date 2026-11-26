import 'package:api_rest_1/models/post.dart';
import 'package:http/http.dart' as http;

class PostsService {

// Hacemos la petición a la API para solicitar la lista de Posts
  Future<List<Post>?> obtenerPosts() async {

    // Creamos un cliente HTTP que nos va a permitir enviar la petición
    var client =  http.Client();

    // Convertimos la dirección o endpoint en un objeto uri
    var uri = Uri.parse("https://jsonplaceholder.typicode.com/posts");

    // Enviamos la petición GET y esperamos la respuesta del servidor
    var response = await client.get(uri);

    // El código 200 indica que la peticion se ha realizado correctamente
    if (response.statusCode == 200) {

      var json = response.body;

      // Decodificamos ese texto y transformamos cada elemento JSON en un objeto Post
      return postFromJson(json);
    }

    // Si no es 200 no se devuelve ninguna lista (null) (te jodes xd)
    return null;

  }

}