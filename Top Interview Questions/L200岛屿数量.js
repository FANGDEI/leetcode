/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    let res=[]
    let ans=0
    for(let i=0;i<grid.length;i++){
        res.push(new Array(grid[0].length).fill(0))
    }
    for(let i=0;i<grid.length;i++){
        for(let j=0;j<grid[0].length;j++){
            if(res[i][j]==0&&grid[i][j]=='1'){
                ans++;
                infect(grid,res,i,j)
            }

        }
    }

    return ans
};

function infect(grid,res,i,j){
    if(res[i][j]==1) return
    res[i][j]=1
    if(i>0&&grid[i-1][j]==1){
        infect(grid,res,i-1,j)
    }
    if(i<grid.length-1&&grid[i+1][j]==1){
        infect(grid,res,i+1,j)
    }
    if(j>0&&grid[i][j-1]==1){
        infect(grid,res,i,j-1)
    }
    if(j<grid.length-1&&grid[i][j+1]==1){
        infect(grid,res,i,j+1)
    }

}