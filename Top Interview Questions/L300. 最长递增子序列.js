// 贪心+二分
var lengthOfLIS = function(nums) {
    var ans = []; 
    for (var i = 0; i < nums.length; i++) {
        var left = 0, right = ans.length;
        while (left < right) { //二分法
            var mid = left + right >>> 1;
            if (ans[mid] < nums[i]) left = mid + 1;
            else right = mid;
        } 
        if (right >= ans.length) ans.push(nums[i]); //如果找不到 在ans最后增加一项nums[i]
        else ans[right] = nums[i];
    }
    return ans.length;
};

