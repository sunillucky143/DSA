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


int prop_search(int arr[], int size_ar, int target){
  int j = size_ar-1;
  for(int i = 0; i < size_ar; i++){
    if(arr[i] == target){
      return i;
    }
    if(arr[j] == target){
      return j;
    }
    if(i == j){
      break;
    }
    j--;
  }
  return -1;
}
