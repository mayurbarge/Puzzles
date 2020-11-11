import scala.collection.mutable

// problem 1
/*
dict = ["abb", "abc", "xyz", "xyy"];
pattern = "foo"
Output: [xyy abb]
Explanation:
xyy and abb have same character at index 1 and 2 like the pattern

Input:
dict = ["abb", "abc", "xyz", "xyy"];
pat = "mno"
Output: [abc xyz]
Explanation:
abc and xyz have all distinct characters, similar to the pattern

Input:
dict = ["abb", "abc", "xyz", "xyy"];
pattern = "aba"
Output: []
Explanation:
Pattern has same character at index 0 and 2.
No word in dictionary follows the pattern.

Input:
dict = ["abab", "aba", "xyz", "xyx"];
pattern = "aba"
Output: [aba xyx]
Explanation:
aba and xyx have same character at index 0 and 2 like the pattern
 */


def encodeString( str:String)
{
  val map = mutable.HashMap[Char, Int]();

  var res = "";
  var i = 0;
  println("@@")
  // for each character in given string
  str.map(ch =>
  {
    println(ch)
    // If the character is occurring for the first
    // time, assign next unique number to that char
    if (!map.contains(ch)) {
      i = i + 1;
      map.put(ch,i);
    }

    // append the number associated with current
    // character into the output string
    val x: Option[Int] = map.get(ch)
    val y: Int = x.getOrElse(0)
    res = res.concat(
      y.toString
    );
    println(res)
  })
}

val encoded = encodeString("foo")


// problem 2

//check if characters in the input string follows the same order as
// determined by characters present in the pattern.
// Assume there won’t be any duplicate characters in the pattern.
//Input: string = "engineers rock", pattern = "er";
//Output: true
//All 'e' in the input string are before all 'r'.
val input = "engineers rock"
