import 'package:api_rest_1/models/post.dart';
import 'package:api_rest_1/services/posts_service.dart';
import 'package:flutter/material.dart';

class PostsSreen extends StatefulWidget {
   
  const PostsSreen({super.key});

  @override
  State<PostsSreen> createState() => _PostsSreenState();
}

class _PostsSreenState extends State<PostsSreen> {

  //Lista de Posts: la inicializo a null mientras no haya datos disponibles
  List<Post>? listaPosts;

  // Indicador para decir si está cargando o ha terminado la carga
  bool isLoading = false;

  @override
  void initState() {
    
    super.initState();
    // TODO: Aqui iniciaré la carga de los posts de la API
    obtenerPosts();

  } 

  // Obtener las publicaciones
  void obtenerPosts() async {

    listaPosts = await PostsService().obtenerPosts();
    // Aqui solo marcamos la carga como completada sí se recibió una respuesta válida
    if (listaPosts != null) {

      setState(() {
        isLoading = true;
      });

    }

  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Posts"),),
      body: Visibility(
        visible: isLoading,
        replacement: Center(child: CircularProgressIndicator.adaptive(),),
         child: ListView.builder(
          itemCount: listaPosts?.length,
          itemBuilder: (context, index) {
            
            return Padding(
              padding: const EdgeInsets.all(8.0),
              child: Row(
                spacing: 16,
                children: [
                  Container(
                    height: 50,
                    width: 50,
                    decoration: BoxDecoration(
                      borderRadius: .circular(12),
                      color: Colors.lightBlueAccent
                    ),
                  ),
                  
                  Expanded(
                    child: Column(
                      spacing: 20,
                      crossAxisAlignment: .start,
                      
                      children: [
                    
                        Text(listaPosts![index].title, maxLines: 3, overflow: .ellipsis, style: TextStyle(fontSize: 24, fontWeight: .bold),),
                        Text(listaPosts![index].body ?? "", maxLines: 3, overflow: .ellipsis,),
                    
                      ],
                    ),
                  ),
                ],
              ),
            );
          }
        ),
      ),
    );
  }

}