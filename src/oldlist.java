import java.util.Collection;
import java.util.Iterator;

/**
 * List Class makes one list of the Media Objects. Implements the Collection Interface which
 * specifies add and remove object methods.
 * Author DG
 */

public class oldlist implements Collection{
   
	public Media list;
	/**
	 * Default Constructor for List Class
	 * Author DG
	 */
	public oldlist() {
		
	}

	/**
	 *  Search Method to search for title and/or type inherited from Collections class
	 *  Author DG
	 */
	public void binarySearch(oldlist searchText) {
		
	}

	/**
	 *  Method stubs to implement Collection interface.  Includes add and remove methods.
	 *  Author DG
	 */
	@Override
	public int size() {
	
		return 0;
	}

	@Override
	public boolean isEmpty() {
	
		return false;
	}

	@Override
	public boolean contains(Object o) {
		
		return false;
	}

	@Override
	public Iterator iterator() {
		
		return null;
	}

	@Override
	public Object[] toArray() {
		
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		
		return null;
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
	
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
	
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
	
		return false;
	}

	@Override
	public void clear() {
		
	}
}
