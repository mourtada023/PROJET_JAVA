package talosi;

import exeption.EmptyStackException;
public class ThreeStack {
	
	private String[] array;
	private int[] sizes;
	private int capacity;


	public ThreeStack() {

	    capacity = 30; // par défaut, on alloue 30 emplacements dans le tableau
	    setArray(new String[capacity]);
	    sizes = new int[3];

	}


	public void push(int stackNum, String value) {

	    if (stackNum < 1 || stackNum > 3) {

	        throw new IllegalArgumentException("Invalid stack number: " + stackNum);

	    }

	    if (sizes[stackNum - 1] >= capacity / 3) {

	        // agrandir le tableau si nécessaire

	        resizeArray();

	    }

	    int index = stackNum * (capacity / 3) - sizes[stackNum - 1] - 1;
	    getArray()[index] = value;
	    sizes[stackNum - 1]++;

	}



	public String pop(int stackNum) throws Exception {

	    if (stackNum < 1 || stackNum > 3) {
	        throw new IllegalArgumentException("Invalid stack number: " + stackNum);
	    }

	    if (sizes[stackNum - 1] == 0) {
	        throw new EmptyStackException(" Empty stack exception");
	    }

	    int index = stackNum * (capacity / 3) - sizes[stackNum - 1];
	    String value = getArray()[index];
	    getArray()[index] = null;
	    sizes[stackNum - 1]--;
	    return value;

	}



	private void resizeArray() {
	    String[] newArray = new String[capacity * 2];
	    System.arraycopy(getArray(), 0, newArray, 0, capacity);
	    setArray(newArray);
	    capacity *= 2;

	}


	public String[] getArray() {
		return this.array;
	}


	public void setArray(String[] array) {
		this.array = array;
	}

}
