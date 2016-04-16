令sum[i]表示以第i个元素结尾的最大连续子数组和，maxSum表示最大连续子数组的和
递推公式
sum[i] = max(sum[i-1]+array[i],array[i])
maxSum = max(maxSum,sum[i])

进一步地约减，我们发现没有必要用数组sum来保存每一个元素结尾的子数组的和，我们只需要上一个元素为结尾的元素和即可
将数组sum变为变量sum

递推公式
sum = max(sum+array[i],array[i])
maxSum = max(maxSum,sum)
