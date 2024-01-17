package movimientoRobot

enum class Direccion {
    PositiveY, NegativeX, NegativeY, PositiveX
}

class Robot(private val nombre: String) {

    init {
        require(nombre.isNotEmpty()) {"Nombre no puede ser vacío."}
    }

    var posX = 0
    var posY = 0
    var dir = 0
    var movimiento = 0

    fun mover(movimientos: IntArray) {

        for (elemento in movimientos) {

            when (dir) {
                0 -> posY += elemento
                1 -> posX -= elemento
                2 -> posY -= elemento
                3 -> posX += elemento
            }
            if (dir == 3) {
                dir = 0
            } else {
                ++dir
            }
        }

        ++movimiento
    }

    private fun obtenerDireccion(): String {
        return when (dir) {
            0 -> Direccion.PositiveY.name
            1 -> Direccion.NegativeX.name
            2 -> Direccion.NegativeY.name
            3 -> Direccion.PositiveX.name
            else -> throw IllegalArgumentException("Direccion no válida: $dir")
        }
    }

    fun mostrarPosicion() {
        println("Movimiento $movimiento -> $nombre está en ($posX, $posY) ${obtenerDireccion()}")
    }
}

fun main() {

    val robot1 = Robot("R2D2")

    val listaMovimientos = listOf(
        intArrayOf(10, 5, -2),
        intArrayOf(0, 0, 0),
        intArrayOf(),
        intArrayOf(-10, -5, 2),
        intArrayOf(-10, -5, 2, 4, -8),
        intArrayOf(3, 3, 5, 6, 1, 0, 0, -7),
        intArrayOf(1, -5, 0, -9),
        intArrayOf(2, 1, 0, -1, 1, 1, -4),
        intArrayOf(3, 5),
        intArrayOf(4)
    )

    for (movimiento in listaMovimientos) {
        robot1.mover(movimiento)
        robot1.mostrarPosicion()
    }
}