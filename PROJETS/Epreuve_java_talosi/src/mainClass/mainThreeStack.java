package mainClass;

import talosi.ThreeStack;

public class mainThreeStack {

	public static void main(String[] args) throws Exception {
		
		
		var threeStack = new ThreeStack();

		threeStack.push(1, "object1");
		threeStack.push(1, "object2");
		threeStack.push(2, "object3");
		threeStack.push(2, "object4");
		threeStack.push(2, "object5");
		threeStack.push(3, "object6");
		threeStack.push(3, "object7");

		System.out.println();
		System.out.println(threeStack.pop(2)); // display {name:"object5"}
		System.out.println(threeStack.pop(2)); // display {name:"object4"}
		System.out.println(threeStack.pop(1)); // display {name:"object2"}
		System.out.println(threeStack.pop(1)); // display {name:"object1"}
		System.out.println(threeStack.pop(3)); // display {name:"object7"}
		//System.out.println(threeStack.pop(1)); // throw Exception
		//System.out.println(threeStack.pop(4)); // throw Exception
		

	}

}
