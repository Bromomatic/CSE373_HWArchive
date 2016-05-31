1. I chose the sizes 10, 100, 1000, 10000, 100000, and 1000000 to test a variety of sizes with 
increasing orders of magnitude. If the runtime is O(logN) then the runtime between sizes with 
much higer magnitudes shouldn't increase drastically, as if it were an O(N) algorithm.

---

2. Example runtimes:

for n = 10, time = 362.2ns

for n = 100, time = 271.8ns

for n = 1000, time = 573.8ns

for n = 10000, time = 724.6ns

for n = 100000, time = 935.9ns

for n = 1000000, time = 1177.4ns

---

3. Runtimes are about as expected, with some oddness in that the array of size 100 typically runs 
faster than the array of size 10 (this pattern exists for multiple runthroughs of the test, not 
just this example). Since the runtime is supposed to run about O(logN), this function actually 
seems to be performing better than expected. Even though, for example, 100,000 is 10 times larger
than 10,000, the runtime is not even doubled between the two. The increase in time between 
successively larger tests is slightly smaller, which seems to indicate to me that the runtime is 
growing at about the rate of log N as desired.