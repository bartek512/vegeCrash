package main.java.vegeCrash.data.enums;

public enum Loot {
	
	NORMAL_CARROT(ExplosionType.NORMAL, VegeType.CARROT),
	PROMOTION_CARROT(ExplosionType.PROMOTION, VegeType.CARROT),
	SPECIAL_CARROT(ExplosionType.SPECIAL, VegeType.CARROT),
	SINGLE_CARROT(ExplosionType.SINGLE, VegeType.CARROT),

	NORMAL_ONION(ExplosionType.NORMAL, VegeType.ONION),
	PROMOTION_ONION(ExplosionType.PROMOTION, VegeType.ONION),
	SPECIAL_ONION(ExplosionType.SPECIAL, VegeType.ONION),
	SINGLE_ONION(ExplosionType.SINGLE, VegeType.ONION),

	NORMAL_CUCUMBER(ExplosionType.NORMAL, VegeType.CUCUMBER),
	PROMOTION_CUCUMBER(ExplosionType.PROMOTION, VegeType.CUCUMBER),
	SPECIAL_CUCUMBER(ExplosionType.SPECIAL, VegeType.CUCUMBER),
	SINGLE_CUCUMBER(ExplosionType.SINGLE, VegeType.CUCUMBER),

	NORMAL_BEETROOT(ExplosionType.NORMAL, VegeType.BEETROOT),
	PROMOTION_BEETROOT(ExplosionType.PROMOTION, VegeType.BEETROOT),
	SPECIAL_BEETROOT(ExplosionType.SPECIAL, VegeType.BEETROOT),
	SINGLE_BEETROOT(ExplosionType.SINGLE, VegeType.BEETROOT),

	NORMAL_PINEAPPLE(ExplosionType.NORMAL, VegeType.PINEAPPLE),
	NORMAL_PLUM(ExplosionType.NORMAL, VegeType.PLUM),
	NORMAL_PEACH(ExplosionType.NORMAL, VegeType.PEACH),
	NORMAL_PEAR(ExplosionType.NORMAL, VegeType.PEAR);
	
    private final ExplosionType explosionType;
    private final VegeType vegeType;

    Loot(ExplosionType explosionType, VegeType vegeType) {
        this.explosionType = explosionType;
        this.vegeType = vegeType;
    }

	public VegeType getVegeType() {
		return vegeType;
	}

	public ExplosionType getExplosionType() {
		return explosionType;
	}
}
