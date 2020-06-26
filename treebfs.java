import java.util.Queue;
import java.util.LinkedList;



class Tree
{

  void levelOrder(Node node)
  {
    if(node==null)
    {
      return;
    }

    Queue<Node> q= new LinkedList<>();
    q.add(this.root);
    while(q.size()!=0)
    {
      System.out.print((q.peek()).data+" ");
      Node current= q.peek();
      if(current.left!=null)
      {
        q.add(current.left);
      }
      if(current.right!=null)
      {
        q.add(current.right);
      }
      q.remove();
    }

  }

  static class Node
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
}

class treebfs
{

  public static void main(String[] args)
  {
    Tree tr= new Tree();
    tr.insert(7);
    tr.insert(5);
    tr.insert(9);
    tr.insert(2);
    tr.insert(6);
    tr.insert(8);
    tr.insert(10);
    tr.insert(1);
    tr.insert(3);
    tr.levelOrder(tr.root);
  }
}
