/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
let q=0
var canCompleteCircuit = function(gas, cost) {
    q=0
    for(let i=0;i<gas.length;i++){
        if(process(i,i,0,gas,cost,0)===true){
            return i
        }else{
            // console.log(i,q)
            if(i<q)
                i=q
        }
    }
    return -1
};
function process(now,s,noil,gas,cost,p){
    if(now==s&&p!==0){
        return true
    }
    if(noil+gas[now]-cost[now]>=0){
        return process((now+1)%gas.length,s,noil+gas[now]-cost[now],gas,cost,1)
    }else{
        // console.log(now)
        if(now>s){
            q=now
        }
        return false
    }
}