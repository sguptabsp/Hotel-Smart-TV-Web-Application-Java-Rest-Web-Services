 public class Boxer1{
	 public Integer startingI;
	  public void methodA() {
	  Integer i = new Integer(25);
	  startingI = i;
	  methodB(i);
	  }
	  private void methodB(Integer i2) {
	  i2 = i2.intValue();
	  System.out.println(i2==startingI);
	  }
 }