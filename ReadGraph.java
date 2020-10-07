import java.io.*;
import java.util.*;

		class ColEdge
			{
			int u;
			int v;
			}
		
public class ReadGraph
		{
		
		public final static boolean DEBUG = true;
		
		public final static String COMMENT = "//";
		
		public static void main( String args[] )
			{
			if( args.length < 1 )
				{
				System.out.println("Error! No filename specified.");
				System.exit(0);
				}

				
			String inputfile = args[0];
			
			boolean seen[] = null;
			
			//! n is the number of vertices in the graph
			int n = -1;
			
			//! m is the number of edges in the graph
			int m = -1;
			
			//! e will contain the edges of the graph
			ColEdge e[] = null;
			
			try 	{ 
			    	FileReader fr = new FileReader(inputfile);
			        BufferedReader br = new BufferedReader(fr);

			        String record = new String();
					
					//! THe first few lines of the file are allowed to be comments, staring with a // symbol.
					//! These comments are only allowed at the top of the file.
					
					//! -----------------------------------------
			        while ((record = br.readLine()) != null)
						{
						if( record.startsWith("//") ) continue;
						break; // Saw a line that did not start with a comment -- time to start reading the data in!
						}
	
					if( record.startsWith("VERTICES = ") )
						{
						n = Integer.parseInt( record.substring(11) );					
						if(DEBUG) System.out.println(COMMENT + " Number of vertices = "+n);
						}

					seen = new boolean[n+1];	
						
					record = br.readLine();
					
					if( record.startsWith("EDGES = ") )
						{
						m = Integer.parseInt( record.substring(8) );					
						if(DEBUG) System.out.println(COMMENT + " Expected number of edges = "+m);
						}

					e = new ColEdge[m];	
												
					for( int d=0; d<m; d++)
						{
						if(DEBUG) System.out.println(COMMENT + " Reading edge "+(d+1));
						record = br.readLine();
						String data[] = record.split(" ");
						if( data.length != 2 )
								{
								System.out.println("Error! Malformed edge line: "+record);
								System.exit(0);
								}
						e[d] = new ColEdge();
						
						e[d].u = Integer.parseInt(data[0]);
						e[d].v = Integer.parseInt(data[1]);

						seen[ e[d].u ] = true;
						seen[ e[d].v ] = true;
						
						if(DEBUG) System.out.println(COMMENT + " Edge: "+ e[d].u +" "+e[d].v);
				
						}
									
					String surplus = br.readLine();
					if( surplus != null )
						{
						if( surplus.length() >= 2 ) if(DEBUG) System.out.println(COMMENT + " Warning: there appeared to be data in your file after the last edge: '"+surplus+"'");						
						}
					
					}
			catch (IOException ex)
				{ 
		        // catch possible io errors from readLine()
			    System.out.println("Error! Problem reading file "+inputfile);
				System.exit(0);
				}

			for( int x=1; x<=n; x++ )
				{
				if( seen[x] == false )
					{
					if(DEBUG) System.out.println(COMMENT + " Warning: vertex "+x+" didn't appear in any edge : it will be considered a disconnected vertex on its own.");
					}
				}

			//! At this point e[0] will be the first edge, with e[0].u referring to one endpoint and e[0].v to the other
			//! e[1] will be the second edge...
			//! (and so on)
			//! e[m-1] will be the last edge
			//! 
			//! there will be n vertices in the graph, numbered 1 to n

			//! INSERT YOUR CODE HERE!
			
			
			
			
				
			
		}

}



//my code still didnt work , here is the furthest i have got:
    class Edge{
        int source, dest;

        public Edge(int source, int dest){
            this.source = source;
            this.dest = dest;
        }
    }

////used to represent the graph object using adjeceny list
    class Graph{
        List<List<Integar>> adList = null;

        Graph(List<Edege> edges, int N){
            adjust = new ArrayList<>();
            for (int i =0; i < N; i++){
                adjList.add(new ArrayList<>());
            }

        //add edges to the undirected graph
            for (Edge edge: edges){
                int src = edge.source;
                int dest = edge.dest;

                adjList.get(src).add(dest);
                adjList.get(dest).add(src);
            }
    }
}

    class Main{
    //add more colours to the vertices
        public static int color[] = new[];

    //method to assign colors
        public static void colorGraph(Graph graph, int n){
        //store color to vertex
        unordered_map<int, int> result;

        //give every vertex an index
        for (int j = 0; j< n; j++){
            for (int i : graph.adjList.get(u)){
                if (result.containsKey(i)){
                    assigned.add(result.get(i));                
                }
            }
        }
    }

//check for the first free color
        int color =1;
        for (Integar c : assigned){
            if (color != c){
                break;
            }
            color++;
        }
        result.put(u,color);   //the first avaible color
    }
    for (int v = 0; v<N; v++){
        System.out.println("xxxxxx");
    }
}


public class GraphColoring2 {
    
    //main
    public static void main(String[] args){
        List<Edge> edges = Array.asList{
            new Edge(0,1),
        }
        
        int n = in.nextlnt();
        Graph graph = new Graph(edges, n);
    
        colorGraph(graph,n);
    }
    
}



