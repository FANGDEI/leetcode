/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var applyOperations = function(nums) {
    let res=[],num=0
    for(let i=0;i<nums.length;i++){
                if(nums[i]===0){
            num++
        }
        if(nums[i]==nums[i+1]){
            nums[i]=2*nums[i]
            nums[i+1]=0
            num++
            i++
        }

        // console.log(nums[i],num)
    }
    for(let i=0;i<nums.length;i++){
        if(nums[i]!==0){
            res.push(nums[i])
        }
    }
    for(let i=0;i<num;i++){
        res.push(0)
    }
    return res

};