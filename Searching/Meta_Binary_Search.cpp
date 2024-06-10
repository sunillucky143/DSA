// Meta binary search
// An improvised version of binary search.
/* Meta binary search works similar to binary search
but it makes fewer comparisions compared to binary search
which result in execution speed
Time Complexity = O(log N)
Space Complexity = Auxiliary space = O(1)
*/

#include <bits/stdc++.h>
using namespace std;

int meta_binary_search(int arr[], int size_ar, int target){
  int lg = log2(size_ar - 1)+1;
  int pos = 0;
  for(int i = lg; i >= 0; i--){
    if(arr[pos] == target){
      return pos;
    }
    int new_pos = pos | (1 << i);
    if(new_pos < n && arr[new_pos] <= target){
      pos = new_pos;
    }
  }
  return -1;
}
    
