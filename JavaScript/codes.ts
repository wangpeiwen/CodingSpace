/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums: number[]) {
    let prev: number[][] = [];
    prev.push([nums[0]]);
    for(let i=1;i<nums.length;i++){
        for(let j=prev.length - 1;j>=0;j--){
            if(nums[i] > prev[j][prev[j].length-1]){
                prev.push([...prev[j], nums[i]]);
                break;
            } else if(j === 0){
                if(nums[i] < prev[0][0]){
                    prev[0] = [nums[i]];
                }
            }
        }
    }
    return Math.max(...prev.map(arr => arr.length), 1);
};