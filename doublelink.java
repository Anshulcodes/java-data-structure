import java.io.*;

class doublelink{

  static class Node
  {
    int data;
    Node next;
    Node previous;

    Node(int data)
    {
      this.data=data;
    }
  }

  static Node head;

  public static void add(int data)
  {
    Node temp= new Node(data);
    if(head==null)
    {
      temp.previous=head;
      temp.next=null;
      temp.previous=null;
      head= temp;
    }
    else{
      Node traverse=head;
      while(traverse.next!=null)
      {
        traverse= traverse.next;
      }
      traverse.next=temp;
      temp.previous=traverse;
      temp.next=null;
    }
  }

  public static void printList(doublelink list)
  {
    Node temp= list.head;
    System.out.println("Double Linked list:");
    System.out.println("");
    while(temp.next!=null)
    {
      System.out.println(temp.previous+" "+temp.data+ " "+ temp.next);
      temp=temp.next;
    }
    System.out.println(temp.previous+" "+temp.data+ " "+ temp.next);
  }

  public static void reverseList(doublelink link)
  {
      if(head==null)
      {
        return;
      }
      else
      {

        Node traverse= head;
        Node temp=null;
        while(traverse.next!=null)
        {
          temp=traverse.previous;
          traverse.previous=traverse.next;
          traverse.next=temp;
          traverse=traverse.previous;
        }
        traverse.next=traverse.previous;
        traverse.previous=null;
        head=traverse;
      }
  }


  public static void main(String[] args)
  {
    head=null;
    doublelink list= new doublelink();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    printList(list);
    reverseList(list);
    printList(list);
  }

}
