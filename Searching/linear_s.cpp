//Linear Search

/*
  Time Complexity: O(N)
  Space COmplexity: O(1)
*/

#include <bits/stdc++.h>
using namespace std;

int search(int arr[], int size_ar,int target){
  for(int i = 0; i < size_ar; i++){
    if(arr[i] == target){
      return target;
    }
  }
  return -1;
}
