import sys
import copy
from collections import deque

N, M = map(int, input().split())

original = []
ans = 0
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(N):
	original.append(list(map(int, input().split())))

# 모든 위치에 대해서 벽을 세우려니 시간 초과가 생김. 그래서 처음 상태에서 벽이 들어갈 수 있는 공간을 파악해서 해당 공간에서만 벽을 세울 거임.
empty_room = []
for i in range(N):
	for j in range(M):
		if original[i][j] == 0:
			empty_room.append((i, j))


# 바이러스 확산, 안전지대 카운팅
def bfs():
	virus = deque()
	board = copy.deepcopy(original)
	global ans
	for i in range(N):
		for j in range(M):
			if board[i][j] == 2:
				virus.append((i, j))
	while virus:
		x, y = virus.popleft()
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if nx < 0 or nx >= N or ny < 0 or ny >= M:
				continue
			if board[nx][ny] == 0:
				board[nx][ny] = 2
				virus.append((nx, ny))
	safe = 0
	for i in range(N):
		safe += board[i].count(0)
	if safe > ans:
		ans = safe
	return


# 벽 3개 세우기.
for i in range(len(empty_room)):
	for j in range(i + 1, len(empty_room)):
		for k in range(j + 1, len(empty_room)):
			a, b = empty_room[i]
			c, d = empty_room[j]
			e, f = empty_room[k]
			original[a][b] = 1
			original[c][d] = 1
			original[e][f] = 1
			bfs()
			original[a][b] = 0
			original[c][d] = 0
			original[e][f] = 0
print(ans)
