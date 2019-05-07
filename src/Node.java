import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Node {

	int x;
	int y;
	

	int f;
	int g;
	int h;
	
	Node parent;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getHscore(Node goal) {

		return Math.abs(goal.x - this.x) + Math.abs(goal.y - this.y);

	}
	

	public Node[] neighbor(Maze mazu , Node goal) {
		Node[] neighbor = new Node[8];

		if (mazu.map[x][y - 1] == 0) {
			neighbor[0] = new Node(x, y - 1);
			neighbor[0].parent = this;
			neighbor[0].g = this.g + 10;
			neighbor[0].getHscore(goal);
		}
		
		if (mazu.map[x + 1][y - 1] == 0) {
			neighbor[1] = new Node(x + 1, y - 1);
			neighbor[1].parent = this;	
			neighbor[1].g = this.g + 14;
			neighbor[1].getHscore(goal);
		}
		
		if (mazu.map[x + 1][y] == 0) {
			neighbor[2] = new Node(x + 1, y);
			neighbor[2].parent = this;
			neighbor[2].g = this.g + 10;
			neighbor[2].getHscore(goal);
		}
			
		
		if (mazu.map[x + 1][y + 1] == 0) {
			neighbor[3] = new Node(x + 1, y + 1);
			neighbor[3].parent = this;
			neighbor[3].g = this.g + 14;
			neighbor[3].getHscore(goal);
		}
		
		if (mazu.map[x][y + 1] == 0) {
			neighbor[4] = new Node(x, y + 1);
			neighbor[4].parent = this;
			neighbor[4].g = this.g + 10;
			neighbor[4].getHscore(goal);
		}
		
		if (mazu.map[x - 1][y + 1] == 0) {
			neighbor[5] = new Node(x - 1, y + 1);
			neighbor[5].parent = this;
			neighbor[5].g = this.g + 14;
			neighbor[5].getHscore(goal);
		}
		
		if (mazu.map[x - 1][y] == 0) {
			neighbor[6] = new Node(x - 1, y);
			neighbor[6].parent = this;
			neighbor[6].g = this.g + 10;
			neighbor[6].getHscore(goal);
		}
		
		if (mazu.map[x - 1][y - 1] == 0) {
			neighbor[7] = new Node(x - 1, y - 1);
			neighbor[7].parent = this;
			neighbor[7].g = this.g + 14;
			neighbor[6].getHscore(goal);
		}

		return neighbor;
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;	
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.red);
		g2.fillOval(50+this.x*30, 50+this.y*30, 30, 30);
	}
}
