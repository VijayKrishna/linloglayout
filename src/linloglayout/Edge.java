package linloglayout;
//Copyright (C) 2008 Andreas Noack
//
//This library is free software; you can redistribute it and/or
//modify it under the terms of the GNU Lesser General Public
//License as published by the Free Software Foundation; either
//version 2.1 of the License, or (at your option) any later version.
//
//This library is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//Lesser General Public License for more details.
//
//You should have received a copy of the GNU Lesser General Public
//License along with this library; if not, write to the Free Software
//Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA 

/**
 * Weighted graph edge.
 * 
 * @author Andreas Noack (an@informatik.tu-cottbus.de)
 * @version 13.01.2008
 */
public class Edge {
    /** Start node. */ 
    public final Node startNode;
    /** End node. */ 
    public final Node endNode;
    /** Edge weight. */
    public final double weight;
    /** Edge density = <code>weight / (startNode.weight*endNode.weight)</code>. */
    public final double density;
    
    /**
     * Initializes the attributes.
     */
    public Edge(Node startNode, Node endNode, double weight) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;
        this.density = weight / (startNode.weight*endNode.weight);
    }
    
    public static Edge copyWithNewWt(Edge edge, double weight) {
      if(edge.startNode == null || edge.endNode == null) {
        throw new RuntimeException("Input edge is malformed.");
      }
      Edge copy = new Edge(edge.startNode, edge.endNode, weight);
      return copy;
    }
    
    /**
     * Returns a string representation of the object.
     */
    public String toString() {
        return startNode.name + "->" + endNode.name + " " + weight;
    }
    
    /**
     * 
     * @return
     */
    @Override
    public boolean equals(Object object) {
      if(object == null || !(object instanceof Edge))
        return false;
      
      Edge edge = (Edge) object;
      if(this.startNode.equals(edge.startNode) 
          && this.endNode.equals(edge.endNode)) {
        return true;
      }
      
      return false;
    }
    
    public int hashCode() {
      int hash = 31;
      hash += 17 * this.startNode.hashCode();
      hash += 17 * this.endNode.hashCode();
      return hash;
    }
}


