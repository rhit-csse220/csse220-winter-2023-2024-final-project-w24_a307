package mainApp.domain;

public class TrackingMissile extends Missile{
	private Hero hero;
	public static final int TRACKING_SPEED = Math.abs(Hero.JETPACK_SPEED/3);
	public TrackingMissile(int x, int y, Hero hero) {
		super(x, y);
		this.hero = hero;
	}
	
	@Override
	public void update()
	{
		if(this.y > hero.y)
		{
			this.velY = -TRACKING_SPEED;
		}
		else if(this.y < hero.y)
		{
			this.velY = TRACKING_SPEED;
		}
		super.update();
	}

}
