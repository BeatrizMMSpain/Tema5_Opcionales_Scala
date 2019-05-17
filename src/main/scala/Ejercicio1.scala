/**
  * Añade un atributo modelo a la clase vehículo del ejercicio guiado y un método para comparar los pesos de dos
  * vehículos. Este método imprimirá un mensaje que un modelo pesa menos que otro.
  */
object Ejercicio1 extends App {
  abstract class Vehiculo(){
    var color: String
    var peso: Int
    var modelo: String
  }

  class Coche(numeroRuedas: Int, c: String, p: Int, m: String) extends Vehiculo{
    var color = c
    var peso = p
    var modelo = m
  }

  class Barco(numeroVelas: Int, c: String, p: Int, m: String) extends Vehiculo{
    var color = c
    var peso = p
    var modelo = m
  }

  def devolverColor(v: Vehiculo)= v.color
  def devolverPeso(v: Vehiculo)= v.peso
  def comprarPeso(v1: Vehiculo, v2: Vehiculo) = {
    if (v1.peso > v2.peso) println(("El vehículo 1 pesa más que el 2"))
    else println("El vehiculo 2 pesa más que el 1")
  }

  override def main(args: Array[String]): Unit = {
    val vehiculo1 = new Coche(4, "rojo", 1500, "alto")
    val vehiculo2 = new Barco(2, "azul", 2000, "bajo")

    comprarPeso(vehiculo1, vehiculo2)

  }

}
