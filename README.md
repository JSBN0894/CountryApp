
# CountryApp

## Requerimientos técnicos

En el desarrollo de la aplicación se utilizó el entorno de programación "**android studio"** junto con el lenguaje "**Kotlin**".

Los módulos o librerías utilizadas fueron:

 1. **Consumo de la API :**  
		Se utilizó la librería retrofit  para la conexión, y el convertidor GSON, para el análisis de la respuesta
> implementation "com.squareup.retrofit2:retrofit:2.9.0"  
implementation "com.squareup.retrofit2:converter-gson:2.9.0"



2. **Descarga de imagenes**
	para la descarga y decodificación de las banderas de cada país se utilizó la librería "Glide"1. 
	
implementation 'com.github.bumptech.glide:glide:4.14.2'  
annotationProcessor 'com.github.bumptech.glide:compiler:4.14.2'

# Descripción del proyecto
El proyecto consta de dos pantallas "MainActivity" y "DetailActivity".

 ## MainActivity
 
 Esta pantalla tiene los siguientes elementos:
	 * *RecyclerView* : Muestrá una lista deslizable con los items.	
	 * *SearchView* : Muestra una barra de búsqueda, para filtrar por país.

En el desarrollo de la **RecyclerView** Se crearon los siguientes archivos:
 1. **ItemAdapter.kt**:  Provee al RecyclerView las vistas que necesita pintar para cada uno de los componentes, y le indica también cómo utilizar los datos para actualizar la apariencia de la vista.

 2. **item_layout** : Es el archivo de diseño gráfico de cada item en la lista, este está conformado por una cardView que agrupa dos textView y un imageView


**Consumo de la API**
--
Para realizar la conexión a la API se hizo uso de corrutinas y fue necesario crear los siguientes archivos:
 1. **ApiServices.kt**: es una interfaz que se encarga de hacer las peticiones  HTTP GET  a la URL del proyecto
 2. **CountriesItem.kt**: es una **data class** en la cual definimos la misma estructura que tendrá la respuesta a la petición HTTP GET, algunos atributos de esta clase son objetos de otras clases, las cuales
representan el modelo de datos.


![image](https://github.com/JSBN0894/CountryApp/blob/master/Screenshots/Recycler%20View.jpeg)
![image](https://github.com/JSBN0894/CountryApp/blob/master/Screenshots/Fitered%20List.jpeg)
![image](https://github.com/JSBN0894/CountryApp/blob/master/Screenshots/DetailScreen.jpeg)


