
package assignment3_f20;

public class HashMap_imp implements HashMap { 
  HMCell[] tab;
  int nelts;
  
  //-------------------------------------------------------------

  HashMap_imp (int num) { 
    this.tab = new HMCell[num];
    // for (int i=0; i<num; i++) { tab[i] = null; }
    // we can rely on the Java compiler to fill the table array with nulls
    // another way would be Array.fill()
    this.nelts = 0; 
  }

  //-------------------------------------------------------------
  
  public int hash (String key, int tabSize) {
    int hval = 7;
    for (int i=0; i<key.length(); i++) {
      hval = (hval*31) + key.charAt(i);
    }
    hval = hval % tabSize;
    if (hval<0) { hval += tabSize; }
    return hval;
  }
  
  //-------------------------------------------------------------

  // dont change 
  @Override
  public HMCell[] getTable() { return this.tab; }
  //-------------------------------------------------------------

  
  //-------------------------------------------------------------
  // here down... you fill in the implementations for
  // the other interface methods
  //-------------------------------------------------------------
  
  
@Override
public Value put(String k, Value v) {
	int index = hash(k, getTable().length);
	// if key is there
	if (hasKey(k)) {
		HMCell current = tab[index];
		while (current != null) {
			if(current.getKey().compareTo(k) == 0) {
				Value old = current.getValue();
				current.setValue(v);
				return old;
			}
			current = current.getNext();
		}
		// key isnt there
	} else {
		nelts++;
		// extend?
		if (lambda() >= 1) {
			HMCell cell = new HMCell_imp(k,v);
			if (tab[index] == null) {
				tab[index] = cell;
				extend();
				return null;
			} else {
				cell.setNext(tab[index]);
				tab[index] = cell;
				extend();
				return null;
			}
		} else { // no extend
			HMCell cell = new HMCell_imp(k,v);
			if (tab[index] == null) {
				tab[index] = cell;
				return null;
			} else {
				cell.setNext(tab[index]);
				tab[index] = cell;
				return null;
			}
		}
	}
	return null;
}

@Override
public Value get(String k) {
	int index = hash(k,tab.length);
	HMCell current = tab[index];
	while (current != null) {
		if (current.getKey() == k) {
			return current.getValue();
		}
		current = current.getNext();
		
	}
	return null;
}

@Override
public void remove(String k) {
	int index = hash(k,tab.length);
	HMCell current = tab[index]; 
	while (current != null) {
		if (current.getKey()== k) {
			current.setKey(null);
			current.setValue(null);
			nelts--;
		}
		current = current.getNext();
	}
}

@Override
public boolean hasKey(String k) {
	if (get(k) != null) {
		return true;
	}
	return false;
}

@Override
public int size() { 
	int size = 0;
	for (int i=0; i<getTable().length; i++) {
		HMCell current = tab[i];
		while (current != null) {
			size++;
			current = current.getNext();
		}
	}
	return size;
}

@Override
public String maxKey() {
	if (this.size() == 0) {
		return null;
	}
	String max = null;
	for (int i=0; i<tab.length; i++) {
		if (tab[i] == null) {
			i++;
		} else {
			HMCell current = tab[i];
			if (max == null) {
				max = current.getKey();
			}
			while (current != null) {
				if (current.getKey().compareTo(max) > 0) {
					max = current.getKey();
				}
				current = current.getNext();
			}
		}
	}
	return max;
}

@Override
public String minKey() {
	if (this.size() == 0) {
		return null;
	}
	String min = null;
	for (int i=0; i<tab.length; i++) {
		if (tab[i] == null) {
			i++;
		} else {
			HMCell current = tab[i];
			if (min == null) {
				min = current.getKey();
			}
			while (current != null) {
				if (current.getKey().compareTo(min) < 0) {
					min = current.getKey();
				}
				current = current.getNext();
			}
		}
	}
	return min;
}

@Override
public String[] getKeys() {
	if (tab == null) {
		return new String[0];
	}
	String [] arr = new String[nelts];
	for (int i=0; i<tab.length; i++) {
		HMCell current = tab[i];
		if (current!= null) {
			arr[i] = current.getKey();
			current = current.getNext();
		}
	}
	return arr;
}

@Override
public double lambda() {
	return (double)nelts / getTable().length;
}

@Override
public double extend() {
	HMCell[] old = tab;
	int s = getTable().length*2;
	tab = new HMCell[s];
	nelts = 0;

	for (int i=0; i< old.length; i++) {
		HMCell current = old[i];
		while (current != null) {
			put(current.getKey(), current.getValue());
			current = current.getNext();
		}
	}
	return lambda();
}
}










