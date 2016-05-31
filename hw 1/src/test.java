
public class test {
	public static void main(String[] args) {
		DoubleStack stack = new LinkedStack();
		DoubleStack stack2 = new ArrayStack();
		
		stack.push(1.12121212);
		stack.push(2.34343434);
		stack.push(3.56565656);
		stack.push(3.141598734534);
		stack.pop();
		
		
		stack2.push(1.12121212);
		stack2.push(2.34343434);
		stack2.push(3.56565656);
		stack2.push(3.141598734534);
		stack2.pop();
		stack2.push(3.141598734534);
		stack2.push(5.7574235);
		stack2.push(6.384573485);
		stack2.push(8.62374523482);
		stack2.push(1.141598734534);
		stack2.push(9.3423);
		stack2.push(5.2448);
		stack2.push(45.2934235);
		stack2.push(12.385);
		
		double a = stack2.peek();
		double a2 = stack2.pop();
		double a3 = stack.peek();
		
		System.out.println(a);
		System.out.println(a2);
		System.out.println(a3);
		
		System.out.println(stack.toString());
		if (stack2.isEmpty()) {
			System.out.println("Stack is empty");
		} else {
			System.out.println(stack2.toString());
		}
		
		stack2.clear();
		System.out.println(stack2.toString());
		
		
		
//		//stack2.push(5.2374834);
//		System.out.println(stack2.toString());
//		
//		//stack2.push(1.23623);
//		System.out.println(stack2.toString());
//		
//		stack2.clear();
//		System.out.println(stack2.toString());
//		
//		stack.clear();
//		System.out.println(stack.toString());
//		
//		stack2.push(1.12121212);
//		stack2.push(2.34343434);
//		
//		System.out.println(stack.toString());
//		System.out.println(stack2.toString());
	}
}
