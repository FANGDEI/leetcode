/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
 var mergeKLists = function (lists) {
    let lists2=[]
    for (let i = 0; i < lists.length; i++) {
        let node = lists[i]
        while (node != null) {
            lists2.push(node)
            node=node.next
        }
    }
    if(lists2.length==0){
        return null
    }
    lists2.sort((a, b) => a.val - b.val)
    let length=lists2.length
    let node = lists2.shift()
    let res = node
    let fl=1
    while (fl<length) {
        fl++
        let p = lists2.shift()
        node.next = p
        node = p
    }
    
    return res
};