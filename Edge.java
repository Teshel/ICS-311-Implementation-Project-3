package ics311;

import java.util.HashMap;
import java.util.Map;

public class Edge {
	private Vertex u;
	private Vertex v;
	private Map<Object,Object> annotations;
	private boolean directed;
	private float distance;
	public Node node;
	
	public Edge(Vertex u, Vertex v, Object info, boolean d, float w) {
		this.node = new Node(0);
		this.node.edge = this;
		this.node.vertices.add(v);
		this.node.vertices.add(u);
		this.distance = w;
		this.u = u;
		this.v = v;
		u.insertAdjacentEdge(this);
		v.insertAdjacentEdge(this);
		annotations = new HashMap<Object,Object>();
		this.directed = d;
	}
	
	public Node community() {
		return node.findSet();
	}
	
	public float getDist() {
		return this.distance;
	}
	
	public void setDist(float dist) {
		this.distance = dist;
	}
	
	public Vertex[] endVertices() {
		Vertex[] va = new Vertex[2];
		va[0] = u;
		va[1] = v;
		return va;
	}

	public Vertex origin() {
		return u;
	}
	
	public Vertex destination() {
		return v;
	}
	
	public void setDirected(boolean d) {
		directed = d;
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDestination(Vertex newDestination) {
		setDirected(true);
		u = newDestination;
	}

	public void setOrigin(Vertex newOrigin) {
		setDirected(true);
		v = newOrigin;
	}

	public Object getAnnotation(Object k) {
		return annotations.get(k);
	}

	public void setAnnotation(Object k, Object v) {
		annotations.put(k, v);
	}

	public void reverse() {
		// TODO Auto-generated method stub
		Vertex tu = u;
		u = v;
		v = tu;
	}
	
	public String printString() {
		return "{" + u.getName() + ", " + v.getName() + "}";
	}
}
