import threading

from ..grafo import Nodo as node

# busqueda por anchura.
def BFS(node_root, nodes_end: object):
    cola = [node_root]
    output = []

    if len(nodes_end[0].roots) == 0:
        return None

    while cola and nodes_end:
        evalue_node = cola[0]
        for node_son, _ in evalue_node.sons:
            if not node_son in cola and not node_son in output:
                cola.append(node_son)
        if evalue_node in nodes_end:
            nodes_end.remove(evalue_node)
        output.append(evalue_node)
        del cola[0]
    if len(nodes_end):
        return None
    return output


# busqueda en profundidad.
def DFS(node_root, nodes_end: list):
    if len(nodes_end[0].roots) == 0:
        return None

    cola = [node_root]
    output = []
    while cola and nodes_end:
        evalue_node = cola[0]
        for node_son, _ in evalue_node.sons.__reversed__():
            if not node_son in cola and not node_son in output:
                cola = [node_son] + cola
        if evalue_node in nodes_end:
            nodes_end.remove(evalue_node)
        output.append(evalue_node)
        cola.remove(evalue_node)
    if len(nodes_end):
        return None
    return output


def func1(node_root, nodes_end: list, level):
    level_tem = level
    cola = [(node_root, level_tem - level)]
    output = []
    while cola and nodes_end:
        evalue_node = cola[0]
        if evalue_node[1] <= level_tem or level > 0:
            level -= 1
            for node_son, _ in evalue_node[0].sons.__reversed__():
                bandera = True

                for test in cola:
                    if test[0] is node_son:
                        bandera = False
                for test in output:
                    if test[0] is node_son:
                        bandera = False
                if bandera:
                    cola = [(node_son, level_tem - level)] + cola

        if evalue_node in nodes_end:
            nodes_end.remove(evalue_node)
        output.append(evalue_node)
        cola.remove(evalue_node)
    return output


def func(node_root, nodes_end: object):
    salida = [[(node_root, 0)]]
    level = 0
    tag = True
    while tag:
        salida.append(func1(node_root, [nodes_end], level))
        level += 1
        for sal in salida:
            for sal1 in sal:
                if sal1[0] is nodes_end:
                    tag = False

    return salida


# busqueda por profundidad iterativa.
def BPI(node_root, nodes_end: object):
    if len(nodes_end.roots) == 0:
        return None
    return func(node_root, nodes_end)


def hilo1(node_root, nodes_end, out_init, out_end):
    if len(nodes_end[0].roots) == 0:
        return None
    cola = [node_root]
    while cola and nodes_end:
        evalue_node = cola[0]
        for node_son, _ in evalue_node.sons.__reversed__():
            if not node_son in cola and not node_son in out_init:
                cola = [node_son] + cola
        if evalue_node in nodes_end:
            nodes_end.remove(evalue_node)
        if evalue_node in out_end:
            break
        out_init.append(evalue_node)

        cola.remove(evalue_node)

    if len(nodes_end):
        return None


def hilo2(node_root, nodes_end, out_init, out_end):
    if len(node_root[0].sons) == 0:
        return None

    cola = [nodes_end]
    while cola and node_root:
        evalue_node = cola[0]
        for node_son, _ in evalue_node.roots.__reversed__():
            if not node_son in cola and not node_son in out_end:
                cola = [node_son] + cola
        if evalue_node in node_root:
            node_root.remove(evalue_node)
        if evalue_node in out_init:
            break
        out_end.insert(0, evalue_node)
        cola.remove(evalue_node)

    if len(node_root):
        return None


# busqueda bidireccional.
def BS(node_root: node.Node, nodes_end):
    out_init = []
    out_end = []

    t1 = threading.Thread(hilo1(node_root, [nodes_end], out_init, out_end))
    t2 = threading.Thread(hilo2([node_root], nodes_end, out_init, out_end))

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    return out_init + out_end


# busqueda de costo uniformes.
def CUS(node_root: node.Node, nodes_end):
    if len(nodes_end.roots) == 0:
        return [None, None]
    cola = [[[node_root], 0]]
    while cola:
        node_evaluar = cola[0]
        if node_evaluar[0][len(node_evaluar[0]) - 1] is nodes_end:
            return node_evaluar
        del cola[0]
        for node_son, peso in node_evaluar[0][len(node_evaluar[0]) - 1].sons:
            cola.append([node_evaluar[0] + [node_son], str(int(node_evaluar[1]) + int(peso))])
        cola.sort(key=lambda nodo: nodo[1], reverse=True)
    return [None, None]


def bsuqueda_ascenso_colina(node_root: node.Node, node_end):
    if len(node_end.roots) == 0:
        return None
    cola = [node_root]
    while True:
        if cola[- 1] is node_end:
            return cola
        if not len(cola[- 1].sons):
            return None
        soon_min = min(cola[- 1].sons, key=lambda soon: int(soon[0].weight))
        if soon_min[0].weight <= cola[- 1].weight:
            cola.append(soon_min[0])
        else:
            return None


def busqueda_primero_el_mejor(node_root: node.Node, nodes_end: list):
    if len(nodes_end[0].roots) == 0:
        return None
    cola = [node_root]
    output = []
    while cola and nodes_end:
        evalue_node = cola[0]
        nodes_soon = evalue_node.sons
        nodes_soon.sort(key=lambda nodo: int(nodo[0].weight), reverse=True)
        for node_son, _ in nodes_soon:
            if not node_son in cola and not node_son in output:
                cola = [node_son] + cola
        if evalue_node in nodes_end:
            nodes_end.remove(evalue_node)
        output.append(evalue_node)
        cola.remove(evalue_node)
    return output


def hilo_avara1(node_root, nodes_end, out_init, out_end):
    if len(nodes_end[0].roots) == 0:
        return None
    cola = [node_root]
    while cola and nodes_end:
        evalue_node = cola[0]
        nodes_soon = evalue_node.sons
        nodes_soon.sort(key=lambda nodo: int(nodo[0].weight), reverse=True)
        for node_son, _ in nodes_soon:
            if not node_son in cola and not node_son in out_init:
                cola = [node_son] + cola
        if evalue_node in nodes_end:
            nodes_end.remove(evalue_node)
        if evalue_node in out_end:
            break
        out_init.append(evalue_node)
        cola.remove(evalue_node)


def hilo_avara2(node_root, nodes_end, out_init, out_end):
    if len(node_root[0].sons) == 0:
        return None
    cola = [nodes_end]
    while cola and node_root:
        evalue_node = cola[0]
        nodes_soon = evalue_node.roots
        nodes_soon.sort(key=lambda nodo: int(nodo[0].weight), reverse=True)
        for node_son, _ in nodes_soon:
            if not node_son in cola and not node_son in out_end:
                cola = [node_son] + cola
        if evalue_node in node_root:
            node_root.remove(evalue_node)
        if evalue_node in out_init:
            break
        out_end.insert(0, evalue_node)
        cola.remove(evalue_node)


def busqueda_avara(node_root: node.Node, nodes_end: list):
    out_init = []
    out_end = []
    t1 = threading.Thread(hilo_avara1(node_root, [nodes_end], out_init, out_end))
    t2 = threading.Thread(hilo_avara2([node_root], nodes_end, out_init, out_end))
    t1.start()
    t2.start()
    t1.join()
    t2.join()
    return out_init + out_end


def busqueda_a_estrella(node_root: node.Node, node_end: node.Node):
    if len(node_end.roots) == 0:
        return None
    cola = [[[node_root], 0]]
    while cola:
        print("Buscando ....")
        node_evaluar = cola[0]
        if node_evaluar[0][len(node_evaluar[0]) - 1] is node_end:
            return node_evaluar
        del cola[0]
        for node_son, peso in node_evaluar[0][len(node_evaluar[0]) - 1].sons:
            cola.append([node_evaluar[0] + [node_son], str(int(node_evaluar[1]) + int(peso))])
        cola.sort(key=lambda nodo: int(int(nodo[1]) + int(node_evaluar[0][0].weight)))
        cola.__reversed__()
    return [None, None]
