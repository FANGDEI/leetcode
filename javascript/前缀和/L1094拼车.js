/**
 * @param {number[][]} trips
 * @param {number} capacity
 * @return {boolean}
 */
var carPooling = function(trips, capacity) {
    let  hash = new Array(1001);
    hash.fill(0)
    for (let  i = 0; i < trips.length; i++) {
        let  p = trips[i][0], f = trips[i][1], to = trips[i][2];
        hash[f] += p;
        hash[to] -= p;
    }
    let  num = 0;
    for (let  i = 0; i < hash.length; i++) {
        num += hash[i];
        if (num > capacity) {
            return false;
        }
    }
    return true;

};