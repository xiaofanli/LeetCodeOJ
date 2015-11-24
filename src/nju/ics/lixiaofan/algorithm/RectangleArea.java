package nju.ics.lixiaofan.algorithm;
/*Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner.

Assume that the total area is never beyond the maximum possible value of int.*/
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int overlap = Math.min(C, G) > Math.max(A, E)
				&& Math.min(D, H) > Math.max(B, F) ? (Math.min(C, G) - Math
				.max(A, E)) * (Math.min(D, H) - Math.max(B, F)) : 0;
		return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
    }
}
