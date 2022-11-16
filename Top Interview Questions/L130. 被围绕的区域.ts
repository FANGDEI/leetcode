/**
 Do not return anything, modify board in-place instead.
 */
function solve(board: string[][]): void {
    let x = board.length
    let y = board[0].length
    for (let i = 0; i < x; i++) {
        if (board[i][0] == 'O') {
            dfs(board, i, 0)
        }
    }
    for(let i=0;i<x;i++){
        if(board[i][y-1]=='O'){
            dfs(board,i,y-1)
        }
    }
    for(let i=0;i<y;i++){
        if(board[0][i]=='O'){
            dfs(board,0,i)
        }
    }
    for(let i=0;i<y;i++){
        if(board[x-1][i]=='O'){
            dfs(board,x-1,i)
        }
    }

    for(let i=0;i<x;i++){
        for(let j=0;j<y;j++){
            if(board[i][j]=='-'){
                board[i][j]='O'
            }else{
                board[i][j]='X'
            }
        }
    }

    function dfs(board: string[][], x: number, y: number) {
        board[x][y] = '-'
        if (x - 1 > 0 && board[x - 1][y] == 'O') {
            // board[x - 1][y] = '-'
            dfs(board, x - 1, y)
        }
        if (x + 1 < board.length && board[x + 1][y] == 'O') {
            // board[x + 1][y] = '-'
            dfs(board, x + 1, y)
        }
        if (y - 1 > 0 && board[x][y - 1] == 'O') {
            // board[x][y - 1] == '-'
            dfs(board, x, y - 1)
        }
        if (y + 1 < board[0].length && board[x][y + 1] == 'O') {
            // board[x][y + 1] == '-'
            dfs(board, x, y + 1)
        }
    }
};

