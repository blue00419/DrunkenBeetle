package beetle;

import java.util.Random;

public class Calculator {
	int count; // ÇÁ·Î±×·¥ ½ÇÇàÈ½¼ö
	int size; // ¹æÀÇ Å©±â
	int basex; // µüÁ¤¹ú·¹ÀÇ ½ÃÀÛ xÁÂÇ¥
	int basey; // µüÁ¤¹ú·¹ÀÇ ½ÃÀÛ yÁÂÇ¥
	int movexy[] = new int[2]; // ·£´ýÀ¸·Î µüÁ¤¹ú·¹°¡ ¿òÁ÷ÀÏ ¹æÇâ

	public void setCount(String a) {
		count=Integer.parseInt(a);
	}
	
	public int getCount() {
		return count;
	}
	
	public void setSize(String a) {
		size=Integer.parseInt(a);
	}
	
	public int getSize() {
		return size;
	}
	
	public void setBase(String a, String b) {
		basex= Integer.parseInt(a);
		basey = Integer.parseInt(b);
	}
	
	public int getBasex() {
		return basex;
	}
	
	public int getBasey() {
		return basey;
	}
	
	public int[] move(){
		Random r = new Random();
		int direct=r.nextInt(8)+1;
		switch(direct){
		case 1:
			movexy[0]=0;
			movexy[1]=-1;
			break;
		case 2:
			movexy[0]=1;
			movexy[1]=-1;
			break;
		case 3:
			movexy[0]=1;
			movexy[1]=0;
			break;
		case 4:
			movexy[0]=1;
			movexy[1]=1;
			break;
		case 5:
			movexy[0]=0;
			movexy[1]=1;
			break;
		case 6:
			movexy[0]=-1;
			movexy[1]=1;
			break;
		case 7:
			movexy[0]=-1;
			movexy[1]=0;
			break;
		case 8:
			movexy[0]=-1;
			movexy[1]=-1;
			break;
		}
		return movexy;
	}
}
