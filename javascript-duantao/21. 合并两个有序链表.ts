// 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 


//   Definition for singly-linked list.
class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}


function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
    const head = { next: null }
    let main = head
    while (list1 && list2) {
        if (list1.val < list2.val) {
            main.next = list1
            list1 = list1.next
        } else {
            main.next = list2
            list2 = list2.next
        }
        main = main.next
    }
    if (list1) main.next = list1
    if (list2) main.next = list2
    return head.next
};