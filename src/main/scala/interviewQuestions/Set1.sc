
import scala.collection.mutable

class Student(var name:String) {
  override def hashCode(): Int = 1
  def getName = name
  def setName(newname:String) = {
    name = newname
  }

}
val map = new mutable.HashMap[String,Student]()
val s1 = new Student("mayur")
val s2 = new Student("Nint")
val key = "A"
map.put(s1.getName,s1)
s1.setName("new")

println(map.get(key).map(_.name))