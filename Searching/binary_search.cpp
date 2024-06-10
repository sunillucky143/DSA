// Binary Search
/*This algorithm is used to find the position of target value within a sorted array.

It uses to reduce the time complexity to O(log N)
*/

//Assume the array is sorted or input only the sorted array.

#include <bits/stdc++.h>
using namespace std;

int binary_search(int arr[], int l, int h, int target){
  while(low <= high){
    int mid = low + (high - low)/2;
    // check if arr[mid] equals to target
    if(arr[mid] == target){
      return mid;
    }
    if(arr[mid] < traget){
      low = mid+1;
    }
    if(arr[mid] > target){
      low = mid-1;
    }
  }
  return -1;
}
    
