//          Bubble Sort
/* name itself indicate that this technique gona be in the form of swapping bubbles.
    swaping with adjacent elements if the ith element is greater than i+1th element

    looks like

    => [4, 2, 5, 1, 6]
    => [2, 4, 5, 1, 6]
    => [2, 4, 5, 1, 6]
    => [2, 4, 1, 5, 6]
    .....
    => [1, 2, 4, 5, 6]

    it takes the O(n2) approach
*/
#include <iostream>

int* Bubbble_sort(int arr[], int n){
    for(int i = n-1; i >= 0; i--){
        for(int j = 0; j < i-1; j++){
            if(arr[j] > arr[j+1]){
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr;
}

int main(){
    int arr[] = {4, 2, 1, 5, 3};
    int n = sizeof(arr)/sizeof(int);
    int* sorted_array = Bubbble_sort(arr, n);
    for(int i = 0; i < n; i++){
        std::cout << sorted_array[i] << " ";
    }
    return 0;
}