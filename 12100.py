import sys
import copy

input = sys.stdin.readline

N = int(input())
board = []

for i in range(N):
	board.append(list(map(int, input().split())))

ans = 0

def right(board):
	for i in range(N):
		for j in range(N):
			if board[i][j] == 0:
				continue
			else:
        # 칸에 숫자가 있고, 오른쪽 칸이 빈 칸인 경우 땡김.
				if j + 1 < N and board[i][j + 1] == 0:
					board[i][1:j + 2] = board[i][0:j + 1]
					board[i][0] = 0
    #가장 오른쪽에 있는 애들부터 그 앞에 있는 것과 같으면 합치기. 하고나선 한칸씩 땡기기.
		for j in range(N - 1, 0, -1):
			if board[i][j] == board[i][j - 1]:
				board[i][j] *= 2
				board[i][1:j] = board[i][0:j - 1]
				board[i][0] = 0
	return board


def left(board):
	for i in range(N):
		for j in range(N - 1, -1, -1):
			if board[i][j] == 0:
				continue
			else:
				if j > 0 and board[i][j - 1] == 0:
					board[i][j - 1:N - 1] = board[i][j:N]
					board[i][N - 1] = 0
		for j in range(N - 1):
			if board[i][j] == board[i][j + 1]:
				board[i][j] *= 2
				board[i][j + 1:N - 1] = board[i][j + 2:N]
				board[i][N - 1] = 0
	return board


def down(board):
  # 내리는 건 보드를 대칭시키고 오른쪽으로 옮김. 이후 다시 대칭.
	rotate = list(map(list, zip(*board)))
	rotate = right(rotate)
	board = list(map(list, zip(*rotate)))
	return board


def up(board):
  # 마찬가지, 보드를 대칭시키고 왼쪽으로 옮김. 이후 다시 대칭.
	rotate = list(map(list, zip(*board)))
	rotate = left(rotate)
	board = list(map(list, zip(*rotate)))
	return board


def dfs(count, board):
	if count == 5:
		global ans
		ans = max(ans, max(map(max, board)))
		return
  #하...deepcopy 빼먹어서 시간 다잡아먹음.
	dfs(count + 1, left(copy.deepcopy(board)))
	dfs(count + 1, right(copy.deepcopy(board)))
	dfs(count + 1, up(copy.deepcopy(board)))
	dfs(count + 1, down(copy.deepcopy(board)))


dfs(0, board)

print(ans)
