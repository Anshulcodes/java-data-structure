import java.io.*;

class queue
{
  static class Node
  {
    int data;
    Node next;

    Node(int data)
    {
      this.data=data;
      this.next=null;
    }

  }


  Node front;
  Node rear;

  queue()
  {
    this.front=null;
    this.rear=null;
  }

  void enqueue(int data)
  {
    Node temp= new Node(data);
    if(this.front==null)
    {
      this.front=temp;
      this.rear=temp;
    }
    else{
      Node traverse= this.front;
      while(traverse.next!=null)
      {
        traverse= traverse.next;
      }
      traverse.next= temp;
      this.rear= temp;
    }
  }

  int rear()
  {
     if(rear!=null)
     {
       return this.rear.data;
     }
     else
     {
       return -1;
     }
  }

  void dequeue()
  {
    if(this.front== null)
    {
      System.out.println("Not possible...");
    }
    else
    {
      this.front=this.front.next;
    }
  }

  void front()
  {
    System.out.println(this.front.data+ "  ");
    return;
  }

  void printQueue()
  {
    if(this.front==null)
    {
      System.out.println("Queue empty...");
    }

    else{
      Node traverse=this.front;
      while(traverse!=null)
      {
        System.out.print(traverse.data+"  ");
        traverse=traverse.next;
      }
      System.out.println("");
    }
  }

  // to delete from the end of queue
  public static queue pop(queue q1)
  {
      Node previous=null;
      Node current= q1.front;
      if(current==null)
      {
        System.out.println("Not possible...");
        return null;
      }
      while(current.next!=null)
      {
        previous=current;
        current=current.next;
      }
      previous.next=null;
      q1.rear=previous;
      return q1;
  }


  public static void main(String[] args) throws IOException
  {
      queue q1= new queue();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n= Integer.parseInt(br.readLine().trim());
      while(n>0)
      {
        q1.enqueue(Integer.parseInt(br.readLine().trim()));
        n--;
      }
      q1.printQueue();
      q1.dequeue();
      q1.printQueue();
  }

}
