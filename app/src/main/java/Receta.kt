package teamfood.menufoodapp

data class Receta  (var nombre: String,
                    var imagen: Int,
                    var dificultad: Float,
                    var ingredientes: ArrayList<Int>,
                    var pasos: String)