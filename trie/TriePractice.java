public class TriePractice {
  static class Node {
    Node[] children;
    boolean endOfWord;

    Node() {
      this.endOfWord = false;
      this.children = new Node[26];
      for (int i = 0; i < 26; i++) {
        this.children[i] = null;
      }
    }
  }

  static Node root = new Node();

  static void insert(String word) {
    Node currNode = root;
    for (int i = 0; i < word.length(); i++) {
      int currChar = word.charAt(i);
      int index = currChar - 'a';

      if (currNode.children[index] == null) {
        currNode.children[index] = new Node();
      }

      if (i == word.length() - 1) {
        currNode.children[index].endOfWord = true;
      }
      currNode = currNode.children[index];
    }
  }

  static boolean search(String word) {
    Node currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char currChar = word.charAt(i);
      int index = currChar - 'a';
      Node temp = currNode.children[index];
      if (temp == null) {
        return false;
      }
      if (i == (word.length() - 1) && !temp.endOfWord) {
        return false;
      }

      // currNode.children[index] = new Node();
      currNode = currNode.children[index];
    }
    return true;
  }

  public static void main(String args[]) {
    // String words[] = { "the", "their", "there", "a", "any" };

    // for (String word : words) {
    // insert(word);
    // }

    // // check the trie formation
    // System.out.println(search("there"));
    // System.out.println(search("thor"));
    // System.out.println(search("an"));
    // System.out.println(search("a"));

    // -----------word break---------
    // String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
    // // String key = "ilikesamsung";
    // String key = "ilikesam";
    // // String key = "ilikesung";
    // buildTrie(words);
    // System.out.println(wordBreak(key));

    // String words[] = { "apple", "app", "mango", "man", "woman" };
    // buildTrie(words);

    // System.out.println(startsWith("app")); // true
    // System.out.println(startsWith("moon")); // false
    // System.out.println(startsWith("wom")); // true

    // all unique substrings
    String word = "apple";
    for (int i = 0; i < word.length(); i++) {
      insert(word.substring(i, word.length()));
    }
    System.out.println(countUniques(root));
  }

  private static void buildTrie(String words[]) {
    for (String word : words) {
      insert(word);
    }
  }

  // can the given word be broken into following things
  static boolean wordBreak(String word) {
    if (word.length() == 0) {
      return true;
    }

    for (int i = 1; i <= word.length(); i++) {
      String currHalf = word.substring(0, i);
      String otherHalf = word.substring(i);
      boolean searchResult = search(currHalf);
      if (searchResult && wordBreak(otherHalf)) {
        return true;
      }
    }

    return false;
  }

  static boolean startsWith(String word) {
    Node currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char currChar = word.charAt(i);
      int index = currChar - 'a';
      Node temp = currNode.children[index];
      if (temp == null) {
        return false;
      }
      currNode = currNode.children[index];
    }
    return true;
  }

  static int countUniques(Node root) {
    if (root == null) {
      return 0;
    }

    int count = 0;
    for (Node node : root.children) {
      count += countUniques(node);
    }
    return count + 1;
  }

  // longest substring
  static String answer = "";

  static void longestSubString(Node root, StringBuilder temp) {

    // if (root == null) {
    //   return "";
    // }

    for (int i = 0; i < 26; i++) {
      if (root.children[i] != null) {
        temp.append((char) ('a' + i));

        if(temp.length() > answer.length()){
          answer = temp.toString();
        }
        longestSubString(root.children[i], temp);

        temp.deleteCharAt(temp.length());
      }
    }
  }
}
