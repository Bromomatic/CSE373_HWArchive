-I used the sizes 0, 10, 100, 1000, and 10000 to compare the runtimes for several different 
orders of magnitude.

---------------------------------------------------------

-Here are some sample outputs from my test program:

RUN 1 
---
for n = 0, time = 90.5ns - DualSelectionSort
for n = 0, time = 120.7ns - SelectionSort

for n = 10, time = 1630.3ns - DualSelectionSort
for n = 10, time = 1298.2ns - SelectionSort

for n = 100, time = 60473.3ns - DualSelectionSort
for n = 100, time = 67658.8ns - SelectionSort

for n = 1000, time = 1007304.1ns - DualSelectionSort
for n = 1000, time = 1020860.1ns - SelectionSort

for n = 10000, time = 5.43796628E7ns - DualSelectionSort
for n = 10000, time = 1.031213024E8ns - SelectionSort

RUN 2
---
for n = 0, time = 211.3ns - DualSelectionSort
for n = 0, time = 120.7ns - SelectionSort

for n = 10, time = 1600.1ns - DualSelectionSort
for n = 10, time = 1268.0ns - SelectionSort

for n = 100, time = 61197.9ns - DualSelectionSort
for n = 100, time = 67447.4ns - SelectionSort

for n = 1000, time = 1000360.2ns - DualSelectionSort
for n = 1000, time = 1021494.0ns - SelectionSort

for n = 10000, time = 5.43909544E7ns - DualSelectionSort
for n = 10000, time = 1.03115989E8ns - SelectionSort

RUN 3
---
for n = 0, time = 150.9ns - DualSelectionSort
for n = 0, time = 151.0ns - SelectionSort

for n = 10, time = 1600.2ns - DualSelectionSort
for n = 10, time = 1358.6ns - SelectionSort

for n = 100, time = 67296.5ns - DualSelectionSort
for n = 100, time = 77833.2ns - SelectionSort

for n = 1000, time = 1019562.0ns - DualSelectionSort
for n = 1000, time = 1042084.6ns - SelectionSort

for n = 10000, time = 5.44036046E7ns - DualSelectionSort
for n = 10000, time = 1.031853383E8ns - SelectionSort

---------------------------------------------------------

dualSelectionSort begins to outperform SelectionSort after the array grows larger
than size 100, and continues to perform better for larger values.

For example, for n = 10 dualSelectionSort is roughly 300ns SLOWER than selectionSort, 
but for n = 1000, dualSelectionSort is about 10,000ns FASTER.

---------------------------------------------------------

While dual selection sort does operate a bit faster than selection sort, it still 
seems to have the same growth rate, even for larger values like 25000 elements and 
beyond (for 25000, both sorts take roughly 10^8 ns to complete, and at 50000 they take
roughly 10^9 ns). Since the order of magnitude is the same for both, it appears they share
the same growth rate and the same Big-Oh (approximately).