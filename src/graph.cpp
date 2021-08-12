#include <iostream>
#include <cstdlib>
#include <cstdio>

using namespace std;

typedef struct LINKED_INT {
	int pos;
	int index;
	int weight;
	struct LINKED_INT *head;
	struct LINKED_INT *next;
}LI;

typedef struct LIGHT_LINKED_INT {
	int pos;
	struct LIGHT_LINKED_INT *next;
}LLI;

void makeLink(LI *node);
void remLightLinks(LLI *head);
void printLightLinks(LLI *head);
int printPath(int **weights, LI *node, int *lastIndex);
void pathing(int **weights, int visited[], LI *path, LLI *headLLI, int *nNoeds, int *min_dist);


int main(void) {
//	FILE *inptr;
//	inptr = freopen("graph.in", "r", stdin);
// uncomment to redirect input

	int N, E;
	cin >> N >> E; // input
	
	// declaring a 2d array; starting with a pointer to a pointer
	// why? to be easily passable to functions
	int **weights;
	weights = new int *[E];
	for(int i = 0; i < E; i++){
		weights[i] = new int[E]; 
	}
	// idk how this works but it does
	
	for(int i = 0; i < E; i++){ // initializing the array
		for(int j = 0; j < E; j++){
			weights[i][j] = 0;
		}
	}
	
	int from, to, weight;
	for(int i = 0; i < E; i++){ // input graph details
		cin >> from >> to >> weight;
		weights[from - 1][to - 1] = weight;
	}
	// inputs done
	
	int visited[N] = {0};
	LI *path;
	path = (LI*)malloc(sizeof(LI));
	path->pos = 0;
	path->head = path;
	
	// data to find the shortest path
	int min = 0;
	LLI *headLLI;
	headLLI = (LLI*)malloc(sizeof(LLI));
	headLLI->next = NULL;
	
	pathing(weights, visited, path, headLLI, &N, &min);
	
	cout << endl << "The path with the minimun distance:" << endl;
	printLightLinks(headLLI);
	cout << endl << min;
	
	return 0;
}

void copyLinks(LI *headLI, LLI *headLLI) {
	headLLI->pos = headLI->pos;
	if(headLI->next != NULL){
		headLLI->next = (LLI*)malloc(sizeof(LLI));	
		headLLI->next->next = NULL;
		copyLinks(headLI->next, headLLI->next);
	}
}

void remLightLinks(LLI *head) {
	if(head->next == NULL)
		return;
	
	if(head->next->next != NULL){
		remLightLinks(head->next);
	}
	free(head->next);
	return;
}

void printLightLinks(LLI *head) {
	cout << head->pos + 1 << " ";
	
	if(head->next != NULL){
		printLightLinks(head->next);
	}
	
	return;
}

void makeLink(LI *node) {
	node->next = (LI *)malloc(sizeof(LI));
	
	node->next->index = node->index + 1;
	node->next->head = node->head;
	node->next->next = NULL;
}

int printPath(int **weights, LI *head,int *lastIndex){ // prints the path, returns the sum of weights
	cout << head->pos + 1 << " ";
	
	// the variable name "head" doesn't make intuitive sense when seen from within the function
	// look from outside the function scope
	if(head->index == *lastIndex){
		cout << endl;
		return 0;
	}
	
	return weights[head->pos][head->next->pos] + printPath(weights, head->next, lastIndex);
}

void pathing(int **weights, int visited[], LI *path, LLI *headLLI, int *nNodes, int *min_dist){
	visited[path->pos] = 1;
	
	if(path->pos == *nNodes - 1){
		int out_dist = printPath(weights, path->head, &(path->index));
		cout << out_dist << endl;
		
		if(out_dist < *min_dist || *min_dist == 0){
			*min_dist = out_dist;
			remLightLinks(headLLI);
			copyLinks(path->head, headLLI);
		}
		
		visited[path->pos] = 0;
		return;
	}
	
	for(int i = 0; i < *nNodes; i++){		
		if(visited[i] == 0 && weights[path->pos][i] > 0){ // can go to next?
			makeLink(path);
			path->next->pos = i;
			
			pathing(weights, visited, path->next, headLLI, nNodes, min_dist);
			
			free(path->next);
		}
	}
	visited[path->pos] = 0;
	return;
}
