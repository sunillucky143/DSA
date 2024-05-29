/* Selection Sort */
/* selecting an least element from the array and swaping it with first element
of unsorted array and moving indecies forward

=>      [4, 3, 1, 5, 7]
    
    selecting least element of 1 from the given array and swaping with unsorted first element 4.

=>      [1, 3, 4, 5, 7]

    repeating thbe process

=> Selection sort takes O(n2) approach.

*/

#include <iostream>

int* selection_sort(int arr[], int n){
    for(int i = 0; i < n; i++){
        for(int j = i+1; j < n; j++){
            if(arr[j] < arr[i]){
                int temp = arr[j]; //swaping
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }
    return arr;
}

int main(){
    int arr[] = {4, 2, 5, 1, 3, 4};
    int n = sizeof(arr)/sizeof(int);
    int* sorted_arr = selection_sort(arr, n);
    for(int i = 0; i < n; i++){
        std::cout << sorted_arr[i] << " ";
    }
    return 0;
}