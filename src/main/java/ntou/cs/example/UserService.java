package ntou.cs.example;

/*
 * Type: Domain Service 
 */
public class UserService {

	public UserService() {
	}

	public DiscountPolicy determineDiscountPolicy(MemberLevel level) {
		if (level == MemberLevel.GOLD) {
			return new GoldDiscountPolicy();
		} else if (level == MemberLevel.DIAMOND) {
			return new DiamondDiscountPolicy();
		} else {
			return new SilverDiscountPolicy();
		}
	}
}
