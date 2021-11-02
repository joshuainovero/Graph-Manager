package graphmanager;

public class CPair <T1, T2> implements Comparable<CPair<T1, T2>> {
	public T1 first;
	public T2 second;
	
	private CPair(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}
	
	static public<T1, T2> CPair <T1, T2> makePair(T1 a, T2 b) {
		return new CPair<T1, T2>(a, b);
	}
	

	public int compareTo(CPair <T1, T2> cpair) {
		if ((int)this.first > (int)cpair.first) {
			return 1;
		}
		else if ((int)this.first < (int)cpair.first) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
