
/**
 * AVL_Tree
 * 1. I have to make a balanced binary tree.
 * 2. Actually the main work is in the insert
 * 
 *  
 */

class Nodeo {
    Position item;
    int height;
    Nodeo left;
    Nodeo right;
    Nodeo parent;
    Nodeo(Position data, Nodeo pare)
    {
        item = data;
        height = 0 ;
        parent = pare;
    }
}

public class AVL_Tree {
    Nodeo root;

    int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 

    int height(Nodeo N) { 
        if (N == null)
        { 
            return -1; 
        }
        return N.height ; 
    } 

    int getBalance(Nodeo N) { 
        if (N == null) 
            return 0; 
        if(height(N.left) - height(N.right)>0)
        {
            return height(N.left) - height(N.right);
        }
        else {
            return -height(N.left) + height(N.right);
        }
    } 

    Nodeo rotate(Nodeo z)
    {
        //z: 1st nodeo where first nodeo unbalanced is observed
        //y: higher chid of z in terms of subtree height
        //x: higher child of y in terms of subtree height 
        Nodeo y,x;
        Nodeo zParent = z.parent;
        boolean zrighty,zlefty,yrightx,yleftx;
        zrighty=false;zlefty=false;yrightx=false;yleftx=false;
        if(height(z.left)>height(z.right))
        {
            y=z.left;
            zlefty=true;
        }
        else
        {
            y=z.right;
            zrighty=true;
        }

        if(height(y.left)>height(y.right))
        {
            x=y.left;
            yleftx=true;
        }
        else
        {
            x= y.right;
            yrightx=true;
        }
        //Actually Four cases will be made in double rotation
        if(zrighty && yrightx)
        {
            y.parent = zParent;
            z.right=y.left;
            if(y.left!=null)
                y.left.parent=z;
            y.left=z;
            z.parent=y;
            x.height=1+max(height(x.left),height(x.right));
            z.height=1+max(height(z.left),height(z.right));
            y.height=1+max(height(y.left),height(y.right));
            return y;
        }
        else if(zrighty && yleftx)
        {
            x.parent=zParent;
            z.right=x.left;
            if(x.left!=null)
                x.left.parent=z;
            y.left=x.right;
            if(x.right!=null)
                x.right.parent=y;
            x.right=y;
            x.left=z;
            y.parent=x;
            z.parent=x;
            x.height=1+max(height(x.left),height(x.right));
            z.height=1+max(height(z.left),height(z.right));
            y.height=1+max(height(y.left),height(y.right));
            return x;
        }
        else if(zlefty && yrightx)
        {
            x.parent=zParent;
            z.left=x.right;
            if(x.right!=null)
                x.right.parent=z;
            y.right=x.left;
            if(x.left!=null)
                x.left.parent=y;
            x.left=y;
            x.right=z;
            y.parent=x;
            z.parent=x;
            x.height=1+max(height(x.left),height(x.right));
            z.height=1+max(height(z.left),height(z.right));
            y.height=1+max(height(y.left),height(y.right));
            return x;
        }
        else if(zlefty && yleftx)
        {
            y.parent=zParent;
            z.left=y.right;
            if(y.right!=null)
                y.right.parent=z;
            y.right=z;
            z.parent=y;
            x.height=1+max(height(x.left),height(x.right));
            z.height=1+max(height(z.left),height(z.right));
            y.height=1+max(height(y.left),height(y.right));
            return y; 
        }
        return null;
    }

    Nodeo insert(Nodeo node,Position element)
    {
        if(node==null)
        {
            node = new Nodeo(element, null);
            return node;
        }

        if(element.getWordIndex()>node.item.getWordIndex())
        {
            node.right = insert(node.right, element);
        }
        else if(element.getWordIndex()<node.item.getWordIndex())
        {
            node.left = insert(node.left, element);
        }
        else
            return node;

        node.height = 1 + max(height(node.left),height(node.right));
        int balance = getBalance(node);
        // System.out.print(node.height+" "+balance+" "+ node.item.getWordIndex()+"\n");
        if(balance>1)
        {
            // System.out.print("159**");
            node=rotate(node);
        }
        
        return node;
    }

    Position search(Nodeo node,Position element)
    {
        if(node==null)
        {
            //no element exist
            return null;
        }
        if(element.getWordIndex()>node.item.getWordIndex())
        {
            return search(node.right, element);
        }
        else if(element.getWordIndex()<node.item.getWordIndex())
        {
            return search(node.left, element);
        }
        else
        {
            return node.item;
        }
    }
    // The function also prints height of every node 
    void preOrder(Nodeo node) { 
        if (node != null) { 
            System.out.print(node.item.getWordIndex() + " "); 
            preOrder(node.left); 
            preOrder(node.right); 
        } 
    } 

    public static void main(String[] args) {
        AVL_Tree tree = new AVL_Tree();
        Position a = new Position(null, 10);
        Position b = new Position(null, 20);
        Position c = new Position(null, 30);
        Position d = new Position(null, 40);
        Position e = new Position(null, 50);
        Position f = new Position(null, 25);
        Position g = new Position(null, 75);
        Position h = new Position(null, 556);
        tree.root = tree.insert(tree.root, a); 
        tree.preOrder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, b); 
        tree.preOrder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, c); 
        tree.preOrder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, d); 
        tree.preOrder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, e); 
        tree.preOrder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, f);
        tree.preOrder(tree.root);
        System.out.println();
        System.out.println("from"); 
        tree.root = tree.insert(tree.root, g);
        tree.preOrder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, h);
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println(tree.search(tree.root, f).getWordIndex());
        System.out.println(tree.search(tree.root, b).getWordIndex());  
        System.out.println(tree.search(tree.root, a).getWordIndex());  
        System.out.println(tree.search(tree.root, e).getWordIndex());          
        System.out.println(tree.search(tree.root, d).getWordIndex());  
    }
}