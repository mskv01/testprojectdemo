package helpers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class DateUtil {
	public static String retornaDataHora() {
		return new SimpleDateFormat("yyyyMddhhmmss").format(Calendar.getInstance().getTime());
	}

	public static String retornaDataHoraFormatado() {
		return new SimpleDateFormat("yyyy-M-dd hh:mm:ss").format(Calendar.getInstance().getTime());
	}

	public static String retornaData() {
		return new SimpleDateFormat("yyyy-M-dd").format(Calendar.getInstance().getTime());
	}

	public static String retornaDataPtBr() {
		return new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
	}

	public static String retornaDataAddMonthPtBr(int month) {
		LocalDate localDate = LocalDate.now().plusMonths(month);
		String[] arr = localDate.toString().split("-", 3);
		return arr[2] + "/" + arr[1] + "/" + arr[0];
	}
}
