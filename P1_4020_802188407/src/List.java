
public interface List<E> extends Iterable<E> {

	public void add(E obj);
	public void add(int index, E obj);
	public boolean remove(E obj);
	public boolean remove(int index);
	public int removeAll(E obj);
	public E get(int index);
	public E set(int index, E obj);
	public E first();
	public E last();
	public int firstIndex(E obj);
	public int lastIndex(E obj);
	public int size();
	public boolean isEmpty();
	public boolean contains(E obj);
	public void clear();
	
	static int totalCount(String s, List<String>[] lists) {
		int Fcount = 0; 
		for (int i = 0; i < lists.length; i++) {
			List<String> List2count = lists[i];
			for (int j = 0; j < List2count.size(); j++) {
				if(List2count.contains(s)) {
					++Fcount;
				}
				
			}
		}
		return Fcount;
	}
	
	public int replaceAll(E e, E f);
	public List<E> reverse();
}