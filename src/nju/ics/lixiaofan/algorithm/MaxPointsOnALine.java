package nju.ics.lixiaofan.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */

public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
		if(points.length < 3)
			return points.length;
		
		HashMap<Integer, P> count = new HashMap<Integer, P>();
		for(Point p : points){
			int key = hash(p);
			if(count.containsKey(key))
				count.get(key).w++;
			else{
				count.put(key, new P(p.x, p.y));
			}
		}
		
		P[] pts = new P[count.size()];
		count.values().toArray(pts);
		if(pts.length < 3){
			if(pts.length == 1)
				return pts[0].w;
			else
				return pts[0].w + pts[1].w;
		}
		
		for(P p : pts)
			System.out.println("["+p.x+","+p.y+"]\t"+p.w);
		
		HashMap<Co, Line> map = new HashMap<Co, Line>();
		int idx = 2, max = pts[0].w + pts[1].w;
		Co co = calCo(pts[0], pts[1]);
		map.put(co, new Line());
		map.get(co).s.add(pts[0]);
		map.get(co).s.add(pts[1]);
		map.get(co).n = pts[0].w + pts[1].w;
		
		Set<P> ol = new HashSet<P>();
		while(idx < pts.length){
			ol.clear();
			P p = pts[idx];
			for(Map.Entry<Co, Line> e : map.entrySet()){
				Co c = e.getKey();
				Line l = e.getValue();
				if(c.k != Double.POSITIVE_INFINITY){
					if(Math.abs(c.k * p.x + c.b - p.y) < 1e-6){
						ol.addAll(l.s);
						l.s.add(p);
						l.n += p.w;
						if(l.n > max)
							max = l.n;
					}
				}
				else if(Math.abs(c.b - p.x) < 1e-6){
					ol.addAll(l.s);
					l.s.add(p);
					l.n += p.w;
					if(l.n > max)
						max = l.n;
				}
			}
			
			for(int i = 0;i < idx;i++)
				if(!ol.contains(pts[i])){
					Co c2 = calCo(pts[i], p);
					map.put(c2, new Line());
					map.get(c2).s.add(pts[i]);
					map.get(c2).s.add(p);
					map.get(c2).n = pts[i].w + p.w;
				}
			idx++;
		}
		return max;
	}
	
	public int hash(Point p){
		return (p.x+"_"+p.y).hashCode();
	}
	
	public Co calCo(P a, P b){
		Co c = new Co();
		if(a.x == b.x){
			if(a.y == b.y)
				return null;
			c.k = Double.POSITIVE_INFINITY;
			c.b = a.x;
		}
		else if(a.y == b.y){
			c.k = 0;
			c.b = a.y;
		}
		else{
			c.k = (double)(b.y - a.y) / (b.x - a.x);
			c.b = a.y - c.k * a.x;
		}
		
		return c;
	}
	
	class Line{
		int n;
		Set<P> s;
		public Line() {
			n = 0;
			s = new HashSet<P>();
		}
	}
	
	class Co{
		double k, b; // y = kx + b;
		public Co(double k, double b) {
			this.k = k;
			this.b = b;
		}
		public Co() {
		}
	}
	
	class P{
		int x;
		int y;
		int w;

		P() {
			x = 0;
			y = 0;
			w = 1;
		}

		P(int a, int b) {
			x = a;
			y = b;
			w = 1;
		}
	}
	
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}
