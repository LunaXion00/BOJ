import sys
from collections import deque

input = sys.stdin.readline
# 0 : 위로 1: 왼쪽 2: 아래 3: 오른쪽
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

snake = deque()
# 초기 위치 지정
snake.append((1, 1))
apple = []

N = int(input())
K = int(input())

for _ in range(K):
	apple.append(list(map(int, input().split())))

direction = 3
cnt = 0
flag = False
L = int(input())

for _ in range(L):
	X, C = input().split()
	while cnt < int(X):
		head_x, head_y = snake[-1][0], snake[-1][1]
		nx, ny = head_x + dx[direction], head_y + dy[direction]
		cnt += 1
		if nx < 1 or ny < 1 or nx > N or ny > N:
			flag = True
			break
		if (nx, ny) in snake:
			flag = True
			break
		if [nx, ny] in apple:
			apple.remove([nx, ny])
			snake.append((nx, ny))
		else:
			snake.popleft()
			snake.append((nx, ny))
	if flag:
		break
	if C == 'L':
		direction = (direction + 1) % 4
	elif C == 'D':
		direction = (direction - 1) % 4

if not flag:
	while 1:
		head_x, head_y = snake[-1][0], snake[-1][1]
		nx, ny = head_x + dx[direction], head_y + dy[direction]
		cnt += 1
		if nx < 1 or ny < 1 or nx > N or ny > N:
			flag = True
			break
		if (nx, ny) in snake:
			flag = True
			break
		if [nx, ny] in apple:
			apple.remove([nx, ny])
			snake.append((nx, ny))
		else:
			snake.popleft()
			snake.append((nx, ny))

print(cnt)
