import java.util.*;

class Graph<T>
{
  private Map<T, List<T>> map= new HashMap<>();

  public void addVertex(T vertex)
  {
    map.put(vertex, new LinkedList<T>());
  }


  public void addEdge(T source, T destination, boolean bidirectional)
  {
    if(!map.containsKey(source))
    {
        addVertex(source);
    }
    if(!map.containsKey(destination))
    {
      addVertex(destination);
    }
    (map.get(source)).add(destination);
    if(bidirectional)
    {
      map.get(destination).add(source);
    }
  }


  public int numberOfVertices()
  {
    return map.keySet().size();
  }

  public int numberOfEdges()
  {
    int count=0;
    for(T vertex: map.keySet())
    {
      count+= map.get(vertex).size();
    }
    if(isBidirectional())
    {
      count=count/2;
    }
    return count;
  }

  public boolean isBidirectional()
  {
    for(T vertex: map.keySet())
    {
      for(T link: map.get(vertex))
      {
        if(!map.get(link).contains(vertex))
        {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public String toString()
  {
    String struct="";
    for(T vertex: map.keySet())
    {
      struct= struct+vertex.toString()+" : ";
      for(T link: map.get(vertex))
      {
        struct= struct + link.toString()+" ";
      }
      struct=struct+"\n";
    }
    return struct;
  }
}


class graph
{
  public static void main(String args[])
  {
    Graph<Integer> gr= new Graph<Integer>();
    gr.addVertex(1);
    gr.addEdge(1,2, true);
    gr.addEdge(2,3, true);
    gr.addEdge(2,4, true);
    gr.addEdge(4,1, true);
    System.out.println(gr.toString());
    System.out.println("Number of Vertices: "+gr.numberOfVertices());
    System.out.println("Number of Edges: "+gr.numberOfEdges());
    System.out.println(gr.isBidirectional());
  }
}
