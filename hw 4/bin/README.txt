STEP 0:

1. 	Pre-Order Traversal: 4, 2, 1, 3, 6, 5, 9, 7

2. 	9, 6 

3. 	3

//-----//

STEP 3:

1.

Don Quixote Runs:
	Use (S)mall or (L)arge dictionary? L
	Enter book file: donquixote.txt
	BST Set build time: 89ms
	AVL Set build time: 128ms
	BST Set search time: 24ms (12.75% of the words are used)
	AVL Set search time: 17ms (12.75% of the words are used)
	
	Use (S)mall or (L)arge dictionary? L
	Enter book file: donquixote.txt
	BST Set build time: 88ms
	AVL Set build time: 124ms
	BST Set search time: 24ms (12.75% of the words are used)
	AVL Set search time: 17ms (12.75% of the words are used)
	
	Use (S)mall or (L)arge dictionary? L
	Enter book file: donquixote.txt
	BST Set build time: 90ms
	AVL Set build time: 130ms
	BST Set search time: 24ms (12.75% of the words are used)
	AVL Set search time: 17ms (12.75% of the words are used)
	
Hamlet Runs:
	Use (S)mall or (L)arge dictionary? L
	Enter book file: hamlet.txt
	BST Set build time: 16ms
	AVL Set build time: 19ms
	BST Set search time: 18ms (4.10% of the words are used)
	AVL Set search time: 12ms (4.10% of the words are used)
	
	Use (S)mall or (L)arge dictionary? L
	Enter book file: hamlet.txt
	BST Set build time: 15ms
	AVL Set build time: 19ms
	BST Set search time: 17ms (4.10% of the words are used)
	AVL Set search time: 12ms (4.10% of the words are used)
	
	Use (S)mall or (L)arge dictionary? L
	Enter book file: hamlet.txt
	BST Set build time: 15ms
	AVL Set build time: 19ms
	BST Set search time: 17ms (4.10% of the words are used)
	AVL Set search time: 11ms (4.10% of the words are used)
	
Ulysses Runs:
	Use (S)mall or (L)arge dictionary? L
	Enter book file: ulysses.txt
	BST Set build time: 78ms
	AVL Set build time: 102ms
	BST Set search time: 28ms (19.16% of the words are used)
	AVL Set search time: 20ms (19.16% of the words are used)
		
	Use (S)mall or (L)arge dictionary? L
	Enter book file: ulysses.txt
	BST Set build time: 77ms
	AVL Set build time: 101ms
	BST Set search time: 28ms (19.16% of the words are used)
	AVL Set search time: 20ms (19.16% of the words are used)

	Use (S)mall or (L)arge dictionary? L
	Enter book file: ulysses.txt
	BST Set build time: 77ms
	AVL Set build time: 103ms
	BST Set search time: 28ms (19.16% of the words are used)
	AVL Set search time: 20ms (19.16% of the words are used)

War and Peace Runs:
	Use (S)mall or (L)arge dictionary? L
	Enter book file: warandpeace.txt
	BST Set build time: 115ms
	AVL Set build time: 169ms
	BST Set search time: 25ms (14.27% of the words are used)
	AVL Set search time: 18ms (14.27% of the words are used)

	Use (S)mall or (L)arge dictionary? L
	Enter book file: warandpeace.txt
	BST Set build time: 115ms
	AVL Set build time: 168ms
	BST Set search time: 24ms (14.27% of the words are used)
	AVL Set search time: 17ms (14.27% of the words are used)

	Use (S)mall or (L)arge dictionary? L
	Enter book file: warandpeace.txt
	BST Set build time: 116ms
	AVL Set build time: 172ms
	BST Set search time: 24ms (14.27% of the words are used)
	AVL Set search time: 17ms (14.27% of the words are used)

2. 	Joyce seems to use the largest vocabulary of the other authors, with 19.16% of words used
	in the book Ulysses.

3.	My isBalanced method uses recursive calls to go through the tree and determine balance as
	necssary. Given this method, my code should run in approximately O(N) time because it must
	access each node a single time to determine it's height and compute the height factor (a 
	constant function for each node).

4. 	The AVLStreeSet implementation takes longer to build because each add operation needs to 
	rebalance the tree, whereas the TrackingTree simply adds nodes and does no balancing.

5.	The TrackingStreeSet implementation takes longer to search. This is because, unlike the 
	AVLStreeSet, the tree is not guaranteed to be balanced and is more complex to be searched 
	than the balanced AVLStreeSet.
