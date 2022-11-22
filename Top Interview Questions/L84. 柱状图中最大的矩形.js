/**
 * @param {number[]} heights
 * @return {number}
 */
 var largestRectangleArea = function (heights) {
    let stack = [], max = 0
    heights.push(0)
    heights.unshift(0)
    stack.push([0, heights[0]])
    for (let i = 1; i < heights.length; i++) {
        while (stack.length > 1 && heights[i] < stack.at(-1)[1]) {
            let h=stack.pop()[1]
            let res = h * (i - stack.at(-1)[0]-1)
            max = Math.max(max, res)
        }
        stack.push([i, heights[i]])
    }

    return max
};