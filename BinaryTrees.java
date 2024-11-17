import java.util.Scanner;

public class BinaryTrees {

  public BinaryTrees() {

  }

  private static class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
}
    private Node root;
 
    
 
    public void populate(Scanner scanner) {
       System.out.println("Enter the root node:");
       int value = scanner.nextInt();
       this.root = new Node(value);
       this.populate(scanner, this.root);
    }
 
    private void populate(Scanner scanner, Node node) {
       System.out.println("Do you want to add left of" + node.value);
       boolean left = scanner.nextBoolean();
       if (left) {
          System.out.println("Enter the left node value:");
          int value = scanner.nextInt();
          node.left = new Node(value);
          this.populate(scanner, node.left);
       }
 
       System.out.println("Do you want to add right of" + node.value);
       boolean right = scanner.nextBoolean();
       if (right) {
          System.out.println("Enter the left node value:");
          int value = scanner.nextInt();
          node.right = new Node(value);
          this.populate(scanner, node.right);
       }
 
    }
 
    void display() {
       this.display(this.root, "");
    }
 
    private void display(Node node, String indent) {
       if (node != null) {
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
       }
    }
 
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       BinaryTrees tree = new BinaryTrees();
       tree.populate(scanner);
       tree.display();
    
 }
}
