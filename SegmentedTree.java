public class SegmentedTree {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentedTree tree = new SegmentedTree(arr);
         //tree.display();
    
        System.out.println(tree.query(1, 6));
      }
    private class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
        public Node(int startInterval,int endInterval ){
            this.startInterval= startInterval;
            this.endInterval=endInterval;

        }
    }
    Node root;
    public SegmentedTree(int[] arr){
        //create tree using this arr
        this.root = ConstructTree(arr, 0, arr.length-1);
    }
private Node ConstructTree(int [] arr, int start, int end){
    if(start == end){
        //leaf node
        Node leaf= new Node(start,end);
        leaf.data = arr[start];
        return leaf;
    }
    //create node at the location you are at 
    Node node = new Node(start,end);
    int mid = (start+end)/2;
    node.left = this.ConstructTree(arr, start, mid);
    node.right = this.ConstructTree(arr, mid+1, end);
    node.data= node.left.data + node.right.data;
    return node;
}
public void display() {
    display(this.root);
  }
  private void display(Node node) {
    String str = "";

    if(node.left != null) {
      str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => "; 
    } else {
      str = str + "No left child";
    }

    // for current node
    str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= "; 
    
    if(node.right != null) {
      str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data; 
    } else {
      str = str + "No right child";
    }

    System.out.println(str + '\n');

    // call recursion
    if(node.left != null) {
      display(node.left);
    }

    if(node.right != null) {
      display(node.right);
    }
  }

  // query
  public int query(int qsi, int qei) {
  return query(this.root, qsi, qei);
  }
  private int query(Node node , int qsi, int qei){
    if(node.startInterval>=qsi && node.endInterval<= qei){
        return node.data;
    }
    else if(node.startInterval>=qei || node.endInterval<=qsi){
        return 0;
    }
    else{
        return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
    }
  }
  public void update(int index, int value){
    this.root.data = update(this.root,index, value);
  }
  private int update(Node node, int index, int value){
    if(index>= node.startInterval && index <= node.endInterval){
        if(index== node.startInterval && index == node.endInterval){
            node.data = value;
            return node.data;
        }
    
    else{
        int leftAns = update(node.left, index, value);
        int rightAns = update(node.right, index, value);
        node.data = node.left.data + node.right.data;
        return node.data;
    }
  }
  return node.data;
}
}
