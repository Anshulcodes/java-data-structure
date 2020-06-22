import java.util.*;

class Node
{
  int data;
  Node left;
  Node right;

  Node(int data)
  {
    this.data= data;
    this.left= null;
    this.right= null;
  }
}

class Tree
{
  Node root= null;

  void insert(int data)
  {
    Node temp= new Node(data);
    if(this.root==null)
    {
      this.root=temp;
      return;
    }
    Node traverse= root;
    while(true)
    {
      if(data<traverse.data)
      {
        if(traverse.left!=null)
        {
          traverse=traverse.left;
        }
        else
        {
          traverse.left=temp;
          break;
        }
      }
      else if(data>traverse.data)
      {
        if(traverse.right!=null)
        {
        traverse=traverse.right;
        }
        else
        {
          traverse.right=temp;
          break;
        }
      }
      else
      {
        System.out.println("Already exists..");
        break;
      }
    }
  }

  void delete(int data)
  {
    this.root= deleteNode(this.root, data);
  }

  Node deleteNode(Node node, int data)
  {
    if(node==null)
    {
      return null;
    }
    else if(data<node.data)
    {
      node.left= deleteNode(node.left, data);
      return node;
    }
    else if(data>node.data)
    {
      node.right= deleteNode(node.right, data);
      return node;
    }
    else
    {
      // nodes with zero child
      if(node.left==null && node.right==null)
        {
          return null;
        }

      // nodes with one child

      else if(node.left==null)
      {
        return node.right;
      }

      else if(node.right==null)
      {
        return node.left;
      }

      // nodes with two children
      else
      {
        node.data= minAtRight(node.right);
        deleteNode(node.right, node.data);
        return node;
      }
    }
  }

  int minAtRight(Node node)
  {
    if(node.left==null)
    {
      return node.data;
    }
    return minAtRight(node.left);
  }

  void traverse()
  {
    traversal(this.root);
    System.out.println("");
  }

  void traversal(Node node)
  {
    if(node!=null)
    {
      traversal(node.left);
      System.out.print(node.data+" ");
      traversal(node.right);
    }
  }

  boolean isBalanced(Node node)
  {
    if(node==null)
    {
      return true;
    }
    int lefth= height(node.left);
    int righth= height(node.right);
    if(Math.abs(lefth-righth)<=1 && isBalanced(node.left) && isBalanced(node.right))
    {
      return true;
    }
    return false;
  }

  int height(Node node)
  {
    if(node==null)
    {
      return -1;
    }
    return Math.max(height(node.left), height(node.right))+1;
  }
}


class tree
{
  public static void main(String[] args)
  {
    Tree tr= new Tree();
    tr.insert(7);
    tr.insert(9);
    tr.insert(5);
    tr.insert(2);

    tr.insert(6);
    tr.insert(8);
    tr.insert(10);
    tr.insert(3);
    tr.insert(1);

    tr.traverse();
    System.out.println(tr.isBalanced(tr.root));
    tr.delete(7);
    tr.traverse();

      System.out.println(tr.height(tr.root));
  }
}
