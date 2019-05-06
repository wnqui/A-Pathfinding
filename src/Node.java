
public class Node {

	int x;
	int y;
	int goCost;

	int f;
	int g;
	int h;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getH(Node goal) {

		return Math.abs(goal.x - this.x) + Math.abs(goal.y - this.y);

	}
	

	public Node[] neighbor(Mazu mazu) {
		Node[] neighbor = new Node[8];

		if (mazu.map[x][y - 1] == 0) {
			neighbor[0] = new Node(x, y - 1);
			neighbor[0].goCost = 10;			
		}
		
		if (mazu.map[x + 1][y - 1] == 0)
			neighbor[1] = new Node(x + 1, y - 1);
		
		if (mazu.map[x + 1][y] == 0)
			neighbor[2] = new Node(x + 1, y);
		
		if (mazu.map[x + 1][y + 1] == 0)
			neighbor[3] = new Node(x + 1, y + 1);
		
		if (mazu.map[x][y + 1] == 0)
			neighbor[4] = new Node(x, y + 1);
		
		if (mazu.map[x - 1][y + 1] == 0)
			neighbor[5] = new Node(x - 1, y + 1);
		
		if (mazu.map[x - 1][y] == 0)
			neighbor[6] = new Node(x - 1, y);
		
		if (mazu.map[x - 1][y - 1] == 0)
			neighbor[7] = new Node(x - 1, y - 1);

		return neighbor;
	}

}
