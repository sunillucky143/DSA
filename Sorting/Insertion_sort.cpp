//  Insertion sort
/*
    => unsorted array = {5, 2, 4, 6, 1, 7}
   
   iterate around two elements until it gets to its exact position.

   => [2, 5, 4, 6, 1, 7]
   => [2, 4, 5, 6, 1, 7]
*/
#include <iostream>

int* Insertion_sort(int arr[], int n){
    for(int i =0; i <= n-1; i++){
        int j = i;
        while(j > 0 && arr[j-1] > arr[j]){
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
            j--;
        }
    }
    return arr;
}

int main(){
    int arr[] = {4, 2, 1, 5, 8, 6};
    int n = sizeof(arr)/sizeof(int);
    int* sarr = Insertion_sort(arr, n);
    for(int i =0; i < n; i++){
        std::cout << sarr[i] << " ";
    }
    return 0;
}