public class Solution {
  public String simplifyPath(String path) {

    String[] dirs = path.split("/");
    int eat = 0;
    LinkedList<String> stack = new LinkedList<String>();

    for (int i = dirs.length - 1; i >= 0; i --) {
      if (".".equals(dirs[i]));
      else if ("".equals(dirs[i]));
      else if ("..".equals(dirs[i])) {
        eat ++;
      }
      else {
        if (eat > 0) {
          eat --;
        }
        else {
          stack.push(dirs[i]);
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    sb.append("/");

    if (stack.isEmpty()) return sb.toString();

    while (stack.size() > 1) {
      sb.append(stack.pop());
      sb.append("/");
    }

    sb.append(stack.pop());

    return sb.toString();

  }
}
