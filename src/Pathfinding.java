import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Pathfinding implements ActionListener {
	
	//variable
	public static int WIDTH =800;
	public static int HEIGHT = 800;
	//object
	public static JFrame JF;
	public static myJPanel MP;
	public static Pathfinding PF;
	public static Maze M = new Maze();
	public static Node start = new Node(5,5);
	//control
	
	
	public Pathfinding() {
		JF = new JFrame("A* Pathfinding");
		MP = new myJPanel();
		JF.setBounds(100, 100, WIDTH, HEIGHT);
		JF.setVisible(true);
		JF.setResizable(false);
		JF.setAlwaysOnTop(true);
		JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JF.add(MP);
		
		Timer t = new Timer(20,this);
		t.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MP.repaint();
	}
	public void repaint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3));
		//白底
		g2.setColor(Color.white);
		g2.fillRect(0, 0, WIDTH, HEIGHT);
		
		//畫地圖
		M.drawMaze(g);
		start.draw(g);
	}
	
	public static void main(String[] args) {
		PF = new Pathfinding();
	}


	
//end	
}

class myJPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public void paintComponent(Graphics g) {
		Pathfinding.PF.repaint(g);
	}
	
}