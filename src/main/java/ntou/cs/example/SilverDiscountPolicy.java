package ntou.cs.example;

/*
 * Type: Value Object
 */
public class SilverDiscountPolicy implements DiscountPolicy {
	public int calculateTotal(int originalTotal) {
		return (int) (originalTotal * 0.95);
	}
}
