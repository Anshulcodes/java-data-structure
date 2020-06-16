import java.io.*;

class linked{

  static Node head;

  static class Node{
    int data;
    Node next;

    Node(int d)
    {
      this.data=d;
      Node next=null;
    }
  }

  public static void insertNode(linked list, int data)
  {
      Node newNode= new Node(data);
      if(head==null)
      {
        list.head=newNode;
      }
      else
      {
        Node traverse= list.head;
        while(traverse.next!=null)
        {
          traverse=traverse.next;
        }
        traverse.next=newNode;
      }
  }

  public static void printList(linked list)
  {
    Node traverse=list.head;
    System.out.println("Linked List:");
    while(traverse!=null)
    {
      System.out.print(traverse.data+" ");
      traverse=traverse.next;
    }
    System.out.println("");
  }

  public static void reverseRecurr(linked list, Node previous, Node current, Node next)
  {
      if(current==null)
      {
        list.head=previous;
        return;
      }
      else
      {
        next= current.next;
        current.next=previous;

        reverseRecurr(list, current, next, next.next);
      }
  }


  public static void deleteNode(linked list, int pos)
  {
    Node traverse= list.head;
    for(int i=0; i<pos-2; i++)
    {
      traverse= traverse.next;
    }
    Node temp= traverse.next;
    traverse.next= temp.next;
    System.gc();
  }


  public static void reverseList(linked list)
  {
    Node current, previous, next;
    current= head;
    previous=null;
    while(current!=null)
    {
      next= current.next;
      current.next= previous;
      previous= current;
      current= next;
    }
    list.head= previous;
  }



  public static void main(String[] args)
  {
    linked ls= new linked();
    insertNode(ls, 1);
    insertNode(ls, 2);
    insertNode(ls, 3);
    insertNode(ls, 4);
    insertNode(ls, 5);
    printList(ls);
    deleteNode(ls,2);
    printList(ls);
    reverseList(ls);
    printList(ls);
    reverseRecurr(ls, null, head, head.next);
    printList(ls);
  }

}
