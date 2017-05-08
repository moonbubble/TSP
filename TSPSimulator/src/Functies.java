
public class Functies {
	private String beginPunt;
	private String volgendePunt;

	public Functies(Product bp, Product vp) {
		this.beginPunt = bp.getLocatie();
		this.volgendePunt = vp.getLocatie();
	}
	public void routeBerekenen() {
		String[] output1 = beginPunt.split("-");
		String[] output2 = volgendePunt.split("-");
		int posX1 = Integer.parseInt(output1[0]);
		int posY1 = Integer.parseInt(output1[1]);
		int posX2 = Integer.parseInt(output2[0]);
		int posY2 = Integer.parseInt(output2[1]);
		int difX = 0;
		int difY = 0;
		if (posX1 > posX2) {
			difX = posX1 - posX2;
			System.out.println(difX + " naar links");
		} else if (posX1 < posX2) {
			difX = posX2 - posX1;
			System.out.println(difX + " naar rechts");
		}

		if (posY1 > posY2) {
			difY = posY1 - posY2;
			System.out.println(difY + " naar beneden");
		} else if (posY2 < posY1) {
			difY = posY2 - posY1;
			System.out.println(difY + " naar boven");
		}
		@SuppressWarnings("unused")
		int route = difX + difY;
	}

}
