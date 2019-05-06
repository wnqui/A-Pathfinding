import java.util.ArrayList;

public class Path {
	
	ArrayList<Node> open = new ArrayList<Node>();
	ArrayList<Node> close = new ArrayList<Node>();
	ArrayList<Node> cameFrom = new ArrayList<Node>();
	
	public ArrayList<Node> pathfinding(Node start , Node goal , Mazu mazu) {
		//初始化 open 和 close open加入 起點
		open.clear();
		close.clear();	
		open.add(start);
		
		while(open.size() != 0) {
			//在 open 裡選 f值最低的 做為 當前點
			Node current = null;
			for (int i = 0; i < open.size(); i++) {
				if(current == null || current.f < open.get(i).f) {
					current = open.get(i);
				}
			}
			if(current == goal) {			
				return close;
			}
			//移除 open 裡的當前點，加到close
			open.remove(current);
			close.add(current);
			
			//遍歷 當前點 之 鄰近點;
			Node[] neighbor = current.neighbor(mazu);
			for (int i = 0; i < neighbor.length; i++) {
				//如果 當前點之鄰點在 close裡 則跳過不動作
				if( close.contains(neighbor[i]) ) {
					continue;
				}
				//計算 g值
				int g = current.g + neighbor[i].goCost;
				
				
				//如果鄰點不在 open裡 則加入
				if(neighbor[i] != null || !open.contains(neighbor[i])) {
					open.add( neighbor[i] );
				}else if(g >= neighbor[i].g) {
					continue;
				}
				
				//計算鄰點 f g 值
				neighbor[i].g = g;
				neighbor[i].f = g + neighbor[i].getH(goal);
			}
				
			
			
			
			
		}
		
		
		return null;
		
	}
	

	

}
