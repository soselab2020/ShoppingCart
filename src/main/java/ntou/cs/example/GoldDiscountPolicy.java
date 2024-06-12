package ntou.cs.example;

/*
 * Type: Value Object
 */
public class GoldDiscountPolicy implements DiscountPolicy {
	public int calculateTotal(int originalTotal) {
		return (int) (originalTotal * 0.9);
	}
}
