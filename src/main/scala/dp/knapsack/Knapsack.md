**Knapsack**

**Identification** 
1. A bag/knapsack of size W
2. List of elements to pick and add in knapsack
3. Choice - for each element whether to include/exclude

Solutions
1. Initialization of dp matrix
2. RecursionTree

arr = [3,5,6,8]

// when any element i.e. 3/5 is less than j then only go ahead


if (arr(i - 1) <= j) {

dp(i)(j) = dp(i - 1)(j - arr(i - 1)) || dp(i - 1)(j)

// as we have checked arr[i-1] is > j hence j-arr[i-1] will always be positive

} else {

dp(i)(j) = dp(i - 1)(j)

}



    // stores the result of Knapsack 
    int res = K[n][W];     
    printf("%d\n", res); 
      
    w = W; 
    for (i = n; i > 0 && res > 0; i--) { 
          
        // either the result comes from the top 
        // (K[i-1][w]) or from (val[i-1] + K[i-1] 
        // [w-wt[i-1]]) as in Knapsack table. If 
        // it comes from the latter one/ it means  
        // the item is included. 
        if (res == K[i - 1][w])  
            continue;         
        else { 
  
            // This item is included. 
            printf("%d ", wt[i - 1]); 
              
            // Since this weight is included its  
            // value is deducted 
            res = res - val[i - 1]; 
            w = w - wt[i - 1]; 
        } 
    } 
} 