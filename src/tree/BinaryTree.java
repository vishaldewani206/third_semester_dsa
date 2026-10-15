package tree;

public class BinaryTree {
    private Object root;
    private BinaryTree left, right;

    public BinaryTree(Object root, BinaryTree left, BinaryTree right){
        this.root = root;
        this.left = left;
        this.right = right;
    }
    public BinaryTree(Object root){
        this.root = root;
    }

    public void setRoot(Object root){
        this.root = root;
    }

    public Object getRoot(){
        return root;
    }

    public void setLeft(BinaryTree left){
        this.left = left;
    }

    public BinaryTree getLeft(){
        return left;
    }
    public void setRight(BinaryTree right){
        this.right = right;
    }

    public BinaryTree getRight(){
        return right;
    }

    public String toString(){
        StringBuilder bf = new StringBuilder();
        bf.append(root).append(" ");
        if(left != null){
            bf.append(left);
        }
        if(right != null){
            bf.append(right);
        }

        return bf.toString();

    }

    public String inOrder(){
        StringBuilder bf = new StringBuilder();
        if(left != null){
            bf.append(left.inOrder());
        }
        bf.append(root).append(" ");
        if(right != null){
            bf.append(right.inOrder());
        }

        return bf.toString();

    }


    public String postOrder(){
        StringBuilder bf = new StringBuilder();
        if(left != null){
            bf.append(left.postOrder());
        }
        if(right != null){
            bf.append(right.postOrder());
        }
        bf.append(root).append(" ");

        return bf.toString();

    }

    int size(){
        if(left == null && right == null){
            return 1;
        }
        if(left == null){
            return right.size() + 1;
        }
        if(right == null){
            return left.size() + 1;
        }

        return 1 + left.size() + right.size();
    }

    public int height(){
        if(root == null){
            return  -1;
        }
        int leftSubTree = 0;
        int rightSubTree = 0;

        if(left != null){
            leftSubTree = 1 + left.height();
        }
        if(right != null){
            rightSubTree = 1 + right.height();
        }
        return Math.max(leftSubTree, rightSubTree);
//        return leftSubTree > rightSubTree ? leftSubTree : rightSubTree;

    }

    public boolean contains(Object value){
        if(root.equals(value)){
            return true;
        }
        if(left != null && left.contains(value)){
            return true;
        }
        if(right != null && right.contains(value)){
            return true;
        }
        return false;
    }

    public BinaryTree search(Object value){
        if(root.equals(value)){
            return this;
        }
        BinaryTree found = null;

        if(left != null){
            found = left.search(value);
        }
        if(found == null && right != null){
            found = right.search(value);
        }
        return found;
    }



    public static void main(String[] args) {
        BinaryTree B = new BinaryTree("B");
        BinaryTree D = new BinaryTree("D");
        BinaryTree E = new BinaryTree("E");
        BinaryTree C = new BinaryTree("C", D, E);
        BinaryTree A = new BinaryTree("A", B, C);


        System.out.println(A);
        System.out.println(A.contains("D"));
        BinaryTree result = A.search("E");
        if(result != null){
            System.out.println("Found: " + result.getRoot());
        }
    }


}
