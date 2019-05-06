import java.util.ArrayList;

public class Path {
	
	ArrayList<Node> open = new ArrayList<Node>();
	ArrayList<Node> close = new ArrayList<Node>();
	ArrayList<Node> cameFrom = new ArrayList<Node>();
	
	public ArrayList<Node> pathfinding(Node start , Node goal , Mazu mazu) {
		//��l�� open �M close open�[�J �_�I
		open.clear();
		close.clear();	
		open.add(start);
		
		while(open.size() != 0) {
			//�b open �̿� f�ȳ̧C�� ���� ��e�I
			Node current = null;
			for (int i = 0; i < open.size(); i++) {
				if(current == null || current.f < open.get(i).f) {
					current = open.get(i);
				}
			}
			if(current == goal) {			
				return close;
			}
			//���� open �̪���e�I�A�[��close
			open.remove(current);
			close.add(current);
			
			//�M�� ��e�I �� �F���I;
			Node[] neighbor = current.neighbor(mazu);
			for (int i = 0; i < neighbor.length; i++) {
				//�p�G ��e�I���F�I�b close�� �h���L���ʧ@
				if( close.contains(neighbor[i]) ) {
					continue;
				}
				//�p�� g��
				int g = current.g + neighbor[i].goCost;
				
				
				//�p�G�F�I���b open�� �h�[�J
				if(neighbor[i] != null || !open.contains(neighbor[i])) {
					open.add( neighbor[i] );
				}else if(g >= neighbor[i].g) {
					continue;
				}
				
				//�p��F�I f g ��
				neighbor[i].g = g;
				neighbor[i].f = g + neighbor[i].getH(goal);
			}
				
			
			
			
			
		}
		
		
		return null;
		
	}
	

	

}
