val his = scala.collection.concurrent.TrieMap[Int, String](0->"aa",
  1->"bb",5->"cc",700->"dd")

his.values.toList
