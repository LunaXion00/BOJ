import sys

input = sys.stdin.readline

N, M, x, y, K = map(int, input().split())
board = []
dice = [0] * 7
for _ in range(N):
	board.append(list(map(int, input().split())))

command = list(map(int, input().split()))

for direction in command:
  # 1:동쪽, 2: 서쪽, 3: 북쪽, 4: 남쪽
  # 문제 적힌 전개도 기준으로 주사위 이동. 1이 위, 6이 바닥이 되게.
	if direction == 1:
		if y + 1 >= M:
			continue
		dice[6], dice[4], dice[1], dice[3] = dice[4], dice[1], dice[3], dice[6]
		y += 1

	elif direction == 2:
		if y - 1 < 0:
			continue
		dice[1], dice[3], dice[6], dice[4] = dice[4], dice[1], dice[3], dice[6]
		y -= 1

	elif direction == 3:
		if x - 1 < 0:
			continue
		dice[1], dice[5], dice[6], dice[2] = dice[2], dice[1], dice[5], dice[6]
		x -= 1

	else:
		if x + 1 >= N:
			continue
		dice[6], dice[2], dice[1], dice[5] = dice[2], dice[1], dice[5], dice[6]
		x += 1
  # 보드에 수가 적힌 경우, 바닥인 dice[6]은 보드로 대체.
	if board[x][y]:
		dice[6] = board[x][y]
		board[x][y] = 0
  # 보드에 0이 적힌 경우, 바닥인 dice[6]을 기입.
	else:
		board[x][y] = dice[6]
  # 각 이동마다 윗면인 dice[1]의 수를 출력.
	print(dice[1])
