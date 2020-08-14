/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3422/

Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
 

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 

Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.
*/

class CombinationIterator {
  int current = 0;
  int len = 0;
  String str;
  
  public CombinationIterator(String characters, int combinationLength) {
    this.current = (int) Math.pow(2, characters.length());
    this.str = characters;
    this.len = combinationLength;
    
  }

  public String next() {
    System.out.println("this");
    while(Integer.bitCount(--this.current) != this.len){}
    
    String bin = Integer.toBinaryString(this.current);
    String ans = "";
    
    int gap = this.str.length() - bin.length();
    
    for(int i = 0; i < bin.length(); i++){
      if(bin.charAt(i) == '1')
        ans += this.str.charAt(gap + i);
    }
    return ans;
  }

  public boolean hasNext() {
    System.out.println("that");
    int copy = this.current;
    while(--copy > 0){
      if(Integer.bitCount(copy) == this.len)
        break;
    }
    System.out.println(copy);
    return (copy > 0);
  }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
