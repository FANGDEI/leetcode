/**
 * @param {string[]} tokens
 * @return {number}
 */
 var evalRPN = function (tokens) {
    let nums = []
    for (let i = 0; i < tokens.length; i++) {
        if (parseInt(tokens[i]) <= 200 && parseInt(tokens[i]) >= -200) {
            // console.log(parseInt(tokens[i]))
            nums.push(parseInt(tokens[i]))
        } else {

            if (tokens[i] == '+') {
                nums.push(nums.pop() + nums.pop())
            }
            else if (tokens[i] == '-') {
                nums.push(-nums.pop() + nums.pop())
            }
            else if (tokens[i] == '*') {
                nums.push(nums.pop() * nums.pop())
            }
            else {
                let a = nums.pop(), b = nums.pop()
                if (a * b > 0) {
                    nums.push(Math.floor(b / a))
                } else {
                    nums.push(Math.ceil(b / a))
                }
            }
        }
    }
    return nums[0]
};