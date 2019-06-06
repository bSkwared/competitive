n, p = map(int, input().split())

cars = sorted(list(map(int, input().split())))
print(max([p*(i+1)-(d-cars[0]) for i, d in enumerate(cars)]))
