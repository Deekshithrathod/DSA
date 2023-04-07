
public class TrieLecture {
  static class Node {
    Node[] children;
    boolean endOfWord;

    Node() {
      this.children = new Node[26];
      this.endOfWord = false;
      for (Node child : this.children) {
        child = null;
      }
    }
  }

  static Node root = new Node();

  public static void insert(String word) {
    Node currNode = root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';

      if (currNode.children[index] == null) {
        currNode.children[index] = new Node();
      }

      if (i == word.length() - 1) {
        currNode.children[index].endOfWord = true;
      }
      currNode = currNode.children[index];
    }
  }

  public static boolean search(String word) {
    Node currNode = root;

    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      Node node = currNode.children[index];
      // System.out.println(index + " " + word.charAt(i));

      if (node == null) {
        return false;
      }

      // System.out.println(currNode.endOfWord);
      if (i == word.length() - 1 && node.endOfWord == false) {
        return false;
      }

      currNode = currNode.children[index];
    }
    return true;
  }

  public static void main(String[] args) {

    // // fill the Trie structure
    // String words[] = { "the", "their", "there", "a", "any" };

    // for (String word : words) {
    // insert(word);
    // }

    // // check the trie formation
    // System.out.println(search("there"));
    // System.out.println(search("thor"));
    // System.out.println(search("an"));

    // -----------word break---------
    // String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
    // String key = "ilikesamsung";
    // String key = "ilikesam";
    // String key = "ilikesung";
    // buildTrie(words)
    // System.out.println(wordBreak(key));

    // --------------stats with--------------
    // String words[] = { "apple", "app", "mango", "man", "woman" };
    // buildTrie(words);

    // System.out.println(startsWith("app")); // true
    // System.out.println(startsWith("moon")); // false
    // System.out.println(startsWith("wom")); // true

    // String word = "apple";
    // ArrayList<String> words = new ArrayList<>();
    // for (int i = 0; i < word.length(); i++) {
    // words.add(word.substring(i));
    // }
    // buildTrie(words.toArray(new String[words.size()]));

    // System.out.println(uniqueSubstring(root));
    String[] words = { "a", "ap", "app", "bar", "appl", "apply", "apple" };
    buildTrie(words);

    findLongestWord(root, new StringBuilder());
    System.out.println(answer);
  }

  private static void buildTrie(String words[]) {
    for (String word : words) {
      insert(word);
    }
  }

  public static boolean startsWith(String word) {
    Node currNode = root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';

      if (currNode.children[index] == null) {
        return false;
      }

      currNode = currNode.children[index];
    }

    return true;
  }

  // word break problem
  public static boolean wordBreak(String key) {
    if (key.length() == 0) {
      return true;
    }

    for (int i = 1; i <= key.length(); i++) {
      String currSubString = key.substring(0, i);
      String otherPart = key.substring(i);
      boolean searchResult = search(currSubString);

      System.out.println(currSubString + ":" + searchResult);
      System.out.println(otherPart);
      System.out.println("--------");

      if (searchResult && wordBreak(otherPart)) {
        return true;
      }
    }

    return false;
  }

  // count the unique substrings
  public static int uniqueSubstring(Node root) {
    if (root == null) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < 26; i++) {
      // if (root.children[i] != null) {
      count += uniqueSubstring(root.children[i]);
      // }
    }
    return 1 + count;
  }

  // static StringBuilder str = new StringBuilder();
  // longest word that has all the substring
  static String answer = "";

  public static void findLongestWord(Node root, StringBuilder temp) {
    // if (root == null) {
    // return "";
    // }
    for (int i = 0; i < 26; i++) {
      if (root.children[i] != null) {
        temp = temp.append((char) (i + 'a'));
        if (temp.length() > answer.length()) {
          answer = temp.toString();
        }
        findLongestWord(root.children[i], temp);
        temp = temp.deleteCharAt(temp.length() - 1);
      }
      // temp = temp.re((char)(i+'a'));
      // count += uniqueSubstring(root.children[i]);
    }
    // return "-1";
  }
}
