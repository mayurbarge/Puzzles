import Graph1.{Edge, Vertex}

import scala.collection.mutable

object Graph1 {
   class Vertex {
    val edges = mutable.Set[Vertex]()
  }
  case class Edge(dest: Vertex, weight: Int)

  def dfsMutableRecursive(current: Vertex) = {
    val found = mutable.Set[Vertex]()
    def recurse(current: Vertex): Unit = {
      found += current
      for(next <- current.edges) {
        if(!found.contains(next)) {
          recurse(next)
        }
      }
    }
    recurse(current)
    found
  }
}

object Graph2 {
  class Vertex {
    val edges = mutable.Set[Edge]()
  }
  case class Edge(dest: Vertex, weight: Int)

  def graphRepresentationVerticesAndNodes = {
    val graph = Array.fill(4)(new Vertex())
    graph(0).edges += Edge(graph(1),2) += Edge(graph(2),2)
  }

  def adjacencyList = {
    val adjacencyMatrix = Array(Array.f).
  }
}


/*
Complete this solution with fold looops.
val result = List.empty[Vertex].foldLeft(mutable.ListBuffer.empty[Vertex])((acc,e)=> {
  e.edges.toList match {
    case head :: tail => if(!acc.contains(head)) {

    } else acc += head
    case Nil => acc
  }

})*/

case class City(name: String)
case class Route(from: City, to: City, distance: Int)
