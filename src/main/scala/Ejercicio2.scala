object Ejercicio2 extends App {
  abstract class Vehiculo{
    def marca: String
  }

  case class Coche(m: String) extends Vehiculo{
    var marca = m
  }

  //Covarianza permite tipar Parking[Vehiculo] y asignarle un Aparcamiento[Coche]
  def AparcamientoCo(vehiculos: List[Vehiculo])={
    vehiculos.foreach(vehiculo => println(vehiculo.marca))
  }

  //Contravarianza tipar Aparcamiento[Coches] y asignarle un Aparcamiento[Vehiculo]
  abstract class AparcamientoCon[-A] {
    def print(value: A): Unit
  }

  class PrinterVehiculo extends AparcamientoCon[Vehiculo] {
    def print(vehiculo: Vehiculo): Unit = println("El vehiculo es: " + vehiculo.marca)
  }

  class PrinterCoche extends AparcamientoCon[Coche] {
    def print(coche: Coche): Unit =println("La marca del coche es: " + coche.marca)
  }

  def printMiCoche(printer: AparcamientoCon[Coche], c: Coche): Unit = {
    printer.print(c)
  }

  override def main(args: Array[String]): Unit = {
    val misCoches: List[Coche] = List(Coche("Peugeot"), Coche("Renault"))

    //Un método que espera List[Vehiculo] acepta List[Coche]
    AparcamientoCo(misCoches)

    val PrinterCoche: AparcamientoCon[Coche] = new PrinterCoche
    val PrinterVehiculo: AparcamientoCon[Vehiculo] = new PrinterVehiculo

    printMiCoche(PrinterCoche, misCoches(0))
    printMiCoche(PrinterVehiculo, misCoches(1))
  }


}
