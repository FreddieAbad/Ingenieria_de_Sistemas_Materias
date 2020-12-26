"""
def ucs(G, v):
    visited = set()                  # set of visited nodes
    q = queue.PriorityQueue()        # we store vertices in the (priority) queue as tuples 
                                     # (f, n, path), with
                                     # f: the cumulative cost,
                                     # n: the current node,
                                     # path: the path that led to the expansion of the current node
    q.put((0, v, [v]))               # add the starting node, this has zero *cumulative* cost 
                                     # and it's path contains only itself.

    while not q.empty():             # while the queue is nonempty
        f, current_node, path = q.get()
        visited.add(current_node)    # mark node visited on expansion,
                                     # only now we know we are on the cheapest path to
                                     # the current node.

        if current_node.is_goal:     # if the current node is a goal
            return path              # return its path
        else:
            for edge in in current_node.out_edges:
                child = edge.to()
                if child not in visited:
                    q.put((current_node_priority + edge.weight, child, path + [child]))
                
import urllib.request
import random
def generarPalabras():
    word_url = "http://svnweb.freebsd.org/csrg/share/dict/words?view=co&content-type=text/plain"
    response = urllib.request.urlopen(word_url)
    long_txt = response.read().decode()
    words = long_txt.splitlines()
    

    upper_words = [word for word in words if word[0].isupper()]
    name_words  = [word for word in upper_words if not word.isupper()]
    rand_name   = ' '.join([name_words[random.randint(0, len(name_words))] for i in range(2)])
    
    for n in range(10):
        ' '.join([name_words[random.randint(0,len(name_words))] for i in range(2)])
    print(">>>>>>>>>>",name_words)
generarPalabras()
##########################
import string
import random
def random_generator(longitud,size=6, chars=string.ascii_uppercase + string.digits):
    lista=[]
    for i in range(longitud):
        lista.append(''.join(random.choice(chars) for x in range(size)))
    return lista
    #return ''.join(random.choice(chars) for x in range(size))
print(random_generator(4))  
"""
def hillclimbing(current,goal,visited): 
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
path = hillclimbing((0,startCol),goal,[])