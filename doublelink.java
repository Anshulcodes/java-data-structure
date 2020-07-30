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
      this.next=null;
      this.previous=null;
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
    while(temp!=null)
    {
      System.out.print(temp.data+ " ");
      temp=temp.next;
    }
    System.out.println();
  }

  public static void delete(int data)
  {
    if(head.data==data)
    {
      head=head.next;
      return;
    }
    Node traverse= head;
    while(traverse.data != data)
    {
      traverse= traverse.next;
    }
    Node previous=traverse.previous;
    Node next= previous.next;
    previous.next= traverse.next;
    next.previous= traverse.previous;
    return;
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

    list.add(0);
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    printList(list);
    reverseList(list);
    printList(list);
    list.delete(2);
    printList(list);
  }

}
