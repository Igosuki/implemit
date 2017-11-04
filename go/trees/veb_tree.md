
### vEB Trees  

insert delete lookup min max previous next space 

#### Bit Vector
insert |delete   |lookup   |min   |max   |previous   | next  | space  |
---|---|---|---|---|---|---|---|
| O(1)  | O(1)  | O(1)  | O(n)  | O(n)  | O(n)  | O(n)  | O(n)  |

- One level of n values
- Each value is a bit for whether or not the value exists

#### M tiered bit vector (m = sqrt(n))

insert |delete   |lookup   |min   |max   |previous   | next  | space  |
---|---|---|---|---|---|---|---|
| O(1)  | O(1)  | O(1)  | O(n/m + m)  | O(n/m + m)  | O(n/m + m)  | O(n/m + m)  | O(n/m + m)  |

- First level is an array of m values. 
- Insert, delete, lookup : look up the x/m th block, the value will then be at x mod m of the sub array in this block. 
- max and min called recursively in the same way 
- next starts at the x/m th block, the recursively iterates
- previous starts at most at the x/m th block, recursively backtracks

#### N level M tiered bit vectors : Van Emde Boas tree

- Master theorem : T(n) ≤ aT(n / b) + O(nd) 
- Search complexity : with S(k) = T(2k), S(k) = O(log k) then  T(U) = T(2lg U) = S(lg U) = O(log log U)

Each space problem is sqrt smaller than the previous, giving O(n) complexity to search operations.

The structure is : 
- given log m = k, an array of M = 2^m, sqrt(M) trees of sqrt(sqrt(M)) values etc. 
- n array of 2^m/2 summary values
- max and min

Summarizing : 
- Pros : log log u search complexity
- Cons : size N storage if using arrays

Solving the space problem : 
- Use cuckoo hashtables instead of arrays 

The con of this method, is expensive cpu calculations because of the hashing.







 
  


