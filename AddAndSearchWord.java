/*
https://leetcode.com/explore/featured/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3413/

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/


class WordDictionary {
    Map<Integer, ArrayList<String>> map;
    /** Initialize your data structure here. */
    public WordDictionary() {
      map = new HashMap<Integer, ArrayList<String>>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
      int len = word.length();
      if(map.containsKey(len)) {
        ArrayList<String> z = map.get(len);
        z.add(word);
        map.put(len, z);
      }
      else {
        ArrayList<String> t = new ArrayList<String>();
        t.add(word);
        map.put(len, t);
      }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
      int len = word.length();
      
      if(!map.containsKey(len))
        return false;
      else {
        ArrayList<String> t = map.get(len);
        boolean found = false;
        for(String s : t) {
          boolean matches = true;
          for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != word.charAt(i) && word.charAt(i) != '.') {
              matches = false;
              break;
            }
          }
          if(matches) {
            found = true;
            break;
          }
        }
        return found;
      }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
