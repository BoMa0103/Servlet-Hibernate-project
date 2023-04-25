package ua.cn.stu.databean;
import ua.cn.stu.domain.Sign;

public class SignDatabean {
	private static Sign sign;

	public Sign getSign() {
		return sign;
	}

	public static void setSign(Sign newSign) {
		sign = newSign;
	}
}