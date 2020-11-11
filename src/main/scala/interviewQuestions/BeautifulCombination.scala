package interviewQuestions

class BeautifulCombination {

  val arr = (1 to 3).permutations.toList

  var count = 0
  for(i <- 0 to arr.size - 1) {
    var flag = false
    for(j <- 0 to arr.size - 1) {
      if( arr(i)(j) % (j+1) == 0 || (j+1) % arr(i)(j) == 0 ) flag = true
      else flag = false
    }
    if(flag == true) count =  count + 1
  }

}
