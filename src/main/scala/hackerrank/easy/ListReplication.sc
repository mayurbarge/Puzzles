def f(num:Int,arr:List[Int]):List[Int] = {
  arr.foldLeft(List.empty[Int])((acc,e) => {
     acc ++  List.fill[Int](num)(e)
  })
}

f(2,List(1,2,3))