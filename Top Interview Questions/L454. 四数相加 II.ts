function fourSumCount(nums1: number[], nums2: number[], nums3: number[], nums4: number[]): number {
    let n=nums1.length
    let res=0
    let map=new Map()
    for(let i=0;i<n;i++){
        for(let j=0;j<n;j++){
            let sum=nums1[i]+nums2[j]
            if(map.has(sum)){
                map.set(sum,map.get(sum)+1)
            }else{
                map.set(sum,1)
            }
        }
    }
    for(let i=0;i<n;i++){
        for(let j=0;j<n;j++){
            let sum=-(nums3[i]+nums4[j])
            if(map.has(sum)){
                res+=map.get(sum)
            }
        }
    }
    return res
};