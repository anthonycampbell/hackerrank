def findLengthsToAllReachableNodes(self, nodesReached, distToS, frontier):
    if len(frontier) is 0:
        return
    for i in range(len(frontier)):
        for j in range(len(self.adjList[frontier[i]])):
            if self.adjList[frontier[i]][j] not in nodesReached:
                nodesReached[self.adjList[frontier[i]][j]] = distToS
                frontier.append(self.adjList[frontier[i]][j])
    t = frontier.pop(0)
    findLengthsToAllReachableNodes(self, nodesReached,distToS +1, frontier)


class Graph():
    def __init__(self, n):
        self.adjList = []
        for i in range (n):
            self.adjList.append([])

    def connect(self, x, y):
        self.adjList[x].append(y)
        self.adjList[y].append(x)

    def print(self):
        l = len(self.adjList)
        for i in range(l):
            print(self.adjList[i])

    def find_all_distances(self, s):
        nodesReached = {}
        nodesReached[s] = -2
        frontier = [s]
        result = ""
        findLengthsToAllReachableNodes(self, nodesReached, 1, frontier)
        l = len(self.adjList)
        for i in range(l):
            if i in nodesReached and i != s:
                result = result + str(nodesReached[i]*6) + " "
            elif i != s:
                result = result + str(-1) + " "
        print(result[:len(result)])

t = int(input())
for i in range(t):
    n,m = [int(value) for value in input().split()]
    graph = Graph(n)
    for i in range(m):
        x,y = [int(x) for x in input().split()]
        graph.connect(x-1,y-1)
    s = int(input())
    graph.find_all_distances(s-1)
    
