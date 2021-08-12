# Python Code for the H.W. given on 06/08/2021, by Shifan - IT21067556

def next_node(pos):
    """returns the list of the next nodes that can be travelled to"""
    ret_arr = []
    for i in range(len(weights)):
        if visited[i] == 0 and weights[pos][i] != 0:
            ret_arr.append(i)
    else:
        return ret_arr


def pathing():
    """Returns the list of viable paths and distances travelled"""
    # base cases
    visited[path[-1]] = 1
    if len(next_node(path[-1])) == 0 and path[-1] == V - 1:
        out_dist = 0;
        out_path= ""
        for i in range(len(path)):
            out_path += str(path[i] + 1) + " "
            if i + 1 < len(path):
                out_dist += weights[path[i]][path[i + 1]]
        ans.append([out_dist, out_path.strip()])

    # recursion
    for i in next_node(path[-1]):
        path.append(i)
        pathing()
        visited[path[-1]] = 0
        path.pop(-1)


if __name__ == '__main__':
    V, E = map(int, input().strip().split())

    weights = [[0 for i in range(V)] for i in range(V)]
    visited = [0 for i in range(V)]
    path = [0]
    ans = []

    for i in range(0, E):
        fromN, toN, weight = map(int, input().strip().split())
        weights[fromN - 1][toN - 1] = weight

    pathing()

    min_dist = ans[0][0]
    min_i = 0
    print("All paths:")
    for i in range(0, len(ans)):
        print(str(ans[i][0]) + " : " + ans[i][1])
        if ans[i][0] <  min_dist:
            min_dist = ans[i][0]
            min_i = i
    print("\nPath With Min Distance:\n" + str(ans[min_i][0]) + " : " + ans[min_i][1])
