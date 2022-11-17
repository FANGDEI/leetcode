class Solution {
    nums:number[]
    res:number[][]=[]
    constructor(nums: number[]) {
        this.nums=nums
        this.res.push(nums)
        for(let i=0;i<nums.length-1;i++){
            for(let j=i+1;j<nums.length;j++){
                let ans:number[]=[]
                for(let p of nums){
                    ans.push(p)
                }
                let x=nums[i]
                let y=nums[j]
                ans[i]=y
                ans[j]=x
                this.res.push(ans)
            }
        }
        console.log(this.res)
    }

    reset(): number[] {
        return this.nums
    }

    shuffle(): number[] {
        return this.res[Math.floor(Math.random()*this.res.length)]
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */


/**
 * @param {number[]} nums
 */
//  var Solution = function(nums) {
//     this.nums = nums;
// };

// /**
//  * @return {number[]}
//  */
// Solution.prototype.reset = function() {
//     return this.nums;
// };

// /**
//  * @return {number[]}
//  */
// Solution.prototype.shuffle = function() {
//     const temp = this.nums.concat();
//     for(let i=0;i<temp.length;i++){
//         const idx = Math.floor(Math.random() * (temp.length-i)) + i;
//         const tmp = temp[idx];
//         temp[idx] = temp[i];
//         temp[i] = tmp;
//     }
//     return temp;
// };

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */
