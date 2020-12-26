import queue as Q
"""
def search(graph, start, end):
    if start not in graph:
        raise TypeError(str(start) + ' not found in graph !')
        return
    if end not in graph:
        raise TypeError(str(end) + ' not found in graph !')
        return
    
    queue = Q.PriorityQueue()
    queue.put((0, [start]))
    
    while not queue.empty():
        node = queue.get()
        current = node[1][len(node[1]) - 1]
        
        if end in node[1]:
            print("Path found: " + str(node[1]) + ", Cost = " + str(node[0]))
            break
        
        cost = node[0]
        for neighbor in graph[current]:
            temp = node[1][:]
            temp.append(neighbor)
            queue.put((cost + graph[current][neighbor], temp))
        
def readGraph():
    lines = int( input() )
    graph = {}
    
    for line in range(lines):
        line = input()
            
        tokens = line.split()
        node = tokens[0]
        graph[node] = {}
        
        for i in range(1, len(tokens) - 1, 2):
            # print(node, tokens[i], tokens[i + 1])
            # graph.addEdge(node, tokens[i], int(tokens[i + 1]))
            graph[node][tokens[i]] = int(tokens[i + 1])
    return graph

def main():
    graph = readGraph()
    print(graph)
    search(graph, 'Arad', 'Bucharest')
    
if __name__ == "__main__":
    main()
    
"""   
"""
import copy
import queue as Q

class Graph:

    # graph dictonary contains all the adjacent nodes of each as key and value pair
    # cost_dict contains cost of each edge traversal of (u,v)
    # final_dict contains all the possible paths from start node s to goal node g with total cost
    def __init__(self):
        self.graph = dict()
        self.cost_dict=dict()
        self.final_dict=dict()
    
    def __repr__(self):
        return str(self.idNodo)
    # u and v are nodes: edge u-->v with cost c 
    def addEdge(self,u,v,c):
        
        if u not in self.graph:
            qu = Q.PriorityQueue()
            self.graph.update({u:qu})

        self.graph[u].put(v)
        self.cost_dict.update({(u,v):c})
        
    # Makes a list to keep track of visited nodes
    def tnode(self,n):
        self.visited = [False]*n


    def UCS_util(self,s,visited,path,goal,value):
        # Appending node to the current path 
        path.append(s)
        # Marking that node is visited 
        visited[s]=True
        
        # If goal node is reached save the path and return
        if goal==s:
            self.final_dict.update({tuple(path):value})
            return
        
        # Checking if the adjacent node is been visited and explore the new path if haven't
        for i in self.graph[s].queue:
            if visited[i]==False:
                # When new path is being explored add the cost of that path to cost of entire course traversal
                # Send a copy of path list to avoid sending it by reference
                self.UCS_util(i,copy.deepcopy(visited),copy.deepcopy(path),goal,value + self.cost_dict[s,i])

    def UCS(self, s,goal):
        self.visited[s] = True
        # List to hold all the nodes visited in path from start node to goal node 
        path=[s]
        
        for i in self.graph[s].queue:
            if self.visited[i] == False:
                # Make a variable to hold the cost of traversal
                value = self.cost_dict[s,i]
                self.UCS_util(i,copy.deepcopy(self.visited),copy.deepcopy(path),goal,value)

    # Display all the paths that is been discovered from start node to Goal node
    def all_paths(self):
        # Check if there is any path
        if bool(self.final_dict):
            print("All the paths: ")
            for i in self.final_dict:
                print ("path: ",i,"cost: ",self.final_dict[i])
        else:
            print ("No Path exist between start and goal node")

    # Find the most optimal path between start node to goal node
    def optimal_path(self):
        if bool(self.final_dict):
            print ("best path: ",min(self.final_dict, key=self.final_dict.get))
        else:
            print ("No Path exist between start and goal node")

g = Graph()
g.tnode(10)

g.addEdge(0, 1, 1); g.addEdge(0, 2, 1); g.addEdge(1, 3, 3);
g.addEdge(2, 5, 2); g.addEdge(3, 6, 4); g.addEdge(3, 5, 2);
g.addEdge(4, 6, 1); g.addEdge(4, 7, 5); g.addEdge(5, 4, 4);
g.addEdge(6, 7, 1); g.addEdge(5, 0, 3); g.addEdge(5, 8, 1);
g.addEdge(8, 4, 1); g.addEdge(8, 9, 3); g.addEdge(9, 7, 1);

g.UCS(0,7)
print(g)
g.all_paths()

g.optimal_path()

"""
from turtle import *
import tkinter.messagebox
import tkinter
import random
import math
import datetime

class Stack:
    def __init__(self):
        self.lst = []
        
    def push(self,x):
        self.lst.append(x)
        
    def pop(self):
        return self.lst.pop()
    
    def isEmpty(self):
        return len(self.lst) == 0
    
    def peek(self):
        return self.lst[-1]
   
def main():
    def goto(t,node,maze):
        row,col = node
        x = squareWidth * col + squareWidth/2.0
        y = squareHeight * row + squareHeight/2.0
        t.goto(x,y)
    
    def trace(path,turtle, maze, color):
        turtle.color(color)
        turtle.pendown()
        turtle.width(10)
        
        for node in path:
            goto(turtle, node, maze)
            
        turtle.penup()
        
    root = tkinter.Tk()
    root.title("Hill Climbing Maze")
    cv = ScrolledCanvas(root,600,600,600,600)
    cv.pack(side = tkinter.LEFT)
    t = RawTurtle(cv)
    screen = t.getscreen()
    screen.bgcolor("green")
    t.ht()
    screen.setworldcoordinates(0,0,600,600)
    
    def drawSquare(row,col,color):
        t.penup()
        t.color(color)
        t.goto(col*squareWidth, row*squareHeight)
        t.setheading(0)
        t.begin_fill()
        t.forward(squareWidth)
        t.left(90)
        t.forward(squareHeight)
        t.left(90)
        t.forward(squareWidth)
        t.left(90)
        t.forward(squareHeight)
        t.end_fill()
    
    
    maze = []
    file = open("maze2.txt", "r")
    rows = int(file.readline())
    cols = int(file.readline())
    squareWidth = 600.0 / cols
    squareHeight = 600.0 / rows
    for line in file:
        maze.append((line+"                                                            ")[:cols])
        
    screen.tracer(0)
    
    for row in range(len(maze)):
        for col in range(len(maze[row])):
            if maze[row][col] == "*":
                drawSquare(row, col, "blue")
    
        
    screen.tracer(1)
    screen.update()
    
    for c in range(cols):
        if maze[rows-1][c] == " ":
            endCol = c
        
    def mouseHandler(x,y):
        for c in range(cols):
            if maze[0][c] == " ":
                startCol = c
        screen.update()
        print(x,y)
        path = hillclimbing((0,startCol),goal,[])
        trace(path, t, maze, "purple")
        
        
    def adjacent(row,col):
        adjList = []
        if col < cols-1:
            if maze[row][col+1] == " ":
                adjList.append((row,col+1))
        if col > 0:
            if maze[row][col-1] == " ":
                adjList.append((row,col-1))
        if row < rows:
            if maze[row+1][col] == " ":
                adjList.append((row+1,col))
        if row > 0:
            if maze[row-1][col] == " ":
                adjList.append((row-1,col))
        return adjList
    
    
    
    def hillclimbing(current,goal,visited): 
        print('FDS>>>>>>',current,type(current))
        stack = Stack()
        stack.push([current])
        visited = []

        t.penup()
        t.st()
        goto(t,current,maze)
        
        while not stack.isEmpty():
            currentPath = stack.pop()
            currentNode = currentPath[0]
            visited.append(currentNode)
            t.st()
            goto(t, currentNode, maze)
            
        
                
            if goal(currentNode):
                print("found the goal")
                return currentPath
            row,col = currentNode
            adjList = adjacent(row,col)
            adjList = [x for x in adjList if x not in visited]
            nodelist = []
            for d in adjList:
                n = Node(d[0],d[1])
                nodelist.append(n)
            print("Before sort:")
            for i in nodelist:
                print(i.getRow(),i.getCol())
            nodelist.sort()
            print("After sort:")
            for i in nodelist:
                print(i.getRow(),i.getCol())
                
            if len(nodelist) == 0:
                # backtrack
                if not stack.isEmpty():
                    lastPath = stack.peek()
                    pathDiff = currentPath[0:(len(currentPath)-len(lastPath))+1]
                    trace(pathDiff,t,maze, "red")
                    
            else:
                for adjNode in nodelist:
                    stack.push([(adjNode.getRow(),adjNode.getCol())]+currentPath)
                
        # did not find a path
        return None

    def goal(node):
        row,col = node
        return row == rows-1
    
    def manhattan(otherNode,goalNode):
        manhattanDist = abs(goalNode.getRow() - otherNode.getRow()) + abs(goalNode.getCol() - otherNode.getCol())
        return manhattanDist
    
    
    class Node:
        def __init__(self,row,col):
            self.row = row
            self.col = col
            
        def __lt__(self,other):
            goal = Node(rows-1,endCol)
            return manhattan(self,goal) > manhattan(other,goal)
        
        def getRow(self):
            return self.row
        
        def getCol(self):
            return self.col
        
        
  

    
    screen.listen()
    screen.onclick(mouseHandler)
    tkinter.mainloop()
    


            
if __name__ == "__main__":
    main()