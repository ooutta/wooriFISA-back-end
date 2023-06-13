import model.cafe.CafeManager;
import model.cafe.bar.Barista;
import model.cafe.hall.*;

import java.sql.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 일반적인 흐름
 * 손님이 매장에 방문한다. - 손님 객체 생성
 * 손님이 메뉴를 읽는다. - 메뉴 조회
 * 손님이 음료를 주문한다. - Customer - Casher 간 메시징
 * 	- 음료 주문 시, 음료 종류 및 사이즈를 말하고 금액을 지불한다.
 * Casher는 주문받은 주문서를 Baristar에게 넘긴다. - Casher - Baristar 메시징
 * Baristar는 주문 정보를 보고 음료를 제조한다.
 * 음료가 제조되면 Baristar는 음료를 Casher에게 전달한다. - Casher - Baristar
 * 캐셔는 손님에게 전달받은 음료와 쟁반, 영수증 등을 준비해서 주문 상품으로 전달한다.
 *
 * 손님이 음료를 마신다.
 * 사망한다.
 *
 * 등장 인물
 * 1. yoo, yang, lee - 손님
 * 2. kang, kim, koo - 캐셔
 * 3. son, seo - 바리스타
*/
        public class CafeApplication {
            public static void main(String[] args) {

                Customer yoo = CafeManager.getInstance().getCustomers().get(0);
                System.out.println(yoo.getBalance());
                yoo.checkMenu();

    }
}
