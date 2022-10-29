/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function (intervals) {
    intervals.sort((firstItem, secondItem) => firstItem[0] - secondItem[0])
    if (intervals.length === 1) {
        return intervals;
    }
    console.log(intervals)
    let ans = [], t = 0
    ans[0]=intervals[0]
    for (let j = 0; j < intervals.length ; j++) {
        if (!(ans[t][1] < intervals[j ][0] || ans[t][0] > intervals[j][1])) {
            ans[t] = [Math.min(ans[t][0], intervals[j][0]), Math.max(ans[t][1], intervals[j][1])];
        } else {
            t++
            ans[t] = [intervals[j][0],intervals[j][1]]
        }

    }
    return ans;
};
// console.log(merge([[1,4],[2,3]]));
