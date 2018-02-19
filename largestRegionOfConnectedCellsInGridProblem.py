def getBiggestRegion(grid):
    biggestRegion = 0
    occupiedCells = {}
    regions = {}
    cellsInSomeRegion = {}
    for i in range(n):
        for j in range(m):
            cell =  str(j) + str(i)
            if grid[i][j] == 1:
                occupiedCells[cell] = 1
    occupiedCellsArray = list(occupiedCells.keys())
    for i in range(len(occupiedCellsArray)):
        x = int(occupiedCellsArray[i][0])
        y = int(occupiedCellsArray[i][1])
        centerCell = getCenterCell(x, y)
        if centerCell not in cellsInSomeRegion:
            frontier = getSurroundingCells(x, y)
            regions[centerCell] = [centerCell]
            cellsInSomeRegion[centerCell] = 1
            findCellsInRegion(centerCell, frontier, regions, cellsInSomeRegion, occupiedCells)
    regionsList = list(regions.keys())
    for i in range(len(regionsList)):
        if biggestRegion < len(regions[regionsList[i]]):
            biggestRegion = len(regions[regionsList[i]])
    return biggestRegion

def findCellsInRegion(centerCell, frontier, regions, cellsInSomeRegion, occupiedCells):
    if len(frontier) == 0:
        return
    c = frontier.pop()
    if c in occupiedCells and c not in cellsInSomeRegion:
        cellsInSomeRegion[c] = 1
        regions[centerCell].append(c)
        newFront = getSurroundingCells(int(c[0]), int(c[1]))
        for i in range(len(newFront)):
            frontier.append(newFront[i])
        return findCellsInRegion(centerCell, frontier, regions, cellsInSomeRegion, occupiedCells)
    return findCellsInRegion(centerCell, frontier, regions, cellsInSomeRegion, occupiedCells)

def getSurroundingCells(x, y):
    xminus = str(x-1)
    xplus = str(x+1)
    xneutral = str(x)
    yminus = str(y-1)
    yplus = str(y+1)
    yneutral = str(y)
    leftCell = xminus + yneutral
    topLeftCell = xminus + yminus
    topCell = xneutral + yminus
    topRightCell = xplus + yminus
    rightCell = xplus + yneutral
    lowerRightCell = xplus + yplus
    lowerCell = xneutral + yplus
    lowerLeftCell = xminus + yplus
    f = [leftCell, topLeftCell, topCell, topRightCell,
         rightCell, lowerRightCell, lowerCell, lowerLeftCell]
    return f

def getCenterCell(x, y):
    xneutral = str(x)
    yneutral = str(y)
    centerCell = xneutral + yneutral
    return centerCell

n = int(input().strip())
m = int(input().strip())
grid = []
for grid_i in range(n):
    grid_t = list(map(int, input().strip().split(' ')))
    grid.append(grid_t)
print(getBiggestRegion(grid))
