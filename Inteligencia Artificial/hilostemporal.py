import time
import random
from collections import deque

__author__ = 'Rodion "rodde" Efremov'


class DirectedGraphNode:
    """This class implements a node type for a directed graph."""

    def __init__(self, name):
        """Initializes a new DirectedGraphNode with a given name, and creates two sets for reprsenting child and parent
           nodes of this node."""
        if name is None:
            raise ValueError("The name of a new node is None.")
        self.name = name
        self.children = set()
        self.parents = set()

    def __hash__(self):
        """Makes this node eligible for using as a key in hash tables."""
        return self.name.__hash__()

    def __eq__(self, other):
        """Makes it possible to use another node with the same name as a key for hash tables."""
        return self.name == other.name

    def __str__(self):
        return "[DirectedGraphNode: " + self.name + "]"

    def __repr__(self):
        return '%s(%r)' % (self.__class__.__name__, self.name)

    def add_child(self, child):
        """Makes 'child' a child node of this node. This creates a directed arc from this node to 'child'."""
        self.children.add(child)
        child.parents.add(self)

    def has_child(self, child_candidate):
        """Checks that there is an arc from this node to 'child_candidate'."""
        return child_candidate in self.children


def traceback_path(target, parents):
    """Builds the path from implicit source node to the target node 'target' using the parent map 'parents'."""
    path = []
    current = target

    while current:
        path.append(current)
        current = parents[current]

    return list(reversed(path))


def bi_traceback_path(touch_node, parents_a, parents_b):
    """Builds a shortest path after a bidirectional search."""
    path = traceback_path(touch_node, parents_a)
    current = parents_b[touch_node]

    while current:
        path.append(current)
        current = parents_b[current]

    return path


def breadth_first_search(source, target):
    """Implements (unidirectional) breadth-first search for finding shortest (unweighted) paths between two input
       nodes ('source' and 'target')."""
    queue = deque([source])
    parents = {source: None}

    while queue:
        current = queue.popleft()

        if current is target:
            return traceback_path(target, parents)

        for child in current.children:
            if child not in parents.keys():
                parents[child] = current
                queue.append(child)

    return []


def bidirectional_breadth_first_search(source, target):
    """Implements a bidirectional breadth-first search for finding shortest (unweighted) paths between two input nodes
       ('source' and 'target')."""
    queue_a = deque([source])
    queue_b = deque([target])
    parents_a = {source: None}
    parents_b = {target: None}
    distance_a = {source: 0}
    distance_b = {target: 0}

    best_cost  = {'value': 1000000000} # best_cost is ugly
    touch_node = {'value': None}

    """Implements an actual routine for generating all the neighbors of a node."""
    def expand(queue, distance, distance_opposite, neighbors, parents):
        current = queue.popleft()

        if current in distance_opposite.keys() and best_cost['value'] > dist_a + dist_b:
            best_cost ['value'] = dist_a + dist_b
            touch_node['value'] = current

        for neighbor in neighbors:
            if neighbor not in distance.keys():
                distance[neighbor] = distance[current] + 1
                parents[neighbor] = current
                queue.append(neighbor)

    while queue_a and queue_b:
        dist_a = distance_a[queue_a[0]]
        dist_b = distance_b[queue_b[0]]

        if touch_node['value'] and best_cost['value'] < dist_a + dist_b:
            return bi_traceback_path(touch_node['value'],
                                     parents_a,
                                     parents_b)
        # Trivial load balancing
        if len(distance_a) < len(distance_b):
            expand(queue_a,
                   distance_a,
                   distance_b,
                   queue_a[0].children,
                   parents_a)
        else:
            expand(queue_b,
                   distance_b,
                   distance_a,
                   queue_b[0].parents,
                   parents_b);

    return []


def create_directed_graph(nodes, edges):
    """Creates a random directed graph."""
    graph = [DirectedGraphNode(str(i + 1)) for i in range(nodes)]

    for _ in range(0, edges):
        j = random.randint(0, nodes - 1)
        k = random.randint(0, nodes - 1)
        graph[j].add_child(graph[k])

    return graph


def main():
    """Shows the performance demo by comparing the two BFS implementations."""
    graph = create_directed_graph(300000, 1000000)
    source = random.choice(graph)
    target = random.choice(graph)

    print("Source: ", source)
    print("Target: ", target)

    start_time = time.time()
    path1 = breadth_first_search(source, target)
    end_time = time.time()

    print("BFS path length", len(path1), ":")

    for node in path1:
        print(node)

    print("Time elapsed:", 1000.0 * (end_time - start_time), "milliseconds.")
    print()

    start_time = time.time()
    path2 = bidirectional_breadth_first_search(source, target)
    end_time = time.time()

    print("BiBFS path length", len(path2), ":")

    for node in path2:
        print(node)

    print("Time elapsed:", 1000.0 * (end_time - start_time), "milliseconds.")


if __name__ == "__main__":
    main()