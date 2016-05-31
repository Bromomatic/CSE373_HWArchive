1.

a) - [941, 81] - [3, 53] - - [96, 66] 287 - -

b) - 81 941 53 3 - 66 287 96 -

c) 96 81 941 53 3 - 66 287 - -

d) 3 81 - 53 - 941 66 287 96 -

// ---------- //

2. 	Separate Chaining - Fast, simple to implement, unlimited table size (based on memory of course)
	, but slow to retrieve values from because of the linked lists and pointers, uneven 
	distribution of values, and lots of empty spaces in the table possibly.

	Linear Probing - Fast and simple, and all values are in the table itself instead of linked lists
	so searches will be faster, but the linear method of placement leads to clumps of values. Too 
	many markers from deletion causes decrease in performance as well. Also, table has to be resized
	after the table is filled.

	Quadratic Probing - Reduces primary clustering by placing elements much farther away, no real 
	noticable performance difference because of the quadratic nature vs linear. Drawback is that,
	for certain table sizes (say 8) we check buckets multiple times as we search for the element. 
	There is also no guarantee that we will go over every element in the table, which can be problematic.

	Double Hashing - Computationally more expensive than other methods because of the extra function, 
	but further reduces clustering. Uses prime numbers so its effective. 

// ---------- //

3.

Hash 1:

public int hashCode() {
	int result = 17;
	result = 37 * result + this.digits.hashCode();
	result = 37 * result + (this.isNegated ? 0 : 1);

	return result;
}

----------

Hash 2:

public int hashCode() {
	int result = 17;
	result = 37 * result + this.int;
	result = 37 * result + this.quarter;
	result = 37 * result + this.prjNum;
	result = 37 * result + this.student1.hashCode();
	result = 37 * result + this.student2.hashCode();
	
	return result;
}