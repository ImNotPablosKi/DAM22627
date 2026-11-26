import 'package:api_rest_1/models/user.dart';
import 'package:dio/dio.dart';

class UsersService {

  // Método para obtener la lista de usuarios usando DIO
  static Future<List<dynamic>> obtenerUsuariosConDIO() async {

    final dio = Dio();
    final response = await dio.get("https://jsonplaceholder.typicode.com/users");
    if (response.statusCode == 200) {

      return response.data;

    } else {

      throw Exception("Error al cargar los usuarios con DIO");

    }

  }

}