object Ejercicio3 extends App {
  abstract class Persona(){
    var nombre: String
    var edad: Int
    var telefono: Int
    var direccion: String

    def devolverNombre()= nombre
  }

  case class Empleado(puesto: String, n: String, e: Int, t: Int, d: String) extends Persona{
    var nombre = n
    var edad = e
    var telefono = t
    var direccion = d
  }

  case class Jefe(empleados: List[Empleado], n: String, e: Int, t: Int, d: String) extends Persona{
    var nombre = n
    var edad = e
    var telefono = t
    var direccion = d

    def devolverEmpleados()={
      println(empleados)
    }
  }

  override def main(args: Array[String]): Unit = {
    val empleados1: List[Empleado] = List(
      new Empleado("Account", "Patricia", 28, 12345, "Calle del Arenal"),
      new Empleado("Project Manager", "Javier", 28, 12345, "Calle del Arenal"),
      new Empleado("RRHH", "Teresa", 26, 12345, "Calle del Arenal"))

    val empleados2: List[Empleado] = List(
      new Empleado("Administración", "Eva", 35, 12345, "C/Mayor"),
      new Empleado("Consultor", "Adolfo", 38, 12345, "C/Mayor"),
      new Empleado("Consultor", "Cristina", 27, 12345, "C/Mayor"))

    val jefes1: Jefe = new Jefe(empleados1, "Lucía", 24, 123456, "C/Alonso Martínez" )

    val jefes2: Jefe = new Jefe(empleados2, "Ángel", 26, 123456, "C/Alonso Martínez" )

    print("Para el jefe: " + jefes1.devolverNombre() + ". Tiene los siguientes empleados: " + jefes1.devolverEmpleados())
    print("Para el jefe: " + jefes2.devolverNombre() + ". Tiene los siguientes empleados: " + jefes2.devolverEmpleados())
  }

}
